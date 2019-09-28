package _0_Test;

import java.util.Comparator;

/**
 * @athor:lhl
 * @create:2019-09-24 15:28
 */
public class test01 {

    public static void main(String[] args) {
        //测试lambda表达式

        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare(12, 16));


        System.out.println("**************");

        Comparator<Integer> com2= Integer::compareTo;

        System.out.println(com2.compare(99, 65));
    }

}
