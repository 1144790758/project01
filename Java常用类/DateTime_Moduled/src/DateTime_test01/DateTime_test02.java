package DateTime_test01;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @athor:lhl
 * @create:2019-08-16 22:14
 *
 *       SimpleDateFormat的使用:对Date类的格式化和解析
 *
 *      格式化: 日期 -->字符串
 *      解析: 字符串 -->日期
 *
 *      由于其方法为非静态的所以首先要实例化
 *
 */
public class DateTime_test02 {

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化
        SimpleDateFormat sdf = new SimpleDateFormat();//默认构造器

        //格式化
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析
        //使用自定义格式的构造器
        //y为年 M为月 d为天 s为秒 h为小时
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd-hh-ss");
        Date date1 = sdf2.parse("2021-12-25-13-09");
        System.out.println(date1);

        //格式化
        String format1 = sdf2.format(date1);
        System.out.println(format1);

    }


    @Test
    public void exercise01() throws ParseException {
        /**
         * 将2020-09-08 转为java.sql.Date
         *
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-09-08");

        System.out.println(date);//转为Date()

        java.sql.Date date1=new java.sql.Date(date.getTime());

        System.out.println(date1);

    }

}
