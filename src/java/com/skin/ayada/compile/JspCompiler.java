/*
 * $RCSfile: ClassCompiler.java,v $$
 * $Revision: 1.1 $
 * $Date: 2013-11-8 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.compile;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.skin.ayada.statement.Node;
import com.skin.ayada.statement.NodeType;
import com.skin.ayada.tagext.BodyTag;
import com.skin.ayada.tagext.IterationTag;
import com.skin.ayada.template.Template;
import com.skin.ayada.util.ClassUtil;
import com.skin.ayada.util.NodeUtil;
import com.skin.ayada.util.StringUtil;
import com.skin.ayada.util.TagUtil;

/**
 * <p>Title: ClassCompiler</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @version 1.0
 */
public class JspCompiler
{
    private boolean fast = true;

    public String compile(Template template, String className, String packageName)
    {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        this.writeHeader(className, packageName, writer);

        Node node = null;
        List<Node> list = template.getNodes();

        for(int index = 0, size = list.size(); index < size; index++)
        {
            node = list.get(index);

            if(node.getNodeType() == NodeType.JSP_DECLARATION)
            {
                if(node.getOffset() == index)
                {
                    writer.println("    /* JSP_DECLARATION: lineNumber: " + node.getLineNumber() + " */");
                    writer.write(node.toString());
                }
                else
                {
                    writer.println("    /* jsp:declaration END */");
                }
            }
        }

        writer.println("    /**");
        writer.println("     * @param pageContext");
        writer.println("     * @throws Exception");
        writer.println("     */");
        writer.println("    @Override");
        writer.println("    public void execute(final PageContext pageContext) throws Exception");
        writer.println("    {");
        writer.println("        JspWriter out = pageContext.getOut();");
        writer.println("        JspWriter jspWriter = pageContext.getOut();");
        writer.println("        ExpressionContext expressionContext = pageContext.getExpressionContext();");
        String indent = this.getIndent(2);

        for(int index = 0, size = list.size(); index < size; index++)
        {
            node = list.get(index);

            if(node.getNodeType() == NodeType.TEXT)
            {
                writer.println(indent + "/* TEXT: lineNumber: " + node.getLineNumber() + " */");
                writer.println(indent + "out.write(\"" + StringUtil.escape(StringUtil.compact(node.toString())) + "\");");
                continue;
            }

            if(node.getNodeType() == NodeType.EXPRESSION)
            {
                writer.println(indent + "/* EXPRESSION: lineNumber: " + node.getLineNumber() + " */");
                writer.println(indent + "out.write(expressionContext.getString(\"" + StringUtil.escape(node.toString()) + "\"));");
                continue;
            }

            if(node.getLength() == 0)
            {
                throw new RuntimeException("Exception at line #" + node.getLineNumber() + " " + NodeUtil.toString(node) + " not match !");
            }

            this.write(index, indent, node.getTagClassName(), node, writer);
        }

        writer.println("        out.flush();");
        writer.println("        jspWriter.flush();");
        writer.println("    }");
        writer.println("}");
        writer.flush();
        return stringWriter.toString();
    }
    
