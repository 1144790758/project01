package DateTime_test01;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @athor:lhl
 * @create:2019-07-30 21:16
 */
public class DateTime_01 {

    //1 System 类中的currentTimeMillis()
    @Test
    public void test01(){
        long timeMillis = System.currentTimeMillis(); //返回毫秒数,1970-1-1
        System.out.println(timeMillis);
    }

    //2 java.util.Date类
//        java.sql.Date类
    /*
    1两个构造器的使用
    2两个方法的使用
     */
    @Test
    public void test02(){

        //构造器1,创建一个当前日期的对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());//毫秒数

        //构造器2,创建指定毫秒数的日期
        Date date2=new Date(1564493513602L);
        System.out.println(date2.toString());

        //java.sql.Date 对应数据库中的日期变量
        //构造器 只有一个,在里面放入毫秒数
        java.sql.Date date3=new java.sql.Date(System.currentTimeMillis());
        System.out.println(date3.toString());

        System.out.println(System.currentTimeMillis());//返回毫秒数

    }

    @Test
    public void exercise02() throws ParseException {
        /**
         * "三天打鱼两天晒网"
         * 从" 1990-08-09 "起 "三天打鱼两天晒网" 到" 2020-07-06 " 日
         * 应该是打鱼还是晒网 ?
         */

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        //利用毫秒数相减除以每一天的毫秒数,算出有多少天
        Date date1 = sdf.parse("1990-08-09");
        Date date2 = sdf.parse("2020-07-12");

        Long day=( date2.getTime()-date1.getTime() ) / ( 1000 *60 *60 * 24 ) +1;

        //5天为一个周期
        //取余数为1 2 3 为打鱼
        //0 4 为晒网
        if(day%5==1 || day%5==2 || day%5==3){
            System.out.println("打鱼");
        }
        else System.out.println("晒网");


    }
}
