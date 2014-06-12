[TEXT]: <!--\r\nt:import: 编译指令\r\n1. 可以放在任何位置, 但必须在使用之前引入\r\n2. 如果多次引入同一个tag, tag的bodyContent以最后一次引入的为准, 引擎在编译结束之后才会根据bodyContent的类型做一次紧缩处理\r\n   bodyContent: jsp|tagdependent|empty\r\n   如果是tagdependent, 那么该tag内部的所有文本节点和表达式节点都会被清除, 其子节点的内容不会清除(但是会根据子节点的bodyContent决定是否清除)\r\n   如果是empty, 那么内部的任何节点都会被清除\r\n   如果是jsp, 则保持现有内容不变\r\n   因此所有的引入操作最好放在文件头, 并且对同一个tag只引入一次\r\n\r\n3. className不是必选项, 可以为空, 如果为空则使用ayada-taglib-default.xml或者ayada-taglib.xml文件中配置的className, 因此下面的两种写法都是合法的\r\n    
[NODE]: <t:import lineNumber="13" offset="1" length="2" tagClass="com.skin.ayada.jstl.core.ImportTag" tagFactory="com.skin.ayada.jstl.factory.ImportTagFactory" name="c:if" bodyContent="tagdependent" description="重写c:if标签, 不输出内容">
[NODE]: </t:import>
[TEXT]:     
[NODE]: <t:import lineNumber="14" offset="4" length="2" tagClass="com.skin.ayada.jstl.core.ImportTag" tagFactory="com.skin.ayada.jstl.factory.ImportTagFactory" name="c:if" className="com.skin.ayada.jstl.core.IfTag" bodyContent="tagdependent" description="重写c:if标签, 不输出内容">
[NODE]: </t:import>
[TEXT]: 4. bodyContent和description都不是必选项, 可以为空, bodyContent默认为jsp\r\n-->\r\n
[NODE]: <t:import lineNumber="18" offset="7" length="2" tagClass="com.skin.ayada.jstl.core.ImportTag" tagFactory="com.skin.ayada.jstl.factory.ImportTagFactory" name="c:if" bodyContent="tagdependent" description="重写c:if标签, 不输出内容">
[NODE]: </t:import>
[NODE]: <t:import lineNumber="19" offset="9" length="2" tagClass="com.skin.ayada.jstl.core.ImportTag" tagFactory="com.skin.ayada.jstl.factory.ImportTagFactory" name="c:if" className="com.skin.ayada.jstl.core.IfTag" bodyContent="tagdependent" description="重写c:if标签, 不输出内容">
[NODE]: </t:import>
[TEXT]: <h1>tag.bodyContent</h1>\r\n<p>1. jsp: any content</p>\r\n<p>2. tagdependent: tag only</p>\r\n<p>3. empty: ignore any content</p>\r\n\r\n<!-- 使用重新定义的c:if标签, 该标签内部的所有文本内容在编译期都会被清除, 但是自标签的文本仍然可以输出 -->\r\n
[NODE]: <c:if lineNumber="27" offset="12" length="5" tagClass="com.skin.ayada.jstl.core.IfTag" tagFactory="com.skin.ayada.jstl.factory.IfTagFactory" test="${1 == 1}">
[NODE]: <c:out lineNumber="29" offset="13" length="3" tagClass="com.skin.ayada.jstl.core.OutTag" tagFactory="com.skin.ayada.jstl.factory.OutTagFactory" escapeXml="true">
[TEXT]: \"I\'m here !\"
[NODE]: </c:out>
[NODE]: </c:if>
[TEXT]: \r\n\r\n<!-- c:command的bodyContent被定义为tagdependent，因此内部的文本内容都会被忽略。-->\r\n
[NODE]: <c:command lineNumber="33" offset="18" length="16" tagClass="com.skin.ayada.jstl.core.DependentTag" tagFactory="com.skin.ayada.jstl.factory.DependentTagFactory">
[NODE]: <c:if lineNumber="35" offset="19" length="14" tagClass="com.skin.ayada.jstl.core.IfTag" tagFactory="com.skin.ayada.jstl.factory.IfTagFactory" test="${1 == 2}">
[NODE]: <io:copy lineNumber="36" offset="20" length="2" tagClass="com.skin.ayada.jstl.io.CopyTag" tagFactory="com.skin.ayada.jstl.factory.CopyTagFactory" file="E:/WorkSpace/ayada/webapp/test1" todir="E:/WorkSpace/ayada/webapp/test2">
[NODE]: </io:copy>
[NODE]: <io:delete lineNumber="37" offset="22" length="2" tagClass="com.skin.ayada.jstl.io.DeleteTag" tagFactory="com.skin.ayada.jstl.factory.DeleteTagFactory" file="E:/WorkSpace/ayada/webapp/test2/style.css">
[NODE]: </io:delete>
[NODE]: <io:mkdir lineNumber="38" offset="24" length="2" tagClass="com.skin.ayada.jstl.io.MakeDirTag" tagFactory="com.skin.ayada.jstl.factory.MakeDirTagFactory" file="E:/WorkSpace/ayada/webapp/test2/empty1">
[NODE]: </io:mkdir>
[NODE]: <io:mkdir lineNumber="39" offset="26" length="2" tagClass="com.skin.ayada.jstl.io.MakeDirTag" tagFactory="com.skin.ayada.jstl.factory.MakeDirTagFactory" file="E:/WorkSpace/ayada/webapp/test2/empty2">
[NODE]: </io:mkdir>
[NODE]: <io:delete lineNumber="40" offset="28" length="2" tagClass="com.skin.ayada.jstl.io.DeleteTag" tagFactory="com.skin.ayada.jstl.factory.DeleteTagFactory" file="E:/WorkSpace/ayada/webapp/test2/empty2">
[NODE]: </io:delete>
[NODE]: <c:exit lineNumber="41" offset="30" length="2" tagClass="com.skin.ayada.jstl.core.ExitTag" tagFactory="com.skin.ayada.jstl.factory.ExitTagFactory" test="${1 == 1}">
[NODE]: </c:exit>
[NODE]: </c:if>
[NODE]: </c:command>
[TEXT]: \r\n\r\n<h1>sql:execute</h1>\r\n<h2>connection</h2>\r\n<p>1. get from attribute, example: connection=\"${expression}\"</p>\r\n<p>2. get from pageContext by name: connection</p>\r\n<p>3. get from parent tag</p>\r\n<p>4. throws exception</p>\r\n<p>template.home: 
[EXPR]: ${template.home}
[TEXT]: </p>\r\n\r\n<!-- use external connection -->\r\n
[NODE]: <sql:connect lineNumber="54" offset="37" length="2" tagClass="com.skin.ayada.jstl.sql.ConnectTag" tagFactory="com.skin.ayada.jstl.factory.ConnectTagFactory" var="connection2" connection="${myConnection}">
[NODE]: </sql:connect>
[TEXT]: \r\n\r\n
[NODE]: <c:if lineNumber="56" offset="40" length="12" tagClass="com.skin.ayada.jstl.core.IfTag" tagFactory="com.skin.ayada.jstl.factory.IfTagFactory" test="${1 == 1}">
[NODE]: <c:set lineNumber="57" offset="41" length="2" tagClass="com.skin.ayada.jstl.core.SetTag" tagFactory="com.skin.ayada.jstl.factory.SetTagFactory" var="createDatabaseUrl" value="jdbc:mysql://localhost:3306?user=root&password=1234&characterEncoding=utf8">
[NODE]: </c:set>
[NODE]: <c:set lineNumber="58" offset="43" length="2" tagClass="com.skin.ayada.jstl.core.SetTag" tagFactory="com.skin.ayada.jstl.factory.SetTagFactory" var="url" value="jdbc:mysql://localhost:3306/mytest2?user=root&password=1234&characterEncoding=utf8">
[NODE]: </c:set>
[NODE]: <c:set lineNumber="59" offset="45" length="2" tagClass="com.skin.ayada.jstl.core.SetTag" tagFactory="com.skin.ayada.jstl.factory.SetTagFactory" var="driverClass" value="com.mysql.jdbc.Driver">
[NODE]: </c:set>
[NODE]: <c:set lineNumber="60" offset="47" length="2" tagClass="com.skin.ayada.jstl.core.SetTag" tagFactory="com.skin.ayada.jstl.factory.SetTagFactory" var="userName" value="root">
[NODE]: </c:set>
[NODE]: <c:set lineNumber="61" offset="49" length="2" tagClass="com.skin.ayada.jstl.core.SetTag" tagFactory="com.skin.ayada.jstl.factory.SetTagFactory" var="password" value="1234">
[NODE]: </c:set>
[NODE]: </c:if>
[TEXT]: \r\n\r\n
[NODE]: <sql:connect lineNumber="64" offset="53" length="7" tagClass="com.skin.ayada.jstl.sql.ConnectTag" tagFactory="com.skin.ayada.jstl.factory.ConnectTagFactory" var="connection" url="${createDatabaseUrl}" driverClass="com.mysql.jdbc.Driver" userName="${userName}" password="${password}">
[TEXT]: \r\n    
[NODE]: <sql:execute lineNumber="65" offset="55" length="3" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" out="${pageContext}">
[TEXT]: \r\n        drop database if exists mytest2;\r\n        create database mytest2 character set utf8;\r\n    
[NODE]: </sql:execute>
[TEXT]: \r\n
[NODE]: </sql:connect>
[TEXT]: \r\n\r\n
[NODE]: <sql:connect lineNumber="71" offset="61" length="56" tagClass="com.skin.ayada.jstl.sql.ConnectTag" tagFactory="com.skin.ayada.jstl.factory.ConnectTagFactory" var="connection" url="${url}" driverClass="com.mysql.jdbc.Driver" userName="${userName}" password="${password}">
[TEXT]: \r\n    
[NODE]: <sql:execute lineNumber="72" offset="63" length="2" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" home="${template.home}/database" file="create.sql" encoding="UTF-8" out="${pageContext}">
[NODE]: </sql:execute>
[TEXT]: \r\n    
[NODE]: <sql:execute lineNumber="73" offset="66" length="2" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" sql="delete from my_test1;" out="${pageContext}">
[NODE]: </sql:execute>
[TEXT]: \r\n    
[NODE]: <sql:execute lineNumber="74" offset="69" length="2" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" sql="delete from my_test2;" out="${pageContext}">
[NODE]: </sql:execute>
[TEXT]: \r\n    
[NODE]: <sql:execute lineNumber="75" offset="72" length="2" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" sql="insert into my_test2(my_id, my_code, my_name) values (1, '1', '1');">
[NODE]: </sql:execute>
[TEXT]: \r\n\r\n    
[NODE]: <sql:execute lineNumber="77" offset="75" length="23" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" out="${pageContext}">
[TEXT]: \r\n        
[NODE]: <c:forEach lineNumber="78" offset="77" length="9" tagClass="com.skin.ayada.jstl.core.ForEachTag" tagFactory="com.skin.ayada.jstl.factory.ForEachTagFactory" items="1, 2, 3, 4, 5" var="id">
[TEXT]: \r\n            insert into my_test1(my_id, my_code, my_name) values (
[VARI]: ${id}
[TEXT]: , \'
[VARI]: ${id}
[TEXT]: \', \'
[VARI]: ${id}
[TEXT]: \');\r\n        
[NODE]: </c:forEach>
[TEXT]: \r\n        
[NODE]: <c:forEach lineNumber="81" offset="87" length="9" tagClass="com.skin.ayada.jstl.core.ForEachTag" tagFactory="com.skin.ayada.jstl.factory.ForEachTagFactory" items="1, 2, 3, 4, 5" var="id">
[TEXT]: \r\n            insert into my_test2(my_id, my_code, my_name) values (
[VARI]: ${id}
[TEXT]: , \'
[VARI]: ${id}
[TEXT]: \', \'
[VARI]: ${id}
[TEXT]: \');\r\n        
[NODE]: </c:forEach>
[TEXT]: \r\n    
[NODE]: </sql:execute>
[TEXT]: \r\n\r\n    
[NODE]: <sql:execute lineNumber="86" offset="99" length="3" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" out="${pageContext.getOut()}">
[TEXT]: \r\n        delete from my_test2;\r\n        insert into my_test2(my_id, my_code, my_name) values (1001, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1002, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1003, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1004, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1005, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1006, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1007, \'1001\', \'1001\');\r\n        insert into my_test2(my_id, my_code, my_name) values (1008, \'1001\', \'1001\');\r\n    
[NODE]: </sql:execute>
[TEXT]: \r\n\r\n    
[NODE]: <sql:execute lineNumber="98" offset="103" length="2" tagClass="com.skin.ayada.jstl.sql.SqlTag" tagFactory="com.skin.ayada.jstl.factory.SqlTagFactory" connection="${connection}" sql="insert into my_test2(my_id, my_code, my_name) values (1009, '1001', '1001');">
[NODE]: </sql:execute>
[TEXT]: \r\n    <table>\r\n        <tr>\r\n            <td>id</td>\r\n            <td>userName</td>\r\n            <td>nickName</td>\r\n        </tr>\r\n        
[NODE]: <sql:query lineNumber="105" offset="106" length="9" tagClass="com.skin.ayada.jstl.sql.QueryTag" tagFactory="com.skin.ayada.jstl.factory.QueryTagFactory" var="resultSet" sql="select * from my_test2 where my_id > 1001" offset="2" length="3">
[TEXT]: \r\n        <tr>\r\n            <td>
[EXPR]: ${resultSet.getLong(\"my_id\")}
[TEXT]: </td>\r\n            <td>
[EXPR]: ${resultSet.getString(\"my_code\")}
[TEXT]: </td>\r\n            <td>
[EXPR]: ${resultSet.getString(\"my_name\")}
[TEXT]: </td>\r\n        </tr>\r\n        
[NODE]: </sql:query>
[TEXT]: \r\n    </table>\r\n
[NODE]: </sql:connect>
