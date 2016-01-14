/*
 * $RCSfile: StacktraceTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /stacktrace.jsp
 * lastModified: 2013-11-28 17:32:16 000
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:17:04 974)
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
 * <p>Title: StacktraceTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class StacktraceTemplate extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        StacktraceTemplate template = new StacktraceTemplate();

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
        // TEXT: lineNumber: 2
        // out.write("<html>\r\n<head>\r\n<title>test</title>\r\n<script type=\"text/javascript\" src=\"");
        out.write(_jsp_string_1, 0, _jsp_string_1.length);
        // VARIABLE: lineNumber: 5
        expressionContext.print(out, pageContext.getAttribute("resource"));
        // TEXT: lineNumber: 5
        // out.write("/js/jquery-1.4.2.min.js\"></script>\r\n</head>\r\n<body version=\"1.0\">\r\n");
        out.write(_jsp_string_3, 0, _jsp_string_3.length);
        // EXPRESSION: lineNumber: 8
        expressionContext.print(out, expressionContext.getString("user.userName"));
        // TEXT: lineNumber: 8
        // out.write("\r\n");
        out.write(_jsp_string_5, 0, _jsp_string_5.length);

        // NODE START: lineNumber: 9, offset: 5, length: 22, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_6
        // <c:if test=\"${1 == 1}\">...</c:if>
        if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
            // NODE START: lineNumber: 10, offset: 6, length: 20, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_7
            // <c:if test=\"${1 == 1}\">...</c:if>
            if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                // NODE START: lineNumber: 11, offset: 7, length: 18, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_8
                // <c:if test=\"${1 == 1}\">...</c:if>
                if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                    // NODE START: lineNumber: 12, offset: 8, length: 16, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_9
                    // <c:if test=\"${1 == 1}\">...</c:if>
                    if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                        // NODE START: lineNumber: 13, offset: 9, length: 14, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_10
                        // <c:if test=\"${1 == 1}\">...</c:if>
                        if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                            // NODE START: lineNumber: 14, offset: 10, length: 12, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_11
                            // <c:if test=\"${1 == 1}\">...</c:if>
                            if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                                // NODE START: lineNumber: 15, offset: 11, length: 10, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_12
                                // <c:if test=\"${1 == 1}\">...</c:if>
                                if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                                    // NODE START: lineNumber: 16, offset: 12, length: 8, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_13
                                    // <c:if test=\"${1 == 1}\">...</c:if>
                                    if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                                        // NODE START: lineNumber: 17, offset: 13, length: 6, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_14
                                        // <c:if test=\"${1 == 1}\">...</c:if>
                                        if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                                            // NODE START: lineNumber: 18, offset: 14, length: 4, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_15
                                            // <c:if test=\"${1 == 1}\">...</c:if>
                                            if(ExpressionUtil.getBoolean(expressionContext, "${1 == 1}")) {
                                                // NODE START: lineNumber: 20, offset: 15, length: 2, tagClassName: com.skin.ayada.jstl.core.StackTraceTag, tagInstanceName: _jsp_StackTraceTag_16
                                                // <c:stackTrace/>
                                                com.skin.ayada.jstl.core.StackTraceTag _jsp_StackTraceTag_16 = new com.skin.ayada.jstl.core.StackTraceTag();
                                                _jsp_StackTraceTag_16.setPageContext(pageContext);
                                                _jsp_StackTraceTag_16.setParent((Tag)null);
                                                int _jsp_start_flag_16 = _jsp_StackTraceTag_16.doStartTag();

                                                if(_jsp_start_flag_16 == Tag.SKIP_PAGE) {
                                                    return;
                                                }
                                                if(_jsp_start_flag_16 != Tag.SKIP_BODY) {
                                                    _jsp_StackTraceTag_16.doAfterBody();
                                                }
                                                _jsp_StackTraceTag_16.doEndTag();
                                                _jsp_StackTraceTag_16.release();
                                                // NODE END: lineNumber: 20, tagClassName: com.skin.ayada.jstl.core.StackTraceTag, tagInstanceName: _jsp_StackTraceTag_16

                                            } // jsp.jstl.core.IfTag END
                                            // NODE END: lineNumber: 18, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_15

                                        } // jsp.jstl.core.IfTag END
                                        // NODE END: lineNumber: 17, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_14

                                    } // jsp.jstl.core.IfTag END
                                    // NODE END: lineNumber: 16, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_13

                                } // jsp.jstl.core.IfTag END
                                // NODE END: lineNumber: 15, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_12

                            } // jsp.jstl.core.IfTag END
                            // NODE END: lineNumber: 14, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_11

                        } // jsp.jstl.core.IfTag END
                        // NODE END: lineNumber: 13, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_10

                    } // jsp.jstl.core.IfTag END
                    // NODE END: lineNumber: 12, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_9

                } // jsp.jstl.core.IfTag END
                // NODE END: lineNumber: 11, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_8

            } // jsp.jstl.core.IfTag END
            // NODE END: lineNumber: 10, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_7

        } // jsp.jstl.core.IfTag END
        // NODE END: lineNumber: 9, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_6

        // TEXT: lineNumber: 30
        // out.write("\r\n");
        out.write(_jsp_string_28, 0, _jsp_string_28.length);

        // NODE START: lineNumber: 32, offset: 28, length: 2, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_29
        // <c:if test=\"${user.userName == &#39;xuesong.net&#39;}\">...</c:if>
        if(ExpressionUtil.getBoolean(expressionContext, "${user.userName == \'xuesong.net\'}")) {
        } // jsp.jstl.core.IfTag END
        // NODE END: lineNumber: 32, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_29

        // NODE START: lineNumber: 33, offset: 30, length: 3, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_31
        // <c:each items=\"${userList}\" var=\"user\">...</c:each>
        Object _jsp_old_var_31 = pageContext.getAttribute("user");
        com.skin.ayada.jstl.core.ForEachTag _jsp_ForEachTag_31 = new com.skin.ayada.jstl.core.ForEachTag();
        _jsp_ForEachTag_31.setParent((Tag)null);
        _jsp_ForEachTag_31.setPageContext(pageContext);
        _jsp_ForEachTag_31.setVar("user");
        _jsp_ForEachTag_31.setItems(pageContext.getAttribute("userList"));
        if(_jsp_ForEachTag_31.doStartTag() != Tag.SKIP_BODY) {
            while(true) {
                // EXPRESSION: lineNumber: 33
                expressionContext.print(out, expressionContext.getString("user.userName"));
                if(_jsp_ForEachTag_31.doAfterBody() != IterationTag.EVAL_BODY_AGAIN) {
                    break;
                }
            }
        }
        _jsp_ForEachTag_31.release();
        pageContext.setAttribute("user", _jsp_old_var_31);
        // jsp.jstl.core.ForEachTag END
        // NODE END: lineNumber: 33, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_31

        // EXPRESSION: lineNumber: 34
        expressionContext.print(out, expressionContext.getString("user.userName"));
        // TEXT: lineNumber: 34
        // out.write("\r\n< test1\r\n\r\n</ test2 >\r\n\r\n</test3  >\r\n\r\n</body>\r\n</html>");
        out.write(_jsp_string_35, 0, _jsp_string_35.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_1 = "<html>\r\n<head>\r\n<title>test</title>\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    public static final char[] _jsp_string_3 = "/js/jquery-1.4.2.min.js\"></script>\r\n</head>\r\n<body version=\"1.0\">\r\n".toCharArray();
    public static final char[] _jsp_string_5 = "\r\n".toCharArray();
    public static final char[] _jsp_string_28 = "\r\n".toCharArray();
    public static final char[] _jsp_string_35 = "\r\n< test1\r\n\r\n</ test2 >\r\n\r\n</test3  >\r\n\r\n</body>\r\n</html>".toCharArray();

}
