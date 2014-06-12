/*
 * $RCSfile: SetTestTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-11-29 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * LastModified: 2013-11-29 17:18:21 062
 * JSP generated by JspCompiler-0.1.1 (built 2014-05-27 11:48:32 921)
 *
 */
package _jsp;

import com.skin.ayada.runtime.ExpressionContext;
import com.skin.ayada.runtime.JspWriter;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.tagext.BodyContent;
import com.skin.ayada.tagext.IterationTag;
import com.skin.ayada.tagext.Tag;
import com.skin.ayada.template.JspTemplate;
import com.skin.ayada.util.ExpressionUtil;

/**
 * <p>Title: SetTestTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
public class SetTestTemplate extends JspTemplate
{
    /**
     * @param pageContext
     * @throws Throwable
     */
    @Override
    public void _execute(final PageContext pageContext) throws Throwable
    {
        JspWriter out = pageContext.getOut();
        JspWriter jspWriter = pageContext.getOut();
        ExpressionContext expressionContext = pageContext.getExpressionContext();

        /* NODE START: lineNumber: 1, offset: 0, length: 8, tagClassName: com.skin.ayada.jstl.core.BeanTag, tagInstanceName: _jsp_BeanTag_1 */
        /* <c:bean name="testTag1" className="com.skin.ayada.jstl.core.TestTag">...</c:bean> */
        com.skin.ayada.jstl.core.BeanTag _jsp_BeanTag_1 = new com.skin.ayada.jstl.core.BeanTag();
        _jsp_BeanTag_1.setParent((Tag)null);
        _jsp_BeanTag_1.setPageContext(pageContext);
        _jsp_BeanTag_1.setName("testTag1");
        _jsp_BeanTag_1.setClassName("com.skin.ayada.jstl.core.TestTag");
        int _jsp_start_flag_1 = _jsp_BeanTag_1.doStartTag();

        if(_jsp_start_flag_1 == Tag.SKIP_PAGE){
            return;
        }
        if(_jsp_start_flag_1 != Tag.SKIP_BODY){
            int _jsp_flag_1 = 0;

            do{
                /* NODE START: lineNumber: 2, offset: 1, length: 2, tagClassName: com.skin.ayada.jstl.core.ConstructorTag, tagInstanceName: _jsp_ConstructorTag_2 */
                /* <c:constructor type="char" value="c"/> */
                com.skin.ayada.jstl.core.ConstructorTag.setArgument(_jsp_BeanTag_1, "char", "c");
                /* jsp.jstl.core.ConstructorTag END */
                /* NODE END: lineNumber: 2, tagClassName: com.skin.ayada.jstl.core.ConstructorTag, tagInstanceName: _jsp_ConstructorTag_2 */

                /* NODE START: lineNumber: 3, offset: 3, length: 2, tagClassName: com.skin.ayada.jstl.core.ConstructorTag, tagInstanceName: _jsp_ConstructorTag_4 */
                /* <c:constructor type="byte" value="2"/> */
                com.skin.ayada.jstl.core.ConstructorTag.setArgument(_jsp_BeanTag_1, "byte", 2);
                /* jsp.jstl.core.ConstructorTag END */
                /* NODE END: lineNumber: 3, tagClassName: com.skin.ayada.jstl.core.ConstructorTag, tagInstanceName: _jsp_ConstructorTag_4 */

                /* NODE START: lineNumber: 4, offset: 5, length: 2, tagClassName: com.skin.ayada.jstl.core.PropertyTag, tagInstanceName: _jsp_PropertyTag_6 */
                /* <c:property name="pageContext" value="${pageContext}"/> */
                _jsp_BeanTag_1.setProperty("pageContext", pageContext.getAttribute("pageContext"));
                /* jsp.jstl.core.PropertyTag END */
                /* NODE END: lineNumber: 4, tagClassName: com.skin.ayada.jstl.core.PropertyTag, tagInstanceName: _jsp_PropertyTag_6 */

                _jsp_flag_1 = _jsp_BeanTag_1.doAfterBody();
            }
            while(_jsp_flag_1 == IterationTag.EVAL_BODY_AGAIN);
        }
        _jsp_BeanTag_1.doEndTag();
        _jsp_BeanTag_1.release();
        /* NODE END: lineNumber: 1, tagClassName: com.skin.ayada.jstl.core.BeanTag, tagInstanceName: _jsp_BeanTag_1 */

        /* TEXT: lineNumber: 5 */
        out.write("\r\n\r\n");

        /* NODE START: lineNumber: 7, offset: 9, length: 2, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_10 */
        /* <c:set var="a1" value="1"/> */
        pageContext.setAttribute("a1", 1);
        /* jsp.jstl.core.SetTag END */
        /* NODE END: lineNumber: 7, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_10 */

        /* TEXT: lineNumber: 7 */
        out.write("<p>a1: ");
        /* VARIABLE: lineNumber: 7 */
        out.print(pageContext.getAttribute("a1"), false);
        /* TEXT: lineNumber: 7 */
        out.write("</p>\r\n");

        /* NODE START: lineNumber: 8, offset: 14, length: 3, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_15 */
        /* <c:set var="a1">...</c:set> */
        out = pageContext.pushBody();
        /* TEXT: lineNumber: 8 */
        out.write("0 - Hello World!");
        pageContext.setAttribute("a1", ((BodyContent)out).getString().trim());
        out = pageContext.popBody();
        /* jsp.jstl.core.SetTag END */
        /* NODE END: lineNumber: 8, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_15 */

        /* TEXT: lineNumber: 8 */
        out.write("<p>a1: ");
        /* VARIABLE: lineNumber: 8 */
        out.print(pageContext.getAttribute("a1"), false);
        /* TEXT: lineNumber: 8 */
        out.write("</p>\r\n\r\n");

        /* NODE START: lineNumber: 10, offset: 20, length: 2, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_21 */
        /* <c:set target="${testTag1}" property="myString" value="00 - Hello World !"/> */
        com.skin.ayada.util.ClassUtil.setProperty(pageContext.getAttribute("testTag1"), "myString", "00 - Hello World !");
        /* jsp.jstl.core.SetTag END */
        /* NODE END: lineNumber: 10, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_21 */

        /* NODE START: lineNumber: 11, offset: 22, length: 2, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_23 */
        /* <c:execute value="${testTag1.print()}"/> */
        pageContext.setAttribute((String)null, ExpressionUtil.evaluate(expressionContext, "${testTag1.print()}", null));
        /* jsp.jstl.core.ExecuteTag END */
        /* NODE END: lineNumber: 11, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_23 */

        /* NODE START: lineNumber: 12, offset: 24, length: 3, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_25 */
        /* <c:set target="${testTag1}" property="myString">...</c:set> */
        out = pageContext.pushBody();
        /* TEXT: lineNumber: 12 */
        out.write("00 - Hello World !");
        com.skin.ayada.util.ClassUtil.setProperty(pageContext.getAttribute("testTag1"), "myString", ((BodyContent)out).getString().trim());
        out = pageContext.popBody();
        /* jsp.jstl.core.SetTag END */
        /* NODE END: lineNumber: 12, tagClassName: com.skin.ayada.jstl.core.SetTag, tagInstanceName: _jsp_SetTag_25 */

        /* TEXT: lineNumber: 12 */
        out.write("\r\n");

        /* NODE START: lineNumber: 13, offset: 28, length: 2, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_29 */
        /* <c:execute value="${testTag1.print()}"/> */
        pageContext.setAttribute((String)null, ExpressionUtil.evaluate(expressionContext, "${testTag1.print()}", null));
        /* jsp.jstl.core.ExecuteTag END */
        /* NODE END: lineNumber: 13, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_29 */

        out.flush();
        jspWriter.flush();
    }
}
