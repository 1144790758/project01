package _0_Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @athor:lhl
 * @create:2019-09-24 19:31
 *
 * Predicate
 */
public class test02 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");

        ArrayList<String> list1=method(list);
        System.out.println(list1);

    }

    public static  ArrayList<String> method(List<String> list){
        ArrayList<String> list1 =new ArrayList<>();

        for (String t : list) {
            if(t.contains("京")){
                list1.add(t);
            }
        }
        return list1;
    }

}
