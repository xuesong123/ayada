/*
 * $RCSfile: OutTest2Template.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /outTest2.jsp
 * lastModified: 2014-07-20 15:33:58 208
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:17:04 009)
 */
package _tpl._jsp;

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
 * <p>Title: OutTest2Template</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class OutTest2Template extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        OutTest2Template template = new OutTest2Template();

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
        // NODE START: lineNumber: 1, offset: 0, length: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_1
        // <c:out value=\"123\"/>
        com.skin.ayada.jstl.core.OutTag.write(out, 123, false);
        // out.print(123);
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 1, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_1

        // TEXT: lineNumber: 1
        // out.write("\r\n");
        out.write(_jsp_string_3, 0, _jsp_string_3.length);

        // NODE START: lineNumber: 2, offset: 3, length: 3, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_4
        // <c:out>...</c:out>
        out = pageContext.pushBody();
        // TEXT: lineNumber: 2
        // out.write("abc");
        out.write(_jsp_string_5, 0, _jsp_string_5.length);
        pageContext.print((BodyContent)out, false);
        out = pageContext.popBody();
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_4

        // TEXT: lineNumber: 2
        // out.write("\r\n");
        out.write(_jsp_string_7, 0, _jsp_string_7.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_3 = "\r\n".toCharArray();
    public static final char[] _jsp_string_5 = "abc".toCharArray();
    public static final char[] _jsp_string_7 = "\r\n".toCharArray();

}
