package DateTime_test01;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8.0之前的日期API
 *
 * @athor:lhl
 * @create:2019-08-17 0:06
 * 注意日期周日是1 周一是2 以此类推 周六是7
 * 注意日期月份一月是0 二月是1 以此类推12月是11
 */
public class Calendar_test01 {
    /**
     * Calendar是一个抽象类不能实例化
     */

    //方式一 通过Calendar的静态方法getInstance()方法 获取实例化对象
    //方式二 通过创建其子类GregorianCalendar

    @Test
    public void test01(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); //查看是谁造的对象(class java.util.GregorianCalendar )

        //常用方法

        //get
        //可以获取到一个月的第几天,一年的第几天,一周的第几天~~~~~~
        int day;
        day=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        day=calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(day);

        //set
        //可以设置为多少天
        calendar.set(Calendar.DAY_OF_MONTH,10);//把今天设置为这个月的第10天
        day=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //add
        //往后添加天数
        calendar.add(Calendar.DAY_OF_MONTH,3);//往后再推3天

        //getTime
        //可以返回一个Date()类
        Date date = calendar.getTime();

        //setTime
        Date date1=new Date(1564493513602L);

        calendar.setTime(date1);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        System.out.println(date1);
    }
}
