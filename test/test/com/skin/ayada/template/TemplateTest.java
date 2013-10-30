/*
 * $RCSfile: TemplateTest.java,v $$
 * $Revision: 1.1  $
 * $Date: 2013-2-19  $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 */
package test.com.skin.ayada.template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.com.skin.ayada.handler.UserHandler;
import test.com.skin.ayada.model.User;

import com.skin.ayada.compile.TemplateCompiler;
import com.skin.ayada.config.TemplateConfig;
import com.skin.ayada.jstl.TagLibrary;
import com.skin.ayada.jstl.TagLibraryFactory;
import com.skin.ayada.jstl.core.IfTag;
import com.skin.ayada.runtime.JspFactory;
import com.skin.ayada.runtime.JspWriter;
import com.skin.ayada.runtime.PageContext;
import com.skin.ayada.runtime.TagFactory;
import com.skin.ayada.tagext.Tag;
import com.skin.ayada.template.DefaultExecutor;
import com.skin.ayada.template.Template;
import com.skin.ayada.template.TemplateContext;
import com.skin.ayada.util.IO;
import com.skin.ayada.util.MemMonitor;
import com.skin.ayada.util.TagUtil;

/**
 * <p>Title: TemplateTest</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author xuesong.net
 * @version 1.0
 */
public class TemplateTest
{
    protected static final Logger logger = LoggerFactory.getLogger(TemplateTest.class);

    public static void main(String[] args)
    {
        // System.out.println(Object.class.isAssignableFrom(String.class));
        // compareTest(new Object(), "test");
        // compareTest("test", new Object());

        // test1();
        // test("webapp", "/whenTest.html");
        // test("webapp", "/emptyTest.html");
        test("webapp", "/jspTagTest.html");
        // test("webapp", "/eachTest.html");
        // test("webapp", "/stacktrace.html");
        // test("E:\\WorkSpace\\fmbak\\webapps\\template", "/category.html");
        
        boolean b = TemplateConfig.getInstance().getBoolean("ayada.compile.ignore-jsptag");
        System.out.println(b);
        System.out.println(TemplateConfig.getInstance().getString("ayada.compile.ignore-jsptag"));
    }

    public static void test(String home, String file)
    {
        TemplateContext templateContext = new TemplateContext(home);
        Template template = templateContext.getTemplate(file);
        StringWriter writer = new StringWriter();
        PageContext pageContext = getPageContext(writer);
        DefaultExecutor.execute(template, pageContext);

        System.out.println("-------------- run result --------------");
        System.out.println(writer.toString());
    }

    public static void test(String home, String file, int count)
    {
        TemplateContext templateContext = new TemplateContext(home);
        Template template = templateContext.getTemplate(file);
        StringWriter writer = new StringWriter();
        PageContext pageContext = getPageContext(writer);
        OutputStream outputStream = null;

        try
        {
            DefaultExecutor.execute(template, pageContext);

            outputStream = new FileOutputStream("D:\\mem.log");
            PrintWriter out = new PrintWriter(outputStream);
            MemMonitor memMonitor = new MemMonitor();

            for(int i = 0; i < count; i++)
            {
                writer = new StringWriter();
                pageContext.setOut(new JspWriter(writer));
                DefaultExecutor.execute(template, pageContext);
                memMonitor.test(out, (i == 0), true);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(outputStream != null)
            {
                try
                {
                    outputStream.close();
                }
                catch(IOException e)
                {
                }
            }
        }

        // System.out.println("-------------- run result --------------");
        // System.out.println(writer.toString());
    }

    public static PageContext getPageContext(Writer out)
    {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("xuesong.net");
        user.setAge(1);

        List<User> userList = UserHandler.getUserList(16);
        PageContext pageContext = JspFactory.getPageContext(out);
        pageContext.setAttribute("user", user);
        pageContext.setAttribute("userList", userList);
        return pageContext;
    }

    public static void test1()
    {
        String source = IO.read(new File("webapp/large.html"), "UTF-8", 4096);
        System.out.println("source.length: " + source.length());

        TagLibrary tagLibrary = TagLibraryFactory.getStandardTagLibrary();
        TemplateCompiler compiler = new TemplateCompiler(source);
        compiler.setHome("webapp");
        compiler.setTagLibrary(tagLibrary);

        long t1 = System.currentTimeMillis();
        Template template = compiler.compile();
        long t2 = System.currentTimeMillis();
        System.out.println("compile time: " + (t2 - t1));

        long t3 = System.currentTimeMillis();
        StringWriter writer = new StringWriter();
        PageContext pageContext = getPageContext(writer);
        DefaultExecutor.execute(template, pageContext);

        long t4 = System.currentTimeMillis();
        System.out.println("run time: " + (t4 - t3));
        System.out.println("------------- result -------------");
        // System.out.println(writer.toString());
    }

    public static void test2()
    {
        StringWriter writer = new StringWriter();
        PageContext pageContext = JspFactory.getPageContext(writer);

        User user = new User();
        user.setUserId(1);
        user.setUserName("test1");

        List<User> userList = UserHandler.getUserList(16);
        pageContext.setAttribute("user", user);
        pageContext.setAttribute("userList", userList);

        Object result = TagUtil.evaluate(pageContext.getExpressionContext(), "a${user.userName}#");
        System.out.println(result.getClass().getName() + ": " + result);
    }

    public static void test3()
    {
        TemplateContext templateContext = new TemplateContext("webapp");  
        Template template = templateContext.getTemplate("/user/userList.tml");  
        StringWriter writer = new StringWriter();  
        PageContext pageContext = JspFactory.getPageContext(templateContext, writer);
        List<User> userList = UserHandler.getUserList(16);
        pageContext.setAttribute("userList", userList);
        DefaultExecutor.execute(template, pageContext);  
        System.out.println(writer.toString()); 
    }

    public static void reflectTest()
    {
        StringWriter out = new StringWriter();
        PageContext pageContext = JspFactory.getPageContext(out);

        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
        {
            testTag(TagFactory.create(pageContext, "c:if"));
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void newInstanceTest()
    {
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++)
        {
            testTag(new IfTag());
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void testTag(Tag tag)
    {
    }
    
    public static void compareTest(Object v1, Object v2)
    {
        System.out.println((v1 instanceof Comparable<?>));
        Class<?> t1 = v1.getClass();
        Class<?> t2 = v2.getClass();

        if (t1.isAssignableFrom(t2))
        {
            System.out.println("compareable");
        }
        else
        {
            System.out.println("error");
        }
    }
}
