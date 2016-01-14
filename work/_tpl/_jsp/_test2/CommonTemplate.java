/*
 * $RCSfile: CommonTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /test2/common.jsp
 * lastModified: 2013-02-28 11:44:56 000
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:17:06 697)
 */
package _tpl._jsp._test2;

import java.io.Writer;
import com.skin.ayada.runtime.ExpressionContext;
import com.skin.ayada.runtime.JspWriter;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.tagext.BodyContent;
import com.skin.ayada.tagext.BodyTag;
import com.skin.ayada.tagext.IterationTag;
import com.skin.ayada.tagext.JspFragment;
import com.skin.ayada.tagext.Tag;
import com.skin.ayada.template.JspTemplate;
import com.skin.ayada.util.ExpressionUtil;


/**
 * <p>Title: CommonTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class CommonTemplate extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        CommonTemplate template = new CommonTemplate();

        try {
            template.execute(pageContext);
            System.out.println(writer.toString());
        }
        catch(Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * @param pageContext
     * @throws Throwable
     */
    @Override
    @SuppressWarnings("unchecked")
    public void _execute(final PageContext pageContext) throws Throwable {
        JspWriter out = pageContext.getOut();
        JspWriter jspWriter = pageContext.getOut();
        ExpressionContext expressionContext = pageContext.getExpressionContext();
        // TEXT: lineNumber: 1
        // out.write("<div style=\"height: 200px;\">\r\n    <ul>\r\n        <li>menu1</li>\r\n        <li>menu2</li>\r\n        <li>menu3</li>\r\n        <li>menu4</li>\r\n        <li>menu5</li>\r\n    </ul>\r\n</div>");
        out.write(_jsp_string_1, 0, _jsp_string_1.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_1 = "<div style=\"height: 200px;\">\r\n    <ul>\r\n        <li>menu1</li>\r\n        <li>menu2</li>\r\n        <li>menu3</li>\r\n        <li>menu4</li>\r\n        <li>menu5</li>\r\n    </ul>\r\n</div>".toCharArray();

}
