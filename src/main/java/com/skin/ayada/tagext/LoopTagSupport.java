/**
 * Copyright 1999-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.skin.ayada.tagext;

/***
 * <p>Base support class to facilitate implementation of iteration tags.</p>
 *
 * <p>Since most iteration tags will behave identically with respect to
 * actual iterative behavior, JSTL provides this
 * base support class to facilitate implementation.  Many iteration tags
 * will extend this and merely implement the <tt>hasNext()</tt> and
 * <tt>next()</tt> methods
 * to provide contents for the handler to iterate over.</p>
 *
 * <p>In particular, this base class provides support for:</p>
 *
 * <ul>
 *  <li> Iteration control, based on protected <tt>prepare()</tt>, <tt>next()</tt>,
 *       and <tt>hasNext()</tt> methods
 *  <li> Subsetting (<tt>begin</tt>, <tt>end</tt>, <tt>step></tt>functionality,
 *       including validation
 *       of subset parameters for sensibility)
 *  <li> item retrieval (<tt>getCurrent()</tt>)
 *  <li> status retrieval (<tt>LoopTagStatus</tt>)
 *  <li> exposing attributes (set by <tt>var</tt> and <tt>varStatus</tt> attributes)
 * </ul>
 *
 * <p>In providing support for these tasks, <tt>LoopTagSupport</tt> contains
 * certain control variables that act to modify the iteration.  Accessors
 * are provided for these control variables when the variables represent
 * information needed or wanted at translation time (e.g., <tt>var</tt>,
 * <tt>varStatus</tt>).  For
 * other variables, accessors cannot be provided here since subclasses
 * may differ on their implementations of how those accessors are received.
 * For instance, one subclass might accept a <tt>String</tt> and convert it into
 * an object of a specific type by using an expression evaluator; others
 * might accept objects directly.  Still others might not want to expose
 * such information to outside control.</p>
 *
 * @author Shawn Bayern
 */
@SuppressWarnings("synthetic-access")
public abstract class LoopTagSupport extends TagSupport implements LoopTag, IterationTag, TryCatchFinally {
    /**
     * JavaBean-style properties and other state slaved to them.  These
     * properties can be set directly by accessors; they will not be
     * modified by the LoopTagSupport implementation -- and should
     * not be modified by subclasses outside accessors unless those
     * subclasses are perfectly aware of what they're doing.
     * (An example where such non-accessor modification might be sensible
     * is in the doStartTag() method of an EL-aware subclass.)
     */
    /*** Starting index ('begin' attribute) */
    protected int begin;

    /***
     * Ending index of the iteration ('end' attribute).
     * A value of -1 internally indicates 'no end
     * specified', although accessors for the core JSTL tags do not
     * allow this value to be supplied directly by the user.
     */
    protected int end;

    /*** Iteration step ('step' attribute) */
    protected int step;

    /*** Boolean flag indicating whether 'begin' was specified. */
    protected boolean beginSpecified;

    /*** Boolean flag indicating whether 'end' was specified. */
    protected boolean endSpecified;

    /*** Boolean flag indicating whether 'step' was specified. */
    protected boolean stepSpecified;

    /*** Attribute-exposing control */
    protected String var;

    protected String varStatus;
    //**********************************************************************
    // 'Private' state (implementation details)
    /**
     * State exclusively internal to the default, reference implementation.
     * (While this state is kept private to ensure consistency, 'status'
     * and 'item' happen to have one-for-one, read-only, accesor methods
     * as part of the LoopTag interface.)
     *
     * 'last' is kept separately for two reasons:  (a) to avoid
     * running a computation every time it's requested, and (b) to
     * let LoopTagStatus.isLast() avoid throwing any exceptions,
     * which would complicate subtag and scripting-variable use.
     *
     * Our 'internal index' begins at 0 and increases by 'step' each
     * round; this is arbitrary, but it seemed a simple way of keeping
     * track of the information we need.  To avoid computing
     * getLoopStatus().getCount() by dividing index / step, we keep
     * a separate 'count' and increment it by 1 each round (as a minor
     * performance improvement).
     */
    private LoopTagStatus loopStatus; // our LoopTagStatus
    private Object item; // the current item
    private int index; // the current internal index
    private int count; // the iteration count
    private boolean last; // current round == last one?
    //**********************************************************************
    // Constructor

    /***
     * Constructs a new LoopTagSupport.  As with TagSupport, subclasses
     * should not implement constructors with arguments, and no-arguments
     * constructors implemented by subclasses must call the superclass
     * constructor.
     */
    public LoopTagSupport() {
        super();
        init();
    }

