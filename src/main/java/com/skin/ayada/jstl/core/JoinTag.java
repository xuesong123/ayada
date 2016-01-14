/*
 * $RCSfile: JoinTag.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-02-19 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.jstl.core;

import java.util.Iterator;

import com.skin.ayada.tagext.TagSupport;

/**
 * <p>Title: JoinTag</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class JoinTag extends TagSupport {
    private Object items;
    private Iterator<?> iterator;
    private Object value;
    private int repeat;
    private String separator;
    private boolean hasItems = false;
    private boolean nullable = false;

    @Override
    public int doStartTag() throws Exception {
        StringBuilder buffer = new StringBuilder();

        if(this.separator == null) {
            this.separator = "";
        }

        if(this.hasItems) {
            Object element = null;
            this.iterator = ForEachTag.getIterator(this.items);

            while(this.iterator.hasNext()) {
                element = this.iterator.next();

                if(element == null) {
                    if(this.nullable) {
                        buffer.append("null");

                        if(this.iterator.hasNext()) {
                            buffer.append(this.separator);
                        }
                    }
                }
                else {
                    buffer.append(element.toString());

                    if(this.iterator.hasNext()) {
                        buffer.append(this.separator);
                    }
                }
            }
        }
        else if(this.value != null && this.repeat > 0){
            for(int i = 0, count = this.repeat - 1; i < count; i++) {
                buffer.append(this.value.toString());
                buffer.append(this.separator);
            }
            buffer.append(this.value.toString());
        }

        if(buffer.length() > 0) {
            this.getPageContext().getOut().write(buffer.toString());
        }
        return super.doStartTag();
    }

    /**
     * @param items the items to set
     */
    public void setItems(Object items) {
        this.items = items;
        this.hasItems = true;
    }

    /**
     * @return the items
     */
    public Object getItems() {
        return this.items;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * @param repeat the repeat to set
     */
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    /**
     * @return the repeat
     */
    public int getRepeat() {
        return this.repeat;
    }

    /**
     * @return the separator
     */
    public String getSeparator() {
        return this.separator;
    }

    /**
     * @param separator the separator to set
     */
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * @return the nullable
     */
    public boolean getNullable() {
        return this.nullable;
    }

    /**
     * @param nullable the nullable to set
     */
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
}
