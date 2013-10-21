/*
 * $RCSfile: JspFactory.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-2-19  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.runtime;

import java.io.BufferedWriter;
import java.io.Writer;

import com.skin.ayada.jstl.TagLibrary;
import com.skin.ayada.jstl.TagLibraryFactory;
import com.skin.ayada.template.TemplateContext;

/**
 * <p>Title: JspFactory</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class JspFactory
{
    /**
     * @param out
     * @return PageContext
     */
    public static PageContext getPageContext(Writer out)
    {
        JspWriter jspWriter = new JspWriter(new BufferedWriter(out, 4096));
        DefaultPageContext pageContext = new DefaultPageContext(jspWriter);
        ExpressionContext expressionContext = ExpressionFactory.getExpressionContext(pageContext);
        TagLibrary tagLibrary = TagLibraryFactory.getStandardTagLibrary();
        pageContext.setExpressionContext(expressionContext);
        pageContext.setTagLibrary(tagLibrary);
        return pageContext;
    }

    /**
     * @param out
     * @return PageContext
     */
    public static PageContext getPageContext(TemplateContext templateContext, Writer out)
    {
        JspWriter jspWriter = new JspWriter(new BufferedWriter(out, 4096));
        DefaultPageContext pageContext = new DefaultPageContext(jspWriter);
        ExpressionContext expressionContext = ExpressionFactory.getExpressionContext(pageContext);
        TagLibrary tagLibrary = TagLibraryFactory.getStandardTagLibrary();
        pageContext.setTagLibrary(tagLibrary);
        pageContext.setTemplateContext(templateContext);
        pageContext.setExpressionContext(expressionContext);
        return pageContext;
    }
}
