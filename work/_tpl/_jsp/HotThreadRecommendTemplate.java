/*
 * $RCSfile: HotThreadRecommendTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-09-24 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/fmbak/webapp/views/include/index
 * path: hotThreadRecommend.jsp
 * lastModified: 2013-12-21 13:45:18 172
 * options: -fastJstl true
 * template.dependencies
 * -- /hotThreadRecommend.jsp
 *
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-09-24 01:27:14 157)
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
 * <p>Title: HotThreadRecommendTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class HotThreadRecommendTemplate extends JspTemplate {
    /**
     * @param args
     */
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        HotThreadRecommendTemplate template = new HotThreadRecommendTemplate();

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
        // jsp:directive.page: lineNumber: 1
        // <jsp:directive.page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"/>

        // jsp:directive.taglib: lineNumber: 2
        // <jsp:directive.taglib taglib="" prefix="c" uri="http://java.sun.com/jsp/jstl/core"/>

        // jsp:directive.taglib: lineNumber: 3
        // <jsp:directive.taglib taglib="" prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"/>

        // TEXT: lineNumber: 3
        // out.write("<div class=\"panel hotthread\" style=\"height: 300px;\">\r\n    <div class=\"title\"><h4>论坛热帖</h4></div>\r\n    <div>\r\n        <div class=\"left\">\r\n            <div style=\"padding: 0px 10px 10px 10px;\">\r\n");
        out.write(_jsp_string_7, 0, _jsp_string_7.length);

        // NODE START: lineNumber: 9, offset: 7, length: 17, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_8
        // <c:forEach items=\"${recommendList}\" var=\"recommend\" varStatus=\"status\">...</c:forEach>
        Object _jsp_old_var_8 = pageContext.getAttribute("recommend");
        Object _jsp_old_var_status_8 = pageContext.getAttribute("status");
        com.skin.ayada.jstl.core.ForEachTag _jsp_ForEachTag_8 = new com.skin.ayada.jstl.core.ForEachTag();
        _jsp_ForEachTag_8.setParent((Tag)null);
        _jsp_ForEachTag_8.setPageContext(pageContext);
        _jsp_ForEachTag_8.setVar("recommend");
        _jsp_ForEachTag_8.setItems(pageContext.getAttribute("recommendList"));
        _jsp_ForEachTag_8.setVarStatus("status");
        if(_jsp_ForEachTag_8.doStartTag() != Tag.SKIP_BODY) {
            while(true) {
                // NODE START: lineNumber: 10, offset: 8, length: 15, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_9
                // <c:if test=\"${status.index &lt; 2}\">...</c:if>
                if(ExpressionUtil.getBoolean(expressionContext, "${status.index < 2}")) {
                    // TEXT: lineNumber: 10
                    // out.write("                <h3 style=\"margin: 10px 0px;\">\r\n                    <a href=\"");
                    out.write(_jsp_string_10, 0, _jsp_string_10.length);
                    // EXPRESSION: lineNumber: 12
                    expressionContext.print(out, expressionContext.getString("recommend.linkUrl"));
                    // TEXT: lineNumber: 12
                    // out.write("\" target=\"_blank\">");
                    out.write(_jsp_string_12, 0, _jsp_string_12.length);

                    // NODE START: lineNumber: 12, offset: 12, length: 4, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_13
                    // <c:out escapeXml=\"true\">...</c:out>
                    out = pageContext.pushBody();
                    // NODE START: lineNumber: 12, offset: 13, length: 2, tagClassName: com.skin.ayada.jstl.fmt.SubstringTag, tagInstanceName: _jsp_SubstringTag_14
                    // <f:substring value=\"${recommend.title}\" length=\"40\" padding=\"...\"/>
                    com.skin.ayada.jstl.fmt.SubstringTag _jsp_SubstringTag_14 = new com.skin.ayada.jstl.fmt.SubstringTag();
                    _jsp_SubstringTag_14.setPageContext(pageContext);
                    _jsp_SubstringTag_14.setParent(_jsp_OutTag_13);
                    _jsp_SubstringTag_14.setValue(ExpressionUtil.getString(expressionContext, "${recommend.title}"));
                    _jsp_SubstringTag_14.setLength(40);
                    _jsp_SubstringTag_14.setPadding("...");
                    int _jsp_start_flag_14 = _jsp_SubstringTag_14.doStartTag();

                    if(_jsp_start_flag_14 == Tag.SKIP_PAGE) {
                        return;
                    }
                    if(_jsp_start_flag_14 != Tag.SKIP_BODY) {
                        _jsp_SubstringTag_14.doAfterBody();
                    }
                    _jsp_SubstringTag_14.doEndTag();
                    _jsp_SubstringTag_14.release();
                    // NODE END: lineNumber: 12, tagClassName: com.skin.ayada.jstl.fmt.SubstringTag, tagInstanceName: _jsp_SubstringTag_14

                    pageContext.print((BodyContent)out, true);
                    out = pageContext.popBody();
                    // jsp.jstl.core.OutTag END
                    // NODE END: lineNumber: 12, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_13

                    // TEXT: lineNumber: 12
                    // out.write("</a>\r\n                </h3>\r\n                <div style=\"height: 100px; line-height: 20px; overflow: hidden;\">");
                    out.write(_jsp_string_17, 0, _jsp_string_17.length);

                    // NODE START: lineNumber: 14, offset: 17, length: 4, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_18
                    // <c:out escapeXml=\"true\">...</c:out>
                    out = pageContext.pushBody();
                    // NODE START: lineNumber: 14, offset: 18, length: 2, tagClassName: com.skin.ayada.jstl.fmt.SubstringTag, tagInstanceName: _jsp_SubstringTag_19
                    // <f:substring value=\"${recommend.summary}\" length=\"248\" padding=\"...\"/>
                    com.skin.ayada.jstl.fmt.SubstringTag _jsp_SubstringTag_19 = new com.skin.ayada.jstl.fmt.SubstringTag();
                    _jsp_SubstringTag_19.setPageContext(pageContext);
                    _jsp_SubstringTag_19.setParent(_jsp_OutTag_18);
                    _jsp_SubstringTag_19.setValue(ExpressionUtil.getString(expressionContext, "${recommend.summary}"));
                    _jsp_SubstringTag_19.setLength(248);
                    _jsp_SubstringTag_19.setPadding("...");
                    int _jsp_start_flag_19 = _jsp_SubstringTag_19.doStartTag();

                    if(_jsp_start_flag_19 == Tag.SKIP_PAGE) {
                        return;
                    }
                    if(_jsp_start_flag_19 != Tag.SKIP_BODY) {
                        _jsp_SubstringTag_19.doAfterBody();
                    }
                    _jsp_SubstringTag_19.doEndTag();
                    _jsp_SubstringTag_19.release();
                    // NODE END: lineNumber: 14, tagClassName: com.skin.ayada.jstl.fmt.SubstringTag, tagInstanceName: _jsp_SubstringTag_19

                    pageContext.print((BodyContent)out, true);
                    out = pageContext.popBody();
                    // jsp.jstl.core.OutTag END
                    // NODE END: lineNumber: 14, tagClassName: com.skin.ayada.jstl.core.OutTag, tagInstanceName: _jsp_OutTag_18

                    // TEXT: lineNumber: 14
                    // out.write("</div>\r\n");
                    out.write(_jsp_string_22, 0, _jsp_string_22.length);
                } // jsp.jstl.core.IfTag END
                // NODE END: lineNumber: 10, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_9

                if(_jsp_ForEachTag_8.doAfterBody() != IterationTag.EVAL_BODY_AGAIN) {
                    break;
                }
            }
        }
        _jsp_ForEachTag_8.release();
        pageContext.setAttribute("recommend", _jsp_old_var_8);
        pageContext.setAttribute("status", _jsp_old_var_status_8);
        // jsp.jstl.core.ForEachTag END
        // NODE END: lineNumber: 9, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_8

        // TEXT: lineNumber: 16
        // out.write("            </div>\r\n        </div>\r\n        <div class=\"right\">\r\n            <div class=\"pad10\">\r\n                <ul>\r\n");
        out.write(_jsp_string_25, 0, _jsp_string_25.length);

        // NODE START: lineNumber: 22, offset: 25, length: 9, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_26
        // <c:forEach items=\"${recommendList}\" var=\"recommend\" varStatus=\"status\">...</c:forEach>
        Object _jsp_old_var_26 = pageContext.getAttribute("recommend");
        Object _jsp_old_var_status_26 = pageContext.getAttribute("status");
        com.skin.ayada.jstl.core.ForEachTag _jsp_ForEachTag_26 = new com.skin.ayada.jstl.core.ForEachTag();
        _jsp_ForEachTag_26.setParent((Tag)null);
        _jsp_ForEachTag_26.setPageContext(pageContext);
        _jsp_ForEachTag_26.setVar("recommend");
        _jsp_ForEachTag_26.setItems(pageContext.getAttribute("recommendList"));
        _jsp_ForEachTag_26.setVarStatus("status");
        if(_jsp_ForEachTag_26.doStartTag() != Tag.SKIP_BODY) {
            while(true) {
                // NODE START: lineNumber: 23, offset: 26, length: 7, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_27
                // <c:if test=\"${status.index &gt; 1 &amp;&amp; status.index &lt; 15}\">...</c:if>
                if(ExpressionUtil.getBoolean(expressionContext, "${status.index > 1 && status.index < 15}")) {
                    // TEXT: lineNumber: 23
                    // out.write("<li>· <a href=\"");
                    out.write(_jsp_string_28, 0, _jsp_string_28.length);
                    // EXPRESSION: lineNumber: 23
                    expressionContext.print(out, expressionContext.getString("recommend.linkUrl"));
                    // TEXT: lineNumber: 23
                    // out.write("\" target=\"_blank\">");
                    out.write(_jsp_string_30, 0, _jsp_string_30.length);
                    // EXPRESSION: lineNumber: 23
                    expressionContext.print(out, expressionContext.getString("StringUtil.substring(recommend.title, 48, \"...\")"));
                    // TEXT: lineNumber: 23
                    // out.write("</a></li>");
                    out.write(_jsp_string_32, 0, _jsp_string_32.length);
                } // jsp.jstl.core.IfTag END
                // NODE END: lineNumber: 23, tagClassName: com.skin.ayada.jstl.core.IfTag, tagInstanceName: _jsp_IfTag_27

                if(_jsp_ForEachTag_26.doAfterBody() != IterationTag.EVAL_BODY_AGAIN) {
                    break;
                }
            }
        }
        _jsp_ForEachTag_26.release();
        pageContext.setAttribute("recommend", _jsp_old_var_26);
        pageContext.setAttribute("status", _jsp_old_var_status_26);
        // jsp.jstl.core.ForEachTag END
        // NODE END: lineNumber: 22, tagClassName: com.skin.ayada.jstl.core.ForEachTag, tagInstanceName: _jsp_ForEachTag_26

        // TEXT: lineNumber: 24
        // out.write("                </ul>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>");
        out.write(_jsp_string_35, 0, _jsp_string_35.length);

        out.flush();
        jspWriter.flush();
    }

    protected static final char[] _jsp_string_7 = "<div class=\"panel hotthread\" style=\"height: 300px;\">\r\n    <div class=\"title\"><h4>论坛热帖</h4></div>\r\n    <div>\r\n        <div class=\"left\">\r\n            <div style=\"padding: 0px 10px 10px 10px;\">\r\n".toCharArray();
    protected static final char[] _jsp_string_10 = "                <h3 style=\"margin: 10px 0px;\">\r\n                    <a href=\"".toCharArray();
    protected static final char[] _jsp_string_12 = "\" target=\"_blank\">".toCharArray();
    protected static final char[] _jsp_string_17 = "</a>\r\n                </h3>\r\n                <div style=\"height: 100px; line-height: 20px; overflow: hidden;\">".toCharArray();
    protected static final char[] _jsp_string_22 = "</div>\r\n".toCharArray();
    protected static final char[] _jsp_string_25 = "            </div>\r\n        </div>\r\n        <div class=\"right\">\r\n            <div class=\"pad10\">\r\n                <ul>\r\n".toCharArray();
    protected static final char[] _jsp_string_28 = "<li>· <a href=\"".toCharArray();
    protected static final char[] _jsp_string_30 = "\" target=\"_blank\">".toCharArray();
    protected static final char[] _jsp_string_32 = "</a></li>".toCharArray();
    protected static final char[] _jsp_string_35 = "                </ul>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>".toCharArray();

}