    //**********************************************************************
    // Abstract methods
    /***
     * <p>Returns the next object over which the tag should iterate.  This
     * method must be provided by concrete subclasses of LoopTagSupport
     * to inform the base logic about what objects it should iterate over.</p>
     *
     * <p>It is expected that this method will generally be backed by an
     * Iterator, but this will not always be the case.  In particular, if
     * retrieving the next object raises the possibility of an exception
     * being thrown, this method allows that exception to propagate back
     * to the JSP container as a JspTagException; a standalone Iterator
     * would not be able to do this.  (This explains why LoopTagSupport
     * does not simply call for an Iterator from its subtags.)</p>
     *
     * @return the java.lang.Object to use in the next round of iteration
     * @exception java.util.NoSuchElementException
     *            if next() is called but no new elements are available
     * @exception javax.servlet.jsp.JspTagException
     *            for other, unexpected exceptions
     */
    protected abstract Object next();

    /***
     * <p>Returns information concerning the availability of more items
     * over which to iterate.  This method must be provided by concrete
     * subclasses of LoopTagSupport to assist the iterative logic
     * provided by the supporting base class.</p>
     *
     * <p>See <a href="#next()">next</a> for more information about the
     * purpose and expectations behind this tag.</p>
     *
     * @return <tt>true</tt> if there is at least one more item to iterate
     *         over, <tt>false</tt> otherwise
     * @exception javax.servlet.jsp.JspTagException
     * @see #next
     */
    protected abstract boolean hasNext();

    /***
     * <p>Prepares for a single tag invocation.  Specifically, allows
     * subclasses to prepare for calls to hasNext() and next().
     * Subclasses can assume that prepare() will be called once for
     * each invocation of doStartTag() in the superclass.</p>
     *
     * @exception javax.servlet.jsp.JspTagException
     */
    protected abstract void prepare() throws Exception;

    //**********************************************************************
    // Lifecycle management and implementation of iterative behavior
    /***
     * Releases any resources this LoopTagSupport may have (or inherit).
     */
    @Override
    public void release() {
        super.release();
        init();
    }

    /***
     * Begins iterating by processing the first item.
     */
    @Override
    public int doStartTag() throws Exception {
        if(this.end != -1 && this.begin > this.end) {
            // JSTL 1.1. We simply do not execute the loop.
            return SKIP_BODY;
        }

        // we're beginning a new iteration, so reset our counts (etc.)
        this.index = 0;
        this.count = 1;
        this.last = false;

        // let the subclass conduct any necessary preparation
        this.prepare();

        // throw away the first 'begin' items (if they exist)
        discardIgnoreSubset(this.begin);

        // get the item we're interested in
        if(hasNext()) {
            // index is 0-based, so we don't update it for the first item
            this.item = next();
        }
        else {
            return SKIP_BODY;
        }

        /**
         * now discard anything we have to "step" over.
         * (we do this in advance to support LoopTagStatus.isLast())
         */
        discard(this.step - 1);
        // prepare to include our body...
        exposeVariables();
        calibrateLast();
        return EVAL_BODY_INCLUDE;
    }

    /***
     * Continues the iteration when appropriate -- that is, if we (a) have
     * more items and (b) don't run over our 'end' (given our 'step').
     */
    @Override
    public int doAfterBody() throws Exception {
        // re-sync the index, given our prior behind-the-scenes 'step'
        this.index += this.step - 1;

        // increment the count by 1 for each round
        this.count++;

        // everything's been prepared for us, so just get the next item
        if(hasNext() && !atEnd()) {
            this.index++;
            this.item = next();
        }
        else {
            return SKIP_BODY;
        }

        /**
         * now discard anything we have to "step" over.
         * (we do this in advance to support LoopTagStatus.isLast())
         */
        discard(this.step - 1);

        // prepare to re-iterate...
        exposeVariables();
        calibrateLast();
        return EVAL_BODY_AGAIN;
    }

    /***
     * Removes any attributes that this LoopTagSupport set.
     *
     * <p> These attributes are intended to support scripting variables with
     * NESTED scope, so we don't want to pollute attribute space by leaving
     * them lying around.
     */
    @Override
    public void doFinally() {
        /**
         * Make sure to un-expose variables, restoring them to their
         * prior values, if applicable.
         */
        unExposeVariables();
    }

    /***
     * Rethrows the given Throwable.
     */
    @Override
    public void doCatch(Throwable throwable) throws Throwable {
        throw throwable;
    }

