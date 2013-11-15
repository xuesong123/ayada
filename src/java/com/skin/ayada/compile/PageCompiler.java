/*
 * $RCSfile: PageCompiler.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-3-2  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package com.skin.ayada.compile;

import java.util.LinkedHashMap;
import java.util.Map;

import com.skin.ayada.io.StringStream;

/**
 * <p>Title: PageCompiler</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class PageCompiler
{
    protected int lineNumber = 1;
    protected StringStream stream;

    /**
     */
    public PageCompiler()
    {
    }

    /**
     * read node name, after read '<'
     * @return String
     */
    protected String getNodeName()
    {
        int i;
        char c;
        StringBuilder buffer = new StringBuilder();
        while((i = this.stream.read()) != -1)
        {
            c = (char)i;

            if(Character.isLetter(c) || Character.isDigit(c) || c == ':' || c == '-' || c == '_')
            {
                buffer.append(c);
            }
            else
            {
                this.stream.back();
                break;
            }
        }

        return buffer.toString();
    };

    /**
     * read node name, after read nodeName
     * @return String
     */
    public Map<String, String> getAttributes()
    {
        return this.getAttributes(this.stream);
    }

    /**
     * read node name, after read nodeName
     * @return String
     */
    public Map<String, String> getAttributes(StringStream stream)
    {
        int i;
        String name = null;
        String value = null;
        StringBuilder buffer = new StringBuilder();
        Map<String, String> attributes = new LinkedHashMap<String, String>();

        while((i = stream.peek()) != -1)
        {
            // skip invalid character
            while((i = stream.read()) != -1)
            {
                if(i == '\n')
                {
                    this.lineNumber++;
                }

                if(Character.isLetter(i) || Character.isDigit(i) || i == ':' || i == '-' || i == '_' || i == '%' || i == '/' || i == '>')
                {
                    stream.back();
                    break;
                }
            }

            // check end
            if(i == '>')
            {
                stream.read();
                break;
            }
            else if(i == '%')
            {
                if(stream.peek(1) == '>')
                {
                    stream.skip(2);
                    break;
                }
                else
                {
                    stream.read();
                    continue;
                }
            }
            else if(i == '/')
            {
                if(stream.peek(1) == '>')
                {
                    stream.skip(2);
                    break;
                }
                else
                {
                    stream.read();
                    continue;
                }
            }

            // read name
            while((i = stream.read()) != -1)
            {
                if(i == '\n')
                {
                    this.lineNumber++;
                }

                if(Character.isLetter(i) || Character.isDigit(i) || i == ':' || i == '-' || i == '_')
                {
                    buffer.append((char)i);
                }
                else
                {
                    stream.back();
                    break;
                }
            }

            name = buffer.toString();
            buffer.setLength(0);

            if(name.length() < 1)
            {
                continue;
            }

            // skip space
            while((i = stream.read()) != -1)
            {
                if(i == '\n')
                {
                    this.lineNumber++;
                }

                if(i != ' ')
                {
                    stream.back();
                    break;
                }
            }

            // next character must be '='
            if(stream.peek() != '=')
            {
                attributes.put(name, "");
                continue;
            }
            else
            {
                stream.read();
            }

            // skip space
            while((i = stream.read()) != -1)
            {
                if(i == '\n')
                {
                    this.lineNumber++;
                }

                if(i == ' ' || i == '\t' || i == '\r' || i == '\n')
                {
                    continue;
                }
                else
                {
                    break;
                }
            }

            char quote = ' ';

            if(i == '"')
            {
                quote = '"';
            }
            else if(i == '\'')
            {
                quote = '\'';
            }

            if(quote == ' ')
            {
                while((i = stream.read()) != -1)
                {
                    if(i == '\n')
                    {
                        this.lineNumber++;
                    }

                    if(i == ' ' || i == '\t' || i == '\r' || i == '\n' || i == '>')
                    {
                        break;
                    }
                    else if(i == '/' && stream.peek() == '>')
                    {
                        break;
                    }
                    else
                    {
                        buffer.append((char)i);
                    }
                }
            }
            else
            {
                while((i = stream.read()) != -1)
                {
                    if(i != quote)
                    {
                        buffer.append((char)i);
                    }
                    else
                    {
                        break;
                    }
                }
            }

            value = buffer.toString();
            attributes.put(name, value);
            buffer.setLength(0);
        }

        return attributes;
    }

    /**
     * @return the stream
     */
    public StringStream getStream()
    {
        return this.stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(StringStream stream)
    {
        this.stream = stream;
    };

    /**
     * @param lineNumber
     */
    public void setLineNumber(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    /**
     * @return int
     */
    public int getLineNumber()
    {
        return this.lineNumber;
    }
}
