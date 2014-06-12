/*
 * $RCSfile: TryCatchFinallyTestTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2014-04-02 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * LastModified: 2014-04-02 13:39:31 250
 * JSP generated by JspCompiler-0.1.1 (built 2014-04-02 14:21:12 140)
 *
 */
package _jsp;

import com.skin.ayada.runtime.ExpressionContext;
import com.skin.ayada.runtime.JspWriter;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.tagext.IterationTag;
import com.skin.ayada.tagext.Tag;
import com.skin.ayada.template.JspTemplate;
import com.skin.ayada.util.ExpressionUtil;

/**
 * <p>Title: TryCatchFinallyTestTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
public class TryCatchFinallyTestTemplate extends JspTemplate
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

        /* NODE START: lineNumber: 2, offset: 0, length: 2, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_1 */
        /* <c:execute value="${pageContext.getOut().setBufferSize(4096)}"/> */
        pageContext.setAttribute((String)null, ExpressionUtil.evaluate(expressionContext, "${pageContext.getOut().setBufferSize(4096)}", null));
        /* jsp.jstl.core.ExecuteTag END */
        /* NODE END: lineNumber: 2, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_1 */

        /* NODE START: lineNumber: 3, offset: 2, length: 2, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_3 */
        /* <c:execute value="${pageContext.getOut().setAutoFlush(true)}"/> */
        pageContext.setAttribute((String)null, ExpressionUtil.evaluate(expressionContext, "${pageContext.getOut().setAutoFlush(true)}", null));
        /* jsp.jstl.core.ExecuteTag END */
        /* NODE END: lineNumber: 3, tagClassName: com.skin.ayada.jstl.core.ExecuteTag, tagInstanceName: _jsp_ExecuteTag_3 */

        /* TEXT: lineNumber: 4 */
        out.write("<!--\r\n功能测试\r\n    该测试仅针对解释模式， 编译模式不会存在这个问题。\r\n    测试项目:\r\n        1. 当Tag的doStartTag或者doEndTag返回Tag.SKIP_PAGE时, 父Tag如果是TryCatchFinally标签, 是否能够执行父Tag的doFinally\r\n        2. 如果父Tag的doFinally方法在执行的时候抛出了异常，那么整个执行过程是否能够正常终止。\r\n        3. 如果父Tag的doFinally方法在执行的时候抛出了异常，显示出来的错误信息是否正确。错误信息应该定位到TryCatchFinally标签上，而不应该定位到返回Tag.SKIP_PAGE的标签上。\r\n-->\r\n");

        /* NODE START: lineNumber: 12, offset: 5, length: 6, tagClassName: com.skin.ayada.jstl.core.TryCatchTestTag, tagInstanceName: _jsp_TryCatchTestTag_6 */
        /* <c:tryCatchTest exception="doFinally">...</c:tryCatchTest> */
        com.skin.ayada.jstl.core.TryCatchTestTag _jsp_TryCatchTestTag_6 = new com.skin.ayada.jstl.core.TryCatchTestTag();
        try{
            _jsp_TryCatchTestTag_6.setParent((Tag)null);
            _jsp_TryCatchTestTag_6.setPageContext(pageContext);
            _jsp_TryCatchTestTag_6.setException("doFinally");
            int _jsp_start_flag_6 = _jsp_TryCatchTestTag_6.doStartTag();

            if(_jsp_start_flag_6 == Tag.SKIP_PAGE){
                return;
            }
            if(_jsp_start_flag_6 != Tag.SKIP_BODY){
                int _jsp_flag_6 = 0;

                do{
                    /* TEXT: lineNumber: 12 */
                    out.write("\r\n    ");

                    /* NODE START: lineNumber: 13, offset: 7, length: 2, tagClassName: com.skin.ayada.jstl.core.ExitTag, tagInstanceName: _jsp_ExitTag_8 */
                    /* <c:exit/> */
                    if(com.skin.ayada.jstl.core.ExitTag.getTrue()){
                        return;
                    }
                    /* jsp.jstl.core.ExitTag END */
                    /* NODE END: lineNumber: 13, tagClassName: com.skin.ayada.jstl.core.ExitTag, tagInstanceName: _jsp_ExitTag_8 */

                    /* TEXT: lineNumber: 13 */
                    out.write("\r\n");
                    _jsp_flag_6 = _jsp_TryCatchTestTag_6.doAfterBody();
                }
                while(_jsp_flag_6 == IterationTag.EVAL_BODY_AGAIN);
            }
            _jsp_TryCatchTestTag_6.doEndTag();
            _jsp_TryCatchTestTag_6.release();
        }
        catch(Throwable throwable){
            _jsp_TryCatchTestTag_6.doCatch(throwable);
        }
        finally{
            _jsp_TryCatchTestTag_6.doFinally();
        }
        /* NODE END: lineNumber: 12, tagClassName: com.skin.ayada.jstl.core.TryCatchTestTag, tagInstanceName: _jsp_TryCatchTestTag_6 */

        out.flush();
        jspWriter.flush();
    }
}