    //**********************************************************************
    // Accessor methods
    /**
     * Overview:  The getXXX() methods we provide implement the Tag
     * contract.  setXXX() accessors are provided only for those
     * properties (attributes) that must be known at translation time,
     * on the premise that these accessors will vary less than the
     * others in terms of their interface with the page author.
     */
    /**
     * (Purposely inherit JavaDoc and semantics from LoopTag.
     * Subclasses can override this if necessary, but such a need is
     * expected to be rare.)
     * @return Object
     */
    @Override
    public Object getCurrent() {
        return this.item;
    }

    /**
     * (Purposely inherit JavaDoc and semantics from LoopTag.
     * Subclasses can override this method for more fine-grained control
     * over LoopTagStatus, but an effort has been made to simplify
     * implementation of subclasses that are happy with reasonable default
     * behavior.)
     * @return LoopTagStatus
     */
    @Override
    public LoopTagStatus getLoopStatus() {
        // local implementation with reasonable default behavior
        class Status implements LoopTagStatus {
            /**
             * All our methods are straightforward.  We inherit
             * our JavaDoc from LoopTagSupport; see that class
             * for more information.
             */
            @Override
            public Object getCurrent() {
                /**
                 * Access the item through getCurrent() instead of just
                 * returning the item our containing class stores.  This
                 * should allow a subclass of LoopTagSupport to override
                 * getCurrent() without having to rewrite getLoopStatus() too.
                 */
                return (LoopTagSupport.this.getCurrent());
            }

            @Override
            public int getIndex() {
                return (LoopTagSupport.this.index + LoopTagSupport.this.begin); // our 'index' isn't getIndex()
            }

            @Override
            public int getCount() {
                return (LoopTagSupport.this.count);
            }

            @Override
            public boolean isFirst() {
                return (LoopTagSupport.this.index == 0); // our 'index' isn't getIndex()
            }

            @Override
            public boolean isLast() {
                return LoopTagSupport.this.last; // use cached value
            }

            @Override
            public Integer getBegin() {
                if(LoopTagSupport.this.beginSpecified) {
                    return Integer.valueOf(LoopTagSupport.this.begin);
                }
                else {
                    return null;
                }
            }

            @Override
            public Integer getEnd() {
                if(LoopTagSupport.this.endSpecified) {
                    return Integer.valueOf(LoopTagSupport.this.end);
                }
                else {
                    return null;
                }
            }

            @Override
            public Integer getStep() {
                if(LoopTagSupport.this.stepSpecified) {
                    return Integer.valueOf(LoopTagSupport.this.step);
                }
                else {
                    return null;
                }
            }
        }
        /**
         * We just need one per invocation...  Actually, for the current
         * implementation, we just need one per instance, but I'd rather
         * not keep the reference around once release() has been called.
         */
        if(this.loopStatus == null) {
            this.loopStatus = new Status();
        }
        return this.loopStatus;
    }

    /**
     * We only support setter methods for attributes that need to be
     * offered as Strings or other literals; other attributes will be
     * handled directly by implementing classes, since there might be
     * both rtexprvalue- and EL-based varieties, which will have
     * different signatures.  (We can't pollute child classes by having
     * base implementations of those setters here; child classes that
     * have attributes with different signatures would end up having
     * two incompatible setters, which is illegal for a JavaBean.
     */
    /***
     * Sets the 'var' attribute.
     * @param var Name of the exported scoped variable storing the current item of the iteration.
     */
    public void setVar(String var) {
        this.var = var;
    }

