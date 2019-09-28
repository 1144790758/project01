package jdk8DateTimeTest;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @athor:lhl
 * @create:2019-08-17 22:46
 *
 * LocalDate
 * LocalTime
 * LocalDateTime的使用
 * LocalDateTime 使用比较普遍
 */
public class test01 {

    @Test
    public void test1(){
        //1实例化两种方式

        //默认当前的时间now()
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate); //2019-08-17
        System.out.println(localTime); //23:11:24.418
        System.out.println(localDateTime); //2019-08-17T23:11:24.418

        //自定义时间of()
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 7, 8, 13, 24);
        System.out.println(localDateTime1); //2020-07-08T13:24

        //2 获取getXxx() 以LocalDateTime为例
        int dayOfMonth = localDateTime1.getDayOfMonth();
        System.out.println(dayOfMonth);
        System.out.println(localDateTime1.getDayOfYear());

        //3设置时间with(),并且体现不可变性
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(12); //这个月的第12号并返回新的时间
        System.out.println(localDateTime2);

        //4 时间的添加plus(),并且体现不可变性
        LocalDateTime localDateTime3 = localDateTime1.plusHours(10); //往后添加了10个小时
        System.out.println(localDateTime3);

        //5 时间的减minus(),并且体现不可变性
        LocalDateTime localDateTime4 = localDateTime1.minusDays(2);//往后减了2天
        System.out.println(localDateTime4);


    }

}
