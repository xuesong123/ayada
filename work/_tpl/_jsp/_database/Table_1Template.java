/*
 * $RCSfile: Table_1Template.java,v $$
 * $Revision: 1.1 $
 * $Date: 2016-01-14 $
 *
 * Copyright (C) 2008 Skin, Inc. All rights reserved.
 *
 * This software is the proprietary information of Skin, Inc.
 * Use is subject to license terms.
 *
 * home: E:/WorkSpace/ayada/webapp
 * path: /database/table_1.sql
 * lastModified: 2014-03-25 18:01:22 000
 * options: -fastJstl true
 * JSP generated by JspCompiler-1.0.1.2 (built 2016-01-14 23:17:00 529)
 */
package _tpl._jsp._database;

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
 * <p>Title: Table_1Template</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author JspCompiler
 * @version 1.0
 */
@SuppressWarnings("unused")
public class Table_1Template extends JspTemplate {
    public static void main(String[] args){
        java.io.StringWriter writer = new java.io.StringWriter();
        PageContext pageContext = com.skin.ayada.runtime.JspFactory.getPageContext(writer);
        Table_1Template template = new Table_1Template();

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
        // out.write("drop table if exists my_test1;\r\n\r\ncreate table my_test1(\r\n    my_id      int(11)                  not null,\r\n    my_code    varchar(8)               not null,\r\n    my_name    varchar(32)              not null,\r\n    primary key (my_id)\r\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n\r\ninsert into my_test1(my_id, my_code, my_name) values (1, \'1111\', \'1111\');\r\ninsert into my_test1(my_id, my_code, my_name) values (2, \'1111\', \'1111\');\r\ninsert into my_test1(my_id, my_code, my_name) values (3, \'1111\', \'1111\');\r\ndelete from my_test1;");
        out.write(_jsp_string_1, 0, _jsp_string_1.length);

        out.flush();
        jspWriter.flush();
    }

    public static final char[] _jsp_string_1 = "drop table if exists my_test1;\r\n\r\ncreate table my_test1(\r\n    my_id      int(11)                  not null,\r\n    my_code    varchar(8)               not null,\r\n    my_name    varchar(32)              not null,\r\n    primary key (my_id)\r\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n\r\ninsert into my_test1(my_id, my_code, my_name) values (1, \'1111\', \'1111\');\r\ninsert into my_test1(my_id, my_code, my_name) values (2, \'1111\', \'1111\');\r\ninsert into my_test1(my_id, my_code, my_name) values (3, \'1111\', \'1111\');\r\ndelete from my_test1;".toCharArray();

}