    /***
     * Sets the 'varStatus' attribute.
     * @param varStatus Name of the exported scoped variable storing the status of the iteration.
     */
    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }

    //**********************************************************************
    // Protected utility methods
    /**
     * These methods validate attributes common to iteration tags.
     * Call them if your own subclassing implementation modifies them
     * -- e.g., if you set them through an expression language.
     */
    /***
     * Ensures the "begin" property is sensible, throwing an exception
     * expected to propagate up if it isn't
     */
    protected void validateBegin() throws Exception {
        if(this.begin < 0) {
            throw new Exception("'begin' < 0");
        }
    }

    /***
     * Ensures the "end" property is sensible, throwing an exception
     * expected to propagate up if it isn't
     */
    protected void validateEnd() throws Exception {
        if(this.end < 0) {
            throw new Exception("'end' < 0");
        }
    }

    /***
     * Ensures the "step" property is sensible, throwing an exception
     * expected to propagate up if it isn't
     */
    protected void validateStep() throws Exception {
        if(this.step < 1) {
            throw new Exception("'step' <= 0");
        }
    }

    //**********************************************************************
    // Private utility methods
    /*** (Re)initializes state (during release() or construction) */
    private void init() {
        // defaults for internal bookkeeping
        this.index = 0; // internal index always starts at 0
        this.count = 1; // internal count always starts at 1
        this.loopStatus = null; // we clear status on release()
        this.item = null; // item will be retrieved for each round
        this.last = false; // last must be set explicitly
        this.beginSpecified = false; // not specified until it's specified :-)
        this.endSpecified = false; // (as above)
        this.stepSpecified = false; // (as above)
        // defaults for interface with page author
        this.begin = 0; // when not specified, 'begin' is 0 by spec.
        this.end = -1; // when not specified, 'end' is not used
        this.step = 1; // when not specified, 'step' is 1
        this.var = null; // when not specified, no variable exported
        this.varStatus = null; // when not specified, no variable exported
    }

    /**
     * Sets 'last' appropriately.
     * @throws Exception
     */
    private void calibrateLast() throws Exception {
        /**
         * the current round is the last one if (a) there are no remaining
         * elements, or (b) the next one is beyond the 'end'.
         */
        this.last = !hasNext() || atEnd() || (this.end != -1 && (this.begin + this.index + this.step > this.end));
    }

    /***
     * Exposes attributes (formerly scripting variables, but no longer!)
     * if appropriate.  Note that we don't really care, here, whether they're
     * scripting variables or not.
     * @throws Exception
     */
    private void exposeVariables() throws Exception {
        /**
         * We need to support null items returned from next(); we
         * do this simply by passing such non-items through to the
         * scoped variable as effectively 'null' (that is, by calling
         * removeAttribute()).
         *
         * Also, just to be defensive, we handle the case of a null
         * 'status' object as well.
         *
         * We call getCurrent() and getLoopStatus() (instead of just using
         * 'item' and 'status') to bridge to subclasses correctly.
         * A subclass can override getCurrent() or getLoopStatus() but still
         * depend on our doStartTag() and doAfterBody(), which call this
         * method (exposeVariables()), to expose 'item' and 'status'
         * correctly.
         */
        if(this.var != null) {
            this.pageContext.setAttribute(this.var, this.getCurrent());
        }
        if(this.varStatus != null) {
            this.pageContext.setAttribute(this.varStatus, this.getLoopStatus());
        }
    }

    /***
     * Removes page attributes that we have exposed and, if applicable,
     * restores them to their prior values (and scopes).
     */
    private void unExposeVariables() {
        if(this.var != null) {
            this.pageContext.setAttribute(this.var, null);
        }
        if(this.varStatus != null) {
            this.pageContext.setAttribute(this.varStatus, null);
        }
    }

    /***
     * Cycles through and discards up to 'n' items from the iteration.
     * We only know "up to 'n'", not "exactly n," since we stop cycling
     * if hasNext() returns false or if we hit the 'end' of the iteration.
     * Note: this does not update the iteration index, since this method
     * is intended as a behind-the-scenes operation.  The index must be
     * updated separately.  (I don't really like this, but it's the simplest
     * way to support isLast() without storing two separate inconsistent
     * indices.  We need to (a) make sure hasNext() refers to the next
     * item we actually *want* and (b) make sure the index refers to the
     * item associated with the *current* round, not the next one.
     * C'est la vie.)
     * @throws Exception
     */
    private void discard(int n) throws Exception {
        /**
         * copy index so we can restore it, but we need to update it
         * as we work so that atEnd() works
         */
        int i = n;
        int oldIndex = this.index;
        while(i-- > 0 && !atEnd() && hasNext()) {
            this.index++;
            next();
        }
        this.index = oldIndex;
    }

    /***
     * Discards items ignoring subsetting rules.  Useful for discarding
     * items from the beginning (i.e., to implement 'begin') where we
     * don't want factor in the 'begin' value already.
     * @throws Exception
     */
    private void discardIgnoreSubset(int n) throws Exception {
        int i = n;
        while(i-- > 0 && hasNext()) {
            this.next();
        }
    }

    /***
     * Returns true if the iteration has past the 'end' index (with
     * respect to subsetting), false otherwise.  ('end' must be set
     * for atEnd() to return true; if 'end' is not set, atEnd()
     * always returns false.)
     */
    private boolean atEnd() {
        return ((this.end != -1) && (this.begin + this.index >= this.end));
    }
}
