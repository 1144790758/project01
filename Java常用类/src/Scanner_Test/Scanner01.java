package Scanner_Test;

import java.util.Scanner;


/**
 * @athor:lhl
 * @create:2019-09-01 12:59
 */
public class Scanner01 {
    public static void main(String[] args) {
        /**
         *    nextLine()：
         *      1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
         *      2、可以获得空白。
         *
         * 当执行到hasNext（）时，
         * 它会先扫描缓冲区中是否有字符，
         * 有则返回true,继续扫描。直到扫描为空，
         * 这时并不返回false,而是将方法阻塞，等
         * 待你输入内容然后继续扫描。
         * 这样的话，它岂不是吃了炫迈口香糖根本停不下来。
         * next() 不能得到带有空格的字符串。
         *
         */



//        Scanner s=new Scanner(System.in);
//
//        while (s.hasNext()){
//
//            String next = s.next();
//            System.out.println("输入的数据为:"+next);
//        }
//        System.out.println("啦啦啦");
//        s.close();






        //解决方法一:使用带有参数的重载方法，当扫描到的字符与参数值匹配时返回true
        Scanner s=new Scanner(System.in);
        System.out.println("输入数据");
        //  !s.hasNext("abc")  取到"abc"返回false
        while (!s.hasNext("abc")){

            String next = s.next();
            System.out.println("输入的数据为:"+next);
        }
        System.out.println("啦啦啦");
        s.close();
    }


}