    /**
     * @param className
     * @param packageName
     * @param writer
     */
    public void writeHeader(String className, String packageName, PrintWriter writer)
    {
        writer.println("/*");
        writer.println(" * $RCSfile: " + className + ".java,v $$");
        writer.println(" * $Revision: 1.1 $");
        writer.println(" * $Date: 2013-11-8 $");
        writer.println(" *");
        writer.println(" * Copyright (C) 2008 Skin, Inc. All rights reserved.");
        writer.println(" *");
        writer.println(" * This software is the proprietary information of Skin, Inc.");
        writer.println(" * Use is subject to license terms.");
        writer.println(" *");
        writer.println(" * JSP generated by JspCompiler-0.1.1 (built " + new Date() + ")");
        writer.println(" *");
        writer.println(" */");
        writer.println("package " + packageName + ";");
        writer.println();
        
        writer.println("import com.skin.ayada.runtime.ExpressionContext;");
        writer.println("import com.skin.ayada.runtime.JspWriter;");
        writer.println("import com.skin.ayada.runtime.PageContext;");
        writer.println("import com.skin.ayada.tagext.BodyContent;");
        writer.println("import com.skin.ayada.tagext.IterationTag;");
        writer.println("import com.skin.ayada.tagext.Tag;");
        writer.println("import com.skin.ayada.template.JspTemplate;");
        writer.println("import com.skin.ayada.util.ExpressionUtil;");
        writer.println();
        writer.println("/**");
        writer.println(" * <p>Title: " + className + "</p>");
        writer.println(" * <p>Description: </p>");
        writer.println(" * <p>Copyright: Copyright (c) 2006</p>");
        writer.println(" * @author JspCompiler");
        writer.println(" * @version 1.0");
        writer.println(" */");
        writer.println("public class " + className + " extends JspTemplate");
        writer.println("{");
    }

    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    public void write(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        /** Jsp Support */
        if(node.getOffset() == index)
        {
            if(node.getNodeType() == NodeType.JSP_DECLARATION)
            {
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_PAGE)
            {
                writer.println(indent + "/* JSP_DIRECTIVE: lineNumber: " + node.getLineNumber() + " */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_TAGLIB)
            {
                writer.println(indent + "/* JSP_DIRECTIVE: lineNumber: " + node.getLineNumber() + " */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_INCLUDE)
            {
                writer.println(indent + "/* JSP_DIRECTIVE: lineNumber: " + node.getLineNumber() + " */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_SCRIPTLET)
            {
                writer.println(indent + "/* JSP_SCRIPTLET: lineNumber: " + node.getLineNumber() + " */");
                writer.println(node.toString());
                return;
            }

            if(node.getNodeType() == NodeType.JSP_EXPRESSION)
            {
                writer.println(indent + "/* JSP_EXPRESSION: lineNumber: " + node.getLineNumber() + " */");
                writer.println(indent + "out.print(" + node.toString() + ");");
                return;
            }
        }
        else
        {
            if(node.getNodeType() == NodeType.JSP_DECLARATION)
            {
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_PAGE)
            {
                writer.println(indent + "/* jsp:directive.page END */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_TAGLIB)
            {
                writer.println(indent + "/* jsp:directive.taglib END */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_DIRECTIVE_INCLUDE)
            {
                writer.println(indent + "/* jsp:directive.include END */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_SCRIPTLET)
            {
                writer.println(indent + "/* jsp:scriptlet END */");
                return;
            }

            if(node.getNodeType() == NodeType.JSP_EXPRESSION)
            {
                writer.println(indent + "/* jsp:expression END */");
                return;
            }
        }

        /** Tag Support */
        String tagName = node.getNodeName();
        String tagInstanceName = this.getTagInstanceName(node);

        if(node.getOffset() == index)
        {
            writer.println();
            writer.println(indent + "/* NODE START: lineNumber: " + node.getLineNumber() + ", offset: " + node.getOffset() + ", length: " + node.getLength() + ", tagClassName: " + tagClassName + ", tagInstanceName: " + tagInstanceName + " */");
            writer.println(indent + "/* " + NodeUtil.toString(node) + " */");
        }

        if(this.fast)
        {
            if(tagName.equals("t:import"))
            {
                this.writeImportTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:if"))
            {
                this.writeIfTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:set"))
            {
                this.writeSetTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:out"))
            {
                this.writeOutTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:each") || tagName.equals("c:forEach"))
            {
                this.writeForEachTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:choose"))
            {
                this.writeChooseTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:when"))
            {
                this.writeWhenTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("c:otherwise"))
            {
                this.writeOtherwiseTag(index, indent, tagClassName, node, writer);
            }
            else if(tagName.equals("fmt:formatDate"))
            {
                this.writeFormatDateTag(index, indent, tagClassName, node, writer);
            }
            else
            {
                this.writeTag(index, indent, tagClassName, node, writer);
            }
        }
        else
        {
            this.writeTag(index, indent, tagClassName, node, writer);
        }

        if(node.getOffset() != index)
        {
            writer.println(indent + "/* NODE END: lineNumber: " + node.getLineNumber() + ", tagClassName: " + tagClassName + ", tagInstanceName: " + tagInstanceName + " */");
            writer.println();
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeImportTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            writer.println(indent + "pageContext.getTagLibrary().setup(\"" + node.getAttribute("name") + "\", \"" + node.getAttribute("className") + "\");");
        }
        else
        {
            writer.println(indent + "/* jsp.jstl.core.ImportTag END */");
        }
    }

    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeIfTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            writer.println(indent + "if(ExpressionUtil.getBoolean(expressionContext, \"" + StringUtil.escape(node.getAttribute("test")) + "\")){");
        }
        else
        {
            writer.println(indent + "} /* jsp.jstl.core.IfTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeSetTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            String name = node.getAttribute("var");
            writer.println(indent + "pageContext.setAttribute(\"" + name + "\", ExpressionUtil.evaluate(expressionContext, \"" + StringUtil.escape(node.getAttribute("value")) + "\"));");
        }
        else
        {
            writer.println(indent + "/* jsp.jstl.core.SetTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeOutTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            boolean escapeXml = "true".equals(node.getAttribute("escapeXml"));

            if(node.getLength() > 2)
            {
                writer.println(indent + "out = pageContext.pushBody();");
            }

            if(node.getAttribute("value") != null)
            {
                if(escapeXml)
                {
                    writer.println(indent + "out.write(ExpressionUtil.getHtml(expressionContext, \"" + StringUtil.escape(node.getAttribute("value")) + "\"));");
                }
                else
                {
                    writer.println(indent + "out.write(ExpressionUtil.getString(expressionContext, \"" + StringUtil.escape(node.getAttribute("value")) + "\"));");
                }
            }
        }
        else
        {
            if(node.getLength() > 2)
            {
                boolean escapeXml = "true".equals(node.getAttribute("escapeXml"));
                writer.println(indent + "pageContext.printBodyContent((BodyContent)out, " + escapeXml + ");");
                writer.println(indent + "out = pageContext.popBody();");
            }

            writer.println(indent + "/* jsp.jstl.core.OutTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeForEachTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        String tagInstanceName = this.getTagInstanceName(node);
        String parentTagInstanceName = this.getTagInstanceName(node.getParent());
        String flagName = this.getVariableName(node, "_jsp_flag_");
        String forEachOldVar = this.getVariableName(node, "_jsp_old_var_");
        String forEachOldVarStatus = this.getVariableName(node, "_jsp_old_var_status_");

        if(node.getOffset() == index)
        {
            String items = node.getAttribute("items");
            String variable = node.getAttribute("var");
            String begin = node.getAttribute("begin");
            String step = node.getAttribute("step");
            String end = node.getAttribute("end");
            String varStatus = node.getAttribute("varStatus");
            boolean hasParent = this.hasParent(node);

            writer.println(indent + "Object " + forEachOldVar + " = pageContext.getAttribute(\"" + variable + "\");");

            if(varStatus != null)
            {
                writer.println(indent + "Object " + forEachOldVarStatus + " = pageContext.getAttribute(\"" + varStatus + "\");");
            }

            writer.println(indent + tagClassName + " " + tagInstanceName + " = new " + tagClassName + "();");
            writer.println();

            if(hasParent)
            {
                writer.println(indent + tagInstanceName + ".setParent(" + parentTagInstanceName + ");");
            }
            else
            {
                writer.println(indent + tagInstanceName + ".setParent((Tag)null);");
            }

            writer.println(indent + tagInstanceName + ".setPageContext(pageContext);");

            if(variable != null)
            {
                writer.println(indent + tagInstanceName + ".setVar(\"" + StringUtil.escape(variable) + "\");");
            }

            if(items != null)
            {
                writer.println(indent + tagInstanceName + ".setItems(ExpressionUtil.evaluate(expressionContext, \"" + StringUtil.escape(items) + "\"));");
            }

            if(begin != null && end != null)
            {
                writer.println(indent + tagInstanceName + ".setBegin(ExpressionUtil.getInteger(expressionContext, \"" + begin + "\"));");
                writer.println(indent + tagInstanceName + ".setEnd(ExpressionUtil.getInteger(expressionContext, \"" + end + "\"));");
            }

            if(step != null)
            {
                writer.println(indent + tagInstanceName + ".setStep(ExpressionUtil.getInteger(expressionContext, \"" + step + "\"));");
            }

            if(varStatus != null)
            {
                writer.println(indent + "pageContext.setAttribute(\"" + varStatus + "\", " + tagInstanceName + ".getLoopStatus());");
            }

            writer.println(indent + "int " + flagName + " = " + tagInstanceName + ".doStartTag();");
            writer.println(indent + "if(" + flagName + " != Tag.SKIP_BODY){");
            writer.println(indent + "    while(true){");
        }
        else
        {
            String variable = node.getAttribute("var");
            String varStatus = node.getAttribute("varStatus");
            
            writer.println(indent + "       if(" + tagInstanceName + ".hasNext()){");
            writer.println(indent + "           pageContext.setAttribute(\"" + variable + "\", " + tagInstanceName + ".next());");
            writer.println(indent + "       }");
            writer.println(indent + "       else{");
            writer.println(indent + "           break;");
            writer.println(indent + "       }");
            writer.println(indent + "   }");
            writer.println(indent + "}");
            writer.println(indent + tagInstanceName + ".release();");
            writer.println(indent + "pageContext.setAttribute(\"" + variable + "\", " + forEachOldVar + ");");

            if(varStatus != null)
            {
                writer.println(indent + "pageContext.setAttribute(\"" + varStatus + "\", " + forEachOldVarStatus + ");");
            }

            writer.println(indent + "/* jsp.jstl.core.ForEachTag END */");
        }
    }

    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeChooseTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            String tagInstanceName = this.getTagInstanceName(node);
            writer.println(indent + "boolean " + tagInstanceName + " = true;");
            writer.println();
        }
        else
        {
            writer.println(indent + "/* jsp.jstl.core.ChooseTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeWhenTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            String parentTagInstanceName = this.getTagInstanceName(node.getParent());
            writer.println(indent + "if(" + parentTagInstanceName + " && ExpressionUtil.getBoolean(expressionContext, \"" + StringUtil.escape(node.getAttribute("test")) + "\")){");
            writer.println(indent + "    " + parentTagInstanceName + " = false;");
        }
        else
        {
            writer.println(indent + "} /* jsp.jstl.core.WhenTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeOtherwiseTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            String parentTagInstanceName = this.getTagInstanceName(node.getParent());
            writer.println(indent + "if(" + parentTagInstanceName + "){");
            writer.println(indent + "    " + parentTagInstanceName + " = false;");
        }
        else
        {
            writer.println(indent + "} /* jsp.jstl.core.OtherwiseTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeFormatDateTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        if(node.getOffset() == index)
        {
            String tagInstanceName = this.getTagInstanceName(node);
            String parentTagInstanceName = this.getTagInstanceName(node.getParent());
            boolean hasParent = this.hasParent(node);

            writer.println(indent + tagClassName + " " + tagInstanceName + " = new " + tagClassName + "();");

            if(hasParent)
            {
                writer.println(indent + tagInstanceName + ".setParent(" + parentTagInstanceName + ");");
            }
            else
            {
                writer.println(indent + tagInstanceName + ".setParent((Tag)null);");
            }

            writer.println(indent + tagInstanceName + ".setPageContext(pageContext);");
            this.setAttributes(indent, tagClassName, tagInstanceName, node.getAttributes(), writer);
            writer.println(indent + tagInstanceName + ".doStartTag();");
            writer.println(indent + tagInstanceName + ".doEndTag();");
            writer.println(indent + tagInstanceName + ".release();");
        }
        else
        {
            writer.println(indent + "/* jsp.jstl.fmt.FormatDateTag END */");
        }
    }
    
    /**
     * @param index
     * @param indent
     * @param tagClassName
     * @param node
     * @param writer
     */
    private void writeTag(int index, String indent, String tagClassName, Node node, PrintWriter writer)
    {
        String tagInstanceName = this.getTagInstanceName(node);
        String parentTagInstanceName = this.getTagInstanceName(node.getParent());
        String flagName = this.getVariableName(node, "_jsp_flag_");
        String bodyContentInstanceName = this.getVariableName(node, "_jsp_body_content_");
        boolean hasParent = this.hasParent(node);

        if(node.getOffset() == index)
        {
            writer.println(indent + tagClassName + " " + tagInstanceName + " = new " + tagClassName + "();");

            if(hasParent)
            {
                writer.println(indent + tagInstanceName + ".setParent(" + parentTagInstanceName + ");");
            }
            else
            {
                writer.println(indent + tagInstanceName + ".setParent((Tag)null);");
            }

            writer.println(indent + tagInstanceName + ".setPageContext(pageContext);");
            this.setAttributes(indent, tagClassName, tagInstanceName, node.getAttributes(), writer);
            writer.println(indent + "int " + flagName + " = " + tagInstanceName + ".doStartTag();");
            writer.println();

            writer.println(indent + "if(" + flagName + " == Tag.SKIP_PAGE){");
            writer.println(indent + "    return;");
            writer.println(indent + "}");

            if(this.isAssignableFrom(tagClassName, BodyTag.class))
            {
                writer.println(indent + "if(" + flagName + " != Tag.SKIP_BODY && " + flagName + " != Tag.EVAL_BODY_INCLUDE){");
                writer.println(indent + "    BodyContent " + bodyContentInstanceName + " = (BodyContent)(pageContext.pushBody());");
                writer.println(indent + "    " + tagInstanceName + ".setBodyContent(" + bodyContentInstanceName + ");");
                writer.println(indent + "    " + tagInstanceName + ".doInitBody();");
                writer.println(indent + "    out = " + bodyContentInstanceName + ";");
                writer.println(indent + "}");
            }

            writer.println();
            writer.println(indent + "do{");
        }
        else
        {
            if(this.isAssignableFrom(tagClassName, IterationTag.class))
            {
                writer.println(indent + "    " + flagName + " = " + tagInstanceName + ".doAfterBody();");
            }

            writer.println(indent + "}");
            writer.println(indent + "while(" + flagName + " == IterationTag.EVAL_BODY_AGAIN);");
            writer.println(indent + tagInstanceName+ ".doEndTag();");
            writer.println(indent + tagInstanceName + ".release();");

            if(this.isAssignableFrom(tagClassName, BodyTag.class))
            {
                writer.println(indent + "if(" + flagName + " != Tag.SKIP_BODY && " + flagName + " != Tag.EVAL_BODY_INCLUDE){");
                writer.println(indent + "    out = pageContext.popBody();");
                writer.println(indent + "}");
            }
        }
    }

    /**
     * @param node
     * @return boolean
     */
    protected boolean hasParent(Node node)
    {
        Node parent = node.getParent();

        if(this.fast == false)
        {
            return (parent != null);
        }

        if(parent != null)
        {
            String parentTagName = parent.getNodeName();

            if(parentTagName.equals("c:if")
                    || parentTagName.equals("c:out")
                    || parentTagName.equals("c:set")
                    || parentTagName.equals("c:each")
                    || parentTagName.equals("c:forEach")
                    || parentTagName.equals("c:choose")
                    || parentTagName.equals("c:when")
                    || parentTagName.equals("c:otherwise")
                    || parentTagName.equals("fmt:formatDate"))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * @param indent
     * @param tagClassName
     * @param tagInstanceName
     * @param attributes
     * @param writer
     */
    protected void setAttributes(String indent, String tagClassName, String tagInstanceName, Map<String, String> attributes, PrintWriter writer)
    {
        if(attributes == null || attributes.size() < 1)
        {
            return;
        }

        try
        {
            Class<?> clazz = ClassUtil.getClass(tagClassName);

            for(Map.Entry<String, String> entry : attributes.entrySet())
            {
                String name = entry.getKey();
                String value = entry.getValue();
                String methodName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                Method method = TagUtil.getSetMethod(clazz, methodName);

                if(method != null)
                {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Class<?> parameterType = parameterTypes[0];

                    if(parameterType == char.class || parameterType == Character.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getInteger(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == boolean.class || parameterType == Boolean.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getBoolean(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == byte.class || parameterType == Byte.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getByte(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == short.class || parameterType == Short.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getShort(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == int.class || parameterType == Integer.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getInteger(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == float.class || parameterType == Float.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getFloat(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == double.class || parameterType == Double.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getDouble(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == long.class || parameterType == Long.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getLong(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == String.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getString(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == java.util.Date.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.getDate(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                    else if(parameterType == Object.class)
                    {
                        writer.println(indent + tagInstanceName + "." + methodName + "(ExpressionUtil.evaluate(expressionContext, \"" + StringUtil.escape(value) + "\"));");
                    }
                }
            }
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param tagClassName
     * @param tag
     * @return boolean
     * @throws ClassNotFoundException 
     */
    protected boolean isAssignableFrom(String tagClassName, Class<?> parent)
    {
        try
        {
            Class<?> clazz = ClassUtil.getClass(tagClassName);
            return parent.isAssignableFrom(clazz);
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param indent
     * @return String
     */
    protected String getIndent(int indent)
    {
        StringBuilder buffer = new StringBuilder();

        for(int i = 0; i < indent; i++)
        {
            buffer.append("    ");
        }

        return buffer.toString();
    }

    /**
     * @param node
     * @param prefix
     * @return String
     */
    protected String getTagInstanceName(Node node)
    {
        if(node != null)
        {
            String tagClassName = node.getTagClassName();
            int k = tagClassName.lastIndexOf(".");

            if(k > -1)
            {
                return this.getVariableName(node, "_jsp_" + tagClassName.substring(k + 1) + "_");
            }
            else
            {
                return this.getVariableName(node, "_jsp_" + tagClassName + "_");
            }
        }
        else
        {
            return "_jsp_undefined";
        }
    }

    /**
     * @param node
     * @param prefix
     * @return String
     */
    protected String getVariableName(Node node, String prefix)
    {
        if(node != null)
        {
            return prefix + (node.getOffset() + 1);
        }
        else
        {
            return prefix + "undefined";
        }
    }

    /**
     * @return the fast
     */
    public boolean getFast()
    {
        return this.fast;
    }

    /**
     * @param fast the fast to set
     */
    public void setFast(boolean fast)
    {
        this.fast = fast;
    }
}
