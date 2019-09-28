package _0_Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @athor:lhl
 * @create:2019-09-24 19:51
 */
public class test3 {

    @Test
    public void test1(){
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");

//        ArrayList<String> list1=method(list,(String s)->{return s.contains("京") ;});
        ArrayList<String> list1=method(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);
    }



     ArrayList<String> method(List<String> list, Predicate<String> pre) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> list1= strings;

        for (String s : list) {
            if(pre.test(s)){
                list1.add(s);
            }
        }
        return list1;
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        ArrayList<String> list1=method(list,(s -> s.contains("京")));
        System.out.println(list1);
    }
}
