/*
 * $RCSfile: LayoutTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /tags/layout.jsp
 * lastModified: 2015-12-30 10:34:28 000
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:17:05 093)
 */
package _tpl._jsp._tags;

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
 * <p>Title: LayoutTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class LayoutTemplate extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        LayoutTemplate template = new LayoutTemplate();

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
        // out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n<title>");
        out.write(_jsp_string_1, 0, _jsp_string_1.length);

        // NODE START: lineNumber: 5, offset: 1, length: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_2
        // <c:out value=\"${title}\"/>
        com.skin.ayada.jstl.core.OutTag.write(out, pageContext.getAttribute("title"), false);
        // out.print(ExpressionUtil.getString(expressionContext, "${title}"));
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 5, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_2

        // TEXT: lineNumber: 5
        // out.write("</title>\r\n<meta name=\"keywords\" content=\"ayada\"/>\r\n<meta name=\"description\" content=\"ayada\"/>\r\n<meta name=\"robots\" content=\"all\"/>\r\n<meta name=\"googlebot\" content=\"all\"/>\r\n<meta name=\"baiduspider\" content=\"all\"/>\r\n<meta name=\"copyright\" content=\"ayada\"/>\r\n</head>\r\n<body>\r\n<div class=\"wrap\">\r\n    <div class=\"header\">\r\n        ");
        out.write(_jsp_string_4, 0, _jsp_string_4.length);

        // NODE START: lineNumber: 16, offset: 4, length: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_5
        // <c:out value=\"${header}\"/>
        com.skin.ayada.jstl.core.OutTag.write(out, pageContext.getAttribute("header"), false);
        // out.print(ExpressionUtil.getString(expressionContext, "${header}"));
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 16, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_5

        // TEXT: lineNumber: 16
        // out.write("\r\n    </div>\r\n</div>\r\n<div class=\"wrap\">\r\n    <div class=\"body\">\r\n        ");
        out.write(_jsp_string_7, 0, _jsp_string_7.length);

        // NODE START: lineNumber: 21, offset: 7, length: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_8
        // <c:out value=\"${body}\"/>
        com.skin.ayada.jstl.core.OutTag.write(out, pageContext.getAttribute("body"), false);
        // out.print(ExpressionUtil.getString(expressionContext, "${body}"));
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 21, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_8

        // TEXT: lineNumber: 21
        // out.write("\r\n    </div>\r\n</div>\r\n<div class=\"wrap\">\r\n    <div class=\"footer\">\r\n        ");
        out.write(_jsp_string_10, 0, _jsp_string_10.length);

        // NODE START: lineNumber: 26, offset: 10, length: 2, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_11
        // <c:out value=\"${footer}\"/>
        com.skin.ayada.jstl.core.OutTag.write(out, pageContext.getAttribute("footer"), false);
        // out.print(ExpressionUtil.getString(expressionContext, "${footer}"));
        // jsp.jstl.core.OutTag END
        // NODE END: lineNumber: 26, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_11

        // TEXT: lineNumber: 26
        // out.write("\r\n    </div>\r\n</div>\r\n</body>\r\n</html>");
        out.write(_jsp_string_13, 0, _jsp_string_13.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n<title>".toCharArray();
    public static final char[] _jsp_string_4 = "</title>\r\n<meta name=\"keywords\" content=\"ayada\"/>\r\n<meta name=\"description\" content=\"ayada\"/>\r\n<meta name=\"robots\" content=\"all\"/>\r\n<meta name=\"googlebot\" content=\"all\"/>\r\n<meta name=\"baiduspider\" content=\"all\"/>\r\n<meta name=\"copyright\" content=\"ayada\"/>\r\n</head>\r\n<body>\r\n<div class=\"wrap\">\r\n    <div class=\"header\">\r\n        ".toCharArray();
    public static final char[] _jsp_string_7 = "\r\n    </div>\r\n</div>\r\n<div class=\"wrap\">\r\n    <div class=\"body\">\r\n        ".toCharArray();
    public static final char[] _jsp_string_10 = "\r\n    </div>\r\n</div>\r\n<div class=\"wrap\">\r\n    <div class=\"footer\">\r\n        ".toCharArray();
    public static final char[] _jsp_string_13 = "\r\n    </div>\r\n</div>\r\n</body>\r\n</html>".toCharArray();

}
