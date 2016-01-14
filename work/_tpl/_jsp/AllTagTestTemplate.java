/*
 * $RCSfile: AllTagTestTemplate.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /allTagTest.xml
 * lastModified: 2015-12-23 13:34:12 000
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:16:58 352)
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
 * <p>Title: AllTagTestTemplate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AllTagTestTemplate extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        AllTagTestTemplate template = new AllTagTestTemplate();

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
        // out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<jsp:servlet\r\n    home=\"D:\\workspace2\\ayada\\webapp\"\r\n    path=\"allTagTest.jsp\"\r\n    lastModified=\"1385624639613\"\r\n    updateTime=\"1402971102807\"\r\n    xmlns:app=\"http://www.ayada.org/app\"\r\n    xmlns:c=\"http://www.ayada.org/c\"\r\n    xmlns:jsp=\"http://www.ayada.org/jsp\"\r\n    xmlns:t=\"http://www.ayada.org/t\">\r\n    <jsp:directive.page lineNumber=\"1\" offset=\"0\" length=\"2\" contentType=\"text/html;charset=UTF-8\"/>\r\n    <jsp:directive.taglib lineNumber=\"2\" offset=\"2\" length=\"2\" prefix=\"c\" taglib=\"\" uri=\"http://java.sun.com/jsp/jstl/core\"/>\r\n    <jsp:directive.taglib lineNumber=\"3\" offset=\"4\" length=\"2\" prefix=\"fmt\" taglib=\"\" uri=\"http://java.sun.com/jsp/jstl/fmt\"/>\r\n    <jsp:directive.page lineNumber=\"4\" offset=\"6\" length=\"2\" import=\"java.io.IOException\"/>\r\n    <t:import lineNumber=\"5\" offset=\"8\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"test.com.skin.ayada.taglib.ScrollPage\" name=\"app:scrollpage\"/>\r\n    <t:import lineNumber=\"6\" offset=\"10\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"com.skin.ayada.jstl.core.TestTag\" name=\"app:test\"/>\r\n    <t:import lineNumber=\"7\" offset=\"12\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"test.com.skin.ayada.taglib.TestBodyTag\" name=\"app:bodytest\"/>\r\n    <jsp:declaration lineNumber=\"9\" offset=\"14\" length=\"2\">    public void hello1(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"14\" offset=\"16\" length=\"2\">    public void hello2(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"20\" offset=\"18\" length=\"2\">    public void hello3(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"26\" offset=\"20\" length=\"2\">    public void hello4(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <text lineNumber=\"31\" offset=\"22\" length=\"1\">&lt;html&gt;\\r\\n&lt;head&gt;\\r\\n&lt;title&gt;test&lt;/title&gt;\\r\\n&lt;/head&gt;\\r\\n&lt;body jsp=&quot;</text>\r\n    <jsp:expression lineNumber=\"35\" offset=\"23\" length=\"2\">1 + 2</jsp:expression>\r\n    <text lineNumber=\"35\" offset=\"25\" length=\"1\">&quot; version=&quot;1.0&quot;&gt;\\r\\n============================================\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"38\" offset=\"26\" length=\"2\">    out.println(&quot;Hello, World !&quot;);\\r\\n</jsp:scriptlet>\r\n    <text lineNumber=\"41\" offset=\"28\" length=\"1\">============================================\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"42\" offset=\"29\" length=\"2\">    out.println(&quot;Hello, World !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:declaration lineNumber=\"46\" offset=\"31\" length=\"2\">    public int myInt = 0;\\r\\n</jsp:declaration>\r\n    <jsp:scriptlet lineNumber=\"50\" offset=\"33\" length=\"2\">    // out.println(&quot;Hello, World1 !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:scriptlet lineNumber=\"54\" offset=\"35\" length=\"2\">    // out.println(&quot;Hello, World2 ! &lt;/test&quot;);\\r\\n    // out.println(&quot;Hello, World2 ! &lt;/jsp:scriptlet2&gt;&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:scriptlet lineNumber=\"60\" offset=\"37\" length=\"2\">    int mytest = 0;\\r\\n</jsp:scriptlet>\r\n    <text lineNumber=\"63\" offset=\"39\" length=\"1\">&lt;p&gt;\\r\\n    myInt: </text>\r\n    <jsp:expression lineNumber=\"64\" offset=\"40\" length=\"2\"> this.myInt </jsp:expression>\r\n    <text lineNumber=\"64\" offset=\"42\" length=\"1\">\\r\\n&lt;/p&gt;\\r\\n\\r\\n&lt;p&gt;\\r\\n    mytest: </text>\r\n    <jsp:expression lineNumber=\"68\" offset=\"43\" length=\"2\">mytest</jsp:expression>\r\n    <text lineNumber=\"68\" offset=\"45\" length=\"1\">\\r\\n&lt;/p&gt;\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"70\" offset=\"46\" length=\"2\">    out.println(&quot;Hello, World4 !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:expression lineNumber=\"74\" offset=\"48\" length=\"2\">(&quot;Hello&quot; + &quot; &quot; + &quot;World !&quot;)</jsp:expression>\r\n    <text lineNumber=\"74\" offset=\"50\" length=\"1\">\\r\\n============================================\\r\\n</text>\r\n    <c:set lineNumber=\"76\" offset=\"51\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"${StringUtil.replace(&#39;abc&#39;, &#39;b&#39;, &#39;\\n&#39;)}\" var=\"myString\"/>\r\n    <text lineNumber=\"77\" offset=\"53\" length=\"1\">&lt;p&gt;myString: [</text>\r\n    <c:out lineNumber=\"77\" offset=\"54\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"${myString}\"/>\r\n    <text lineNumber=\"77\" offset=\"56\" length=\"1\">]&lt;/p&gt;\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"79\" offset=\"57\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"&quot;a + 1&quot;\" var=\"myString\"/>\r\n    <text lineNumber=\"80\" offset=\"59\" length=\"1\">&lt;p&gt;myString: [</text>\r\n    <c:out lineNumber=\"80\" offset=\"60\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"${myString}\"/>\r\n    <text lineNumber=\"80\" offset=\"62\" length=\"1\">]&lt;/p&gt;\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"82\" offset=\"63\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"Hello, World!\" var=\"myVar\"/>\r\n    <text lineNumber=\"83\" offset=\"65\" length=\"1\">&lt;h1&gt;############## </text>\r\n    <variable lineNumber=\"83\" offset=\"66\" length=\"1\">myVar</variable>\r\n    <text lineNumber=\"83\" offset=\"67\" length=\"1\"> ##############&lt;/h1&gt;\\r\\n\\r\\n</text>\r\n    <c:out lineNumber=\"85\" offset=\"68\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"c:out: Hello, World!\"/>\r\n    <text lineNumber=\"85\" offset=\"70\" length=\"1\">\\r\\n&lt;div style=&quot;background-color: #c0c0c0;&quot;&gt;&lt;/div&gt;\\r\\n</text>\r\n    <c:out lineNumber=\"87\" offset=\"71\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"false\" value=\"&quot;&lt;div&gt;Hello World!&lt;/div&gt;&quot;\"/>\r\n    <text lineNumber=\"87\" offset=\"73\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"88\" offset=\"74\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\">\r\n        <text lineNumber=\"88\" offset=\"75\" length=\"1\">&lt;h1&gt;Hello World!&lt;/h1&gt;</text>\r\n    </c:out>\r\n    <text lineNumber=\"88\" offset=\"77\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"89\" offset=\"78\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\" value=\"&lt;div&gt;Hello World!&lt;/div&gt;\">\r\n        <text lineNumber=\"89\" offset=\"79\" length=\"1\">&lt;h1&gt;Hello World!&lt;/h1&gt;</text>\r\n    </c:out>\r\n    <text lineNumber=\"89\" offset=\"81\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"91\" offset=\"82\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"xuesong.net\" var=\"myName\"/>\r\n    <c:out lineNumber=\"92\" offset=\"84\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\" value=\"Hello, ${myName}!\"/>\r\n    <text lineNumber=\"92\" offset=\"86\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"93\" offset=\"87\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"false\" value=\"Hello, ${myName}!\"/>\r\n    <text lineNumber=\"93\" offset=\"89\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <c:if lineNumber=\"95\" offset=\"90\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.IfTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.IfTagFactory\" test=\"${1 == 1}\">\r\n        <text lineNumber=\"95\" offset=\"91\" length=\"1\">c:if test</text>\r\n    </c:if>\r\n    <text lineNumber=\"95\" offset=\"93\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:forEach test1&lt;/h1&gt;\\r\\n</text>\r\n    <c:each lineNumber=\"98\" offset=\"94\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.ForEachTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ForEachTagFactory\" items=\"1,2,3,4,5\" var=\"mynum\">\r\n        <variable lineNumber=\"100\" offset=\"95\" length=\"1\">mynum</variable>\r\n    </c:each>\r\n    <text lineNumber=\"100\" offset=\"97\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:forEach test2&lt;/h1&gt;\\r\\n</text>\r\n    <c:forEach lineNumber=\"103\" offset=\"98\" length=\"20\" tagClass=\"com.skin.ayada.jstl.core.ForEachTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ForEachTagFactory\" items=\"${userList}\" var=\"user\" varStatus=\"status\">\r\n        <text lineNumber=\"103\" offset=\"99\" length=\"1\">\\r\\n    &lt;p&gt;user: </text>\r\n        <expression lineNumber=\"104\" offset=\"100\" length=\"1\">user.userName</expression>\r\n        <text lineNumber=\"104\" offset=\"101\" length=\"1\">&lt;/p&gt;\\r\\n    </text>\r\n        <c:choose lineNumber=\"105\" offset=\"102\" length=\"14\" tagClass=\"com.skin.ayada.jstl.core.ChooseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ChooseTagFactory\">\r\n            <c:when lineNumber=\"106\" offset=\"103\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test1&#39;}\">\r\n                <text lineNumber=\"106\" offset=\"104\" length=\"1\">&lt;p&gt;test1, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:when lineNumber=\"107\" offset=\"106\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test2&#39;}\">\r\n                <text lineNumber=\"107\" offset=\"107\" length=\"1\">&lt;p&gt;test2, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:when lineNumber=\"108\" offset=\"109\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test3&#39;}\">\r\n                <text lineNumber=\"108\" offset=\"110\" length=\"1\">&lt;p&gt;test3, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:otherwise lineNumber=\"109\" offset=\"112\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OtherwiseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OtherwiseTagFactory\">\r\n                <text lineNumber=\"109\" offset=\"113\" length=\"1\">&lt;p&gt;unknown user! Do you known &#39;bad egg&#39;? You! Are!&lt;/p&gt;</text>\r\n            </c:otherwise>\r\n        </c:choose>\r\n        <text lineNumber=\"110\" offset=\"116\" length=\"1\">\\r\\n</text>\r\n    </c:forEach>\r\n    <text lineNumber=\"111\" offset=\"118\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:choose test1&lt;/h1&gt;\\r\\n</text>\r\n    <c:choose lineNumber=\"114\" offset=\"119\" length=\"14\" tagClass=\"com.skin.ayada.jstl.core.ChooseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ChooseTagFactory\">\r\n        <c:when lineNumber=\"115\" offset=\"120\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${1 == 1}\">\r\n            <text lineNumber=\"115\" offset=\"121\" length=\"1\">c:when test=&quot;{1 == 1}&quot;</text>\r\n        </c:when>\r\n        <c:when lineNumber=\"116\" offset=\"123\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${2 == 2}\">\r\n            <text lineNumber=\"116\" offset=\"124\" length=\"1\">c:when test=&quot;{2 == 2}&quot;</text>\r\n        </c:when>\r\n        <c:when lineNumber=\"117\" offset=\"126\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${3 == 3}\">\r\n            <text lineNumber=\"117\" offset=\"127\" length=\"1\">c:when test=&quot;{3 == 3}&quot;</text>\r\n        </c:when>\r\n        <c:otherwise lineNumber=\"118\" offset=\"129\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OtherwiseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OtherwiseTagFactory\">\r\n            <text lineNumber=\"118\" offset=\"130\" length=\"1\">c:otherwise</text>\r\n        </c:otherwise>\r\n    </c:choose>\r\n    <text lineNumber=\"119\" offset=\"133\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;app:test test1&lt;/h1&gt;\\r\\n</text>\r\n    <app:test lineNumber=\"122\" offset=\"134\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myBoolean=\"true\" myByte=\"1\" myChar=\"c\" myDouble=\"1.0d\" myFloat=\"1.0f\" myInt=\"-1.0\" myLong=\"1L\" myString=\"Hello\"/>\r\n    <text lineNumber=\"122\" offset=\"136\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"123\" offset=\"137\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myBoolean=\"false\" myByte=\"243\" myChar=\"c\" myDouble=\"1.0D\" myFloat=\"1.0F\" myInt=\"-1.0\" myLong=\"1L\" myString=\"Hello\"/>\r\n    <text lineNumber=\"123\" offset=\"139\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"124\" offset=\"140\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myDouble=\"1e3\" myFloat=\"1.0\" myInt=\"-1.0\" myLong=\"1e3\" myString=\"Hello\"/>\r\n    <text lineNumber=\"124\" offset=\"142\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"125\" offset=\"143\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myDouble=\"1.2e3\" myFloat=\"1.0\" myInt=\"-1.0\" myLong=\"1.2e3\" myString=\"Hello\"/>\r\n    <text lineNumber=\"125\" offset=\"145\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;app:scrollpage test1&lt;/h1&gt;\\r\\n</text>\r\n    <app:scrollpage lineNumber=\"128\" offset=\"146\" length=\"2\" tagClass=\"test.com.skin.ayada.taglib.ScrollPage\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.ScrollPageFactory\" count=\"254\" pageNum=\"2\" pageSize=\"10\"/>\r\n    <text lineNumber=\"128\" offset=\"148\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <app:bodytest lineNumber=\"130\" offset=\"149\" length=\"2\" tagClass=\"test.com.skin.ayada.taglib.TestBodyTag\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.TestBodyTagFactory\"/>\r\n    <text lineNumber=\"130\" offset=\"151\" length=\"1\">\\r\\n</text>\r\n    <app:bodytest lineNumber=\"131\" offset=\"152\" length=\"3\" tagClass=\"test.com.skin.ayada.taglib.TestBodyTag\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.TestBodyTagFactory\">\r\n        <text lineNumber=\"131\" offset=\"153\" length=\"1\">Hello World !</text>\r\n    </app:bodytest>\r\n    <text lineNumber=\"131\" offset=\"155\" length=\"1\">\\r\\n</text>\r\n    <c:test lineNumber=\"132\" offset=\"156\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\"/>\r\n    <text lineNumber=\"132\" offset=\"158\" length=\"1\">\\r\\n&lt;/body&gt;\\r\\n&lt;/html&gt;</text>\r\n</jsp:servlet>\r\n");
        out.write(_jsp_string_1, 0, _jsp_string_1.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<jsp:servlet\r\n    home=\"D:\\workspace2\\ayada\\webapp\"\r\n    path=\"allTagTest.jsp\"\r\n    lastModified=\"1385624639613\"\r\n    updateTime=\"1402971102807\"\r\n    xmlns:app=\"http://www.ayada.org/app\"\r\n    xmlns:c=\"http://www.ayada.org/c\"\r\n    xmlns:jsp=\"http://www.ayada.org/jsp\"\r\n    xmlns:t=\"http://www.ayada.org/t\">\r\n    <jsp:directive.page lineNumber=\"1\" offset=\"0\" length=\"2\" contentType=\"text/html;charset=UTF-8\"/>\r\n    <jsp:directive.taglib lineNumber=\"2\" offset=\"2\" length=\"2\" prefix=\"c\" taglib=\"\" uri=\"http://java.sun.com/jsp/jstl/core\"/>\r\n    <jsp:directive.taglib lineNumber=\"3\" offset=\"4\" length=\"2\" prefix=\"fmt\" taglib=\"\" uri=\"http://java.sun.com/jsp/jstl/fmt\"/>\r\n    <jsp:directive.page lineNumber=\"4\" offset=\"6\" length=\"2\" import=\"java.io.IOException\"/>\r\n    <t:import lineNumber=\"5\" offset=\"8\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"test.com.skin.ayada.taglib.ScrollPage\" name=\"app:scrollpage\"/>\r\n    <t:import lineNumber=\"6\" offset=\"10\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"com.skin.ayada.jstl.core.TestTag\" name=\"app:test\"/>\r\n    <t:import lineNumber=\"7\" offset=\"12\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.ImportTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ImportTagFactory\" className=\"test.com.skin.ayada.taglib.TestBodyTag\" name=\"app:bodytest\"/>\r\n    <jsp:declaration lineNumber=\"9\" offset=\"14\" length=\"2\">    public void hello1(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"14\" offset=\"16\" length=\"2\">    public void hello2(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"20\" offset=\"18\" length=\"2\">    public void hello3(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <jsp:declaration lineNumber=\"26\" offset=\"20\" length=\"2\">    public void hello4(JspWriter out) throws IOException{\\r\\n        out.println(&quot;Hello, World !&quot;);\\r\\n    }\\r\\n</jsp:declaration>\r\n    <text lineNumber=\"31\" offset=\"22\" length=\"1\">&lt;html&gt;\\r\\n&lt;head&gt;\\r\\n&lt;title&gt;test&lt;/title&gt;\\r\\n&lt;/head&gt;\\r\\n&lt;body jsp=&quot;</text>\r\n    <jsp:expression lineNumber=\"35\" offset=\"23\" length=\"2\">1 + 2</jsp:expression>\r\n    <text lineNumber=\"35\" offset=\"25\" length=\"1\">&quot; version=&quot;1.0&quot;&gt;\\r\\n============================================\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"38\" offset=\"26\" length=\"2\">    out.println(&quot;Hello, World !&quot;);\\r\\n</jsp:scriptlet>\r\n    <text lineNumber=\"41\" offset=\"28\" length=\"1\">============================================\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"42\" offset=\"29\" length=\"2\">    out.println(&quot;Hello, World !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:declaration lineNumber=\"46\" offset=\"31\" length=\"2\">    public int myInt = 0;\\r\\n</jsp:declaration>\r\n    <jsp:scriptlet lineNumber=\"50\" offset=\"33\" length=\"2\">    // out.println(&quot;Hello, World1 !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:scriptlet lineNumber=\"54\" offset=\"35\" length=\"2\">    // out.println(&quot;Hello, World2 ! &lt;/test&quot;);\\r\\n    // out.println(&quot;Hello, World2 ! &lt;/jsp:scriptlet2&gt;&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:scriptlet lineNumber=\"60\" offset=\"37\" length=\"2\">    int mytest = 0;\\r\\n</jsp:scriptlet>\r\n    <text lineNumber=\"63\" offset=\"39\" length=\"1\">&lt;p&gt;\\r\\n    myInt: </text>\r\n    <jsp:expression lineNumber=\"64\" offset=\"40\" length=\"2\"> this.myInt </jsp:expression>\r\n    <text lineNumber=\"64\" offset=\"42\" length=\"1\">\\r\\n&lt;/p&gt;\\r\\n\\r\\n&lt;p&gt;\\r\\n    mytest: </text>\r\n    <jsp:expression lineNumber=\"68\" offset=\"43\" length=\"2\">mytest</jsp:expression>\r\n    <text lineNumber=\"68\" offset=\"45\" length=\"1\">\\r\\n&lt;/p&gt;\\r\\n</text>\r\n    <jsp:scriptlet lineNumber=\"70\" offset=\"46\" length=\"2\">    out.println(&quot;Hello, World4 !&quot;);\\r\\n</jsp:scriptlet>\r\n    <jsp:expression lineNumber=\"74\" offset=\"48\" length=\"2\">(&quot;Hello&quot; + &quot; &quot; + &quot;World !&quot;)</jsp:expression>\r\n    <text lineNumber=\"74\" offset=\"50\" length=\"1\">\\r\\n============================================\\r\\n</text>\r\n    <c:set lineNumber=\"76\" offset=\"51\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"${StringUtil.replace(&#39;abc&#39;, &#39;b&#39;, &#39;\\n&#39;)}\" var=\"myString\"/>\r\n    <text lineNumber=\"77\" offset=\"53\" length=\"1\">&lt;p&gt;myString: [</text>\r\n    <c:out lineNumber=\"77\" offset=\"54\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"${myString}\"/>\r\n    <text lineNumber=\"77\" offset=\"56\" length=\"1\">]&lt;/p&gt;\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"79\" offset=\"57\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"&quot;a + 1&quot;\" var=\"myString\"/>\r\n    <text lineNumber=\"80\" offset=\"59\" length=\"1\">&lt;p&gt;myString: [</text>\r\n    <c:out lineNumber=\"80\" offset=\"60\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"${myString}\"/>\r\n    <text lineNumber=\"80\" offset=\"62\" length=\"1\">]&lt;/p&gt;\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"82\" offset=\"63\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"Hello, World!\" var=\"myVar\"/>\r\n    <text lineNumber=\"83\" offset=\"65\" length=\"1\">&lt;h1&gt;############## </text>\r\n    <variable lineNumber=\"83\" offset=\"66\" length=\"1\">myVar</variable>\r\n    <text lineNumber=\"83\" offset=\"67\" length=\"1\"> ##############&lt;/h1&gt;\\r\\n\\r\\n</text>\r\n    <c:out lineNumber=\"85\" offset=\"68\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" value=\"c:out: Hello, World!\"/>\r\n    <text lineNumber=\"85\" offset=\"70\" length=\"1\">\\r\\n&lt;div style=&quot;background-color: #c0c0c0;&quot;&gt;&lt;/div&gt;\\r\\n</text>\r\n    <c:out lineNumber=\"87\" offset=\"71\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"false\" value=\"&quot;&lt;div&gt;Hello World!&lt;/div&gt;&quot;\"/>\r\n    <text lineNumber=\"87\" offset=\"73\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"88\" offset=\"74\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\">\r\n        <text lineNumber=\"88\" offset=\"75\" length=\"1\">&lt;h1&gt;Hello World!&lt;/h1&gt;</text>\r\n    </c:out>\r\n    <text lineNumber=\"88\" offset=\"77\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"89\" offset=\"78\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\" value=\"&lt;div&gt;Hello World!&lt;/div&gt;\">\r\n        <text lineNumber=\"89\" offset=\"79\" length=\"1\">&lt;h1&gt;Hello World!&lt;/h1&gt;</text>\r\n    </c:out>\r\n    <text lineNumber=\"89\" offset=\"81\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <c:set lineNumber=\"91\" offset=\"82\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.SetTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.SetTagFactory\" value=\"xuesong.net\" var=\"myName\"/>\r\n    <c:out lineNumber=\"92\" offset=\"84\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"true\" value=\"Hello, ${myName}!\"/>\r\n    <text lineNumber=\"92\" offset=\"86\" length=\"1\">\\r\\n</text>\r\n    <c:out lineNumber=\"93\" offset=\"87\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.OutTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OutTagFactory\" escapeXml=\"false\" value=\"Hello, ${myName}!\"/>\r\n    <text lineNumber=\"93\" offset=\"89\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <c:if lineNumber=\"95\" offset=\"90\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.IfTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.IfTagFactory\" test=\"${1 == 1}\">\r\n        <text lineNumber=\"95\" offset=\"91\" length=\"1\">c:if test</text>\r\n    </c:if>\r\n    <text lineNumber=\"95\" offset=\"93\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:forEach test1&lt;/h1&gt;\\r\\n</text>\r\n    <c:each lineNumber=\"98\" offset=\"94\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.ForEachTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ForEachTagFactory\" items=\"1,2,3,4,5\" var=\"mynum\">\r\n        <variable lineNumber=\"100\" offset=\"95\" length=\"1\">mynum</variable>\r\n    </c:each>\r\n    <text lineNumber=\"100\" offset=\"97\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:forEach test2&lt;/h1&gt;\\r\\n</text>\r\n    <c:forEach lineNumber=\"103\" offset=\"98\" length=\"20\" tagClass=\"com.skin.ayada.jstl.core.ForEachTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ForEachTagFactory\" items=\"${userList}\" var=\"user\" varStatus=\"status\">\r\n        <text lineNumber=\"103\" offset=\"99\" length=\"1\">\\r\\n    &lt;p&gt;user: </text>\r\n        <expression lineNumber=\"104\" offset=\"100\" length=\"1\">user.userName</expression>\r\n        <text lineNumber=\"104\" offset=\"101\" length=\"1\">&lt;/p&gt;\\r\\n    </text>\r\n        <c:choose lineNumber=\"105\" offset=\"102\" length=\"14\" tagClass=\"com.skin.ayada.jstl.core.ChooseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ChooseTagFactory\">\r\n            <c:when lineNumber=\"106\" offset=\"103\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test1&#39;}\">\r\n                <text lineNumber=\"106\" offset=\"104\" length=\"1\">&lt;p&gt;test1, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:when lineNumber=\"107\" offset=\"106\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test2&#39;}\">\r\n                <text lineNumber=\"107\" offset=\"107\" length=\"1\">&lt;p&gt;test2, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:when lineNumber=\"108\" offset=\"109\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${user.userName == &#39;test3&#39;}\">\r\n                <text lineNumber=\"108\" offset=\"110\" length=\"1\">&lt;p&gt;test3, good man !&lt;/p&gt;</text>\r\n            </c:when>\r\n            <c:otherwise lineNumber=\"109\" offset=\"112\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OtherwiseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OtherwiseTagFactory\">\r\n                <text lineNumber=\"109\" offset=\"113\" length=\"1\">&lt;p&gt;unknown user! Do you known &#39;bad egg&#39;? You! Are!&lt;/p&gt;</text>\r\n            </c:otherwise>\r\n        </c:choose>\r\n        <text lineNumber=\"110\" offset=\"116\" length=\"1\">\\r\\n</text>\r\n    </c:forEach>\r\n    <text lineNumber=\"111\" offset=\"118\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;c:choose test1&lt;/h1&gt;\\r\\n</text>\r\n    <c:choose lineNumber=\"114\" offset=\"119\" length=\"14\" tagClass=\"com.skin.ayada.jstl.core.ChooseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.ChooseTagFactory\">\r\n        <c:when lineNumber=\"115\" offset=\"120\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${1 == 1}\">\r\n            <text lineNumber=\"115\" offset=\"121\" length=\"1\">c:when test=&quot;{1 == 1}&quot;</text>\r\n        </c:when>\r\n        <c:when lineNumber=\"116\" offset=\"123\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${2 == 2}\">\r\n            <text lineNumber=\"116\" offset=\"124\" length=\"1\">c:when test=&quot;{2 == 2}&quot;</text>\r\n        </c:when>\r\n        <c:when lineNumber=\"117\" offset=\"126\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.WhenTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.WhenTagFactory\" test=\"${3 == 3}\">\r\n            <text lineNumber=\"117\" offset=\"127\" length=\"1\">c:when test=&quot;{3 == 3}&quot;</text>\r\n        </c:when>\r\n        <c:otherwise lineNumber=\"118\" offset=\"129\" length=\"3\" tagClass=\"com.skin.ayada.jstl.core.OtherwiseTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.OtherwiseTagFactory\">\r\n            <text lineNumber=\"118\" offset=\"130\" length=\"1\">c:otherwise</text>\r\n        </c:otherwise>\r\n    </c:choose>\r\n    <text lineNumber=\"119\" offset=\"133\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;app:test test1&lt;/h1&gt;\\r\\n</text>\r\n    <app:test lineNumber=\"122\" offset=\"134\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myBoolean=\"true\" myByte=\"1\" myChar=\"c\" myDouble=\"1.0d\" myFloat=\"1.0f\" myInt=\"-1.0\" myLong=\"1L\" myString=\"Hello\"/>\r\n    <text lineNumber=\"122\" offset=\"136\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"123\" offset=\"137\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myBoolean=\"false\" myByte=\"243\" myChar=\"c\" myDouble=\"1.0D\" myFloat=\"1.0F\" myInt=\"-1.0\" myLong=\"1L\" myString=\"Hello\"/>\r\n    <text lineNumber=\"123\" offset=\"139\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"124\" offset=\"140\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myDouble=\"1e3\" myFloat=\"1.0\" myInt=\"-1.0\" myLong=\"1e3\" myString=\"Hello\"/>\r\n    <text lineNumber=\"124\" offset=\"142\" length=\"1\">\\r\\n</text>\r\n    <app:test lineNumber=\"125\" offset=\"143\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\" myDouble=\"1.2e3\" myFloat=\"1.0\" myInt=\"-1.0\" myLong=\"1.2e3\" myString=\"Hello\"/>\r\n    <text lineNumber=\"125\" offset=\"145\" length=\"1\">\\r\\n\\r\\n&lt;h1&gt;app:scrollpage test1&lt;/h1&gt;\\r\\n</text>\r\n    <app:scrollpage lineNumber=\"128\" offset=\"146\" length=\"2\" tagClass=\"test.com.skin.ayada.taglib.ScrollPage\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.ScrollPageFactory\" count=\"254\" pageNum=\"2\" pageSize=\"10\"/>\r\n    <text lineNumber=\"128\" offset=\"148\" length=\"1\">\\r\\n\\r\\n</text>\r\n    <app:bodytest lineNumber=\"130\" offset=\"149\" length=\"2\" tagClass=\"test.com.skin.ayada.taglib.TestBodyTag\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.TestBodyTagFactory\"/>\r\n    <text lineNumber=\"130\" offset=\"151\" length=\"1\">\\r\\n</text>\r\n    <app:bodytest lineNumber=\"131\" offset=\"152\" length=\"3\" tagClass=\"test.com.skin.ayada.taglib.TestBodyTag\" tagFactory=\"_tpl.test.com.skin.ayada.taglib.factory.TestBodyTagFactory\">\r\n        <text lineNumber=\"131\" offset=\"153\" length=\"1\">Hello World !</text>\r\n    </app:bodytest>\r\n    <text lineNumber=\"131\" offset=\"155\" length=\"1\">\\r\\n</text>\r\n    <c:test lineNumber=\"132\" offset=\"156\" length=\"2\" tagClass=\"com.skin.ayada.jstl.core.TestTag\" tagFactory=\"_tpl.com.skin.ayada.jstl.core.factory.TestTagFactory\"/>\r\n    <text lineNumber=\"132\" offset=\"158\" length=\"1\">\\r\\n&lt;/body&gt;\\r\\n&lt;/html&gt;</text>\r\n</jsp:servlet>\r\n".toCharArray();

}
