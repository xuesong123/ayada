/*
 * $RCSfile: ExpressionUtil.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-11-10  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.util;

import java.util.ArrayList;
import java.util.List;

import com.skin.ayada.ognl.util.Empty;
import com.skin.ayada.runtime.ExpressionContext;
import com.skin.ayada.statement.Expression;
import com.skin.ayada.statement.Node;
import com.skin.ayada.statement.TextNode;

/**
 * <p>Title: ExpressionUtil</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class ExpressionUtil
{
    /**
     * @param expressionContext
     * @param source
     * @return Object
     */
    public static String getHtml(ExpressionContext expressionContext, String source)
    {
        return HtmlUtil.encode(getString(expressionContext, source));
    }

    /**
     * @param expressionContext
     * @param source
     * @return Object
     */
    public static String getString(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value == null || value instanceof Empty<?, ?>)
        {
            return "";
        }
        else
        {
            return value.toString();
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Object
     */
    public static boolean getBoolean(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value == null)
        {
            return false;
        }

        if(value instanceof Boolean)
        {
            return Boolean.TRUE.equals(value);
        }
        else
        {
            return false;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Byte
     */
    public static Byte getByte(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).byteValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Short
     */
    public static Short getShort(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).shortValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Integer
     */
    public static Integer getInteger(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).intValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Float
     */
    public static Float getFloat(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).floatValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Double
     */
    public static Double getDouble(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).doubleValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param expressionContext
     * @param source
     * @return Long
     */
    public static Long getLong(ExpressionContext expressionContext, String source)
    {
        Object value = ExpressionUtil.evaluate(expressionContext, source);

        if(value != null && value instanceof Number)
        {
            return ((Number)value).longValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param source
     * @return String
     */
    public static Object evaluate(ExpressionContext expressionContext, String source)
    {
        if(source == null)
        {
            return null;
        }

        char c;
        char[] cbuf = source.toCharArray();
        List<Node> list = new ArrayList<Node>();

        TextNode textNode = null;

        for(int i = 0, length = cbuf.length; i < length; i++)
        {
            c = cbuf[i];

            if(c == '$' && (i + 1) < length && cbuf[i + 1] == '{')
            {
                Expression expression = new Expression();

                for(i = i + 2; i < length; i++)
                {
                    if(cbuf[i] == '}')
                    {
                        break;
                    }
                    else
                    {
                        expression.append(cbuf[i]);
                    }
                }

                if(expression.toString().length() > 0)
                {
                    list.add(expression);
                    textNode = null;
                }
            }
            else
            {
                if(textNode == null)
                {
                    textNode = new TextNode();
                    list.add(textNode);
                }

                textNode.append(c);
            }
        }

        if(list.size() > 0)
        {
            if(list.size() == 1)
            {
                Node node = list.get(0);

                if(node instanceof Expression)
                {
                    return expressionContext.getValue(node.toString());
                }
                else
                {
                    Object value = null;
                    String result = node.toString();
                    int flag = getNumberType(result);

                    if(flag == 0)
                    {
                        return result;
                    }
                    else
                    {
                        if(flag == 1)
                        {
                            try
                            {
                                value = Integer.valueOf(result);
                            }
                            catch(NumberFormatException e)
                            {
                            }
                        }
                        else if(flag == 2)
                        {
                            try
                            {
                                value = Double.valueOf(result);
                            }
                            catch(NumberFormatException e)
                            {
                            }
                        }
                    }

                    return (value != null ? value : result);
                }
            }
            else
            {
                Object value = null;
                StringBuilder buffer = new StringBuilder();

                for(Node node : list)
                {
                    if(node instanceof Expression)
                    {
                        value = expressionContext.getValue(node.toString());

                        if(value != null)
                        {
                            buffer.append(value.toString());
                        }
                    }
                    else
                    {
                        buffer.append(node.toString());
                    }
                }

                return buffer.toString();
            }
        }

        return null;
    }

    /**
     * @param source
     * @return int
     */
    public static int getNumberType(String source)
    {
        char c;
        int d = 0;
        int type = 1;

        for(int i = 0, length = source.length(); i < length; i++)
        {
            c = source.charAt(i);

            if(i > 0 && c == '.')
            {
                if(d == 0)
                {
                    d = 2;
                    continue;
                }
                else
                {
                    return 0;
                }
            }

            if(c < 48 || c > 57)
            {
                return 0;
            }
        }

        return (d == 0 ? type : d);
    }
}