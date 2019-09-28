package Generic_Test;

import org.junit.Test;

import java.util.*;

/**
 * 在集合中使用泛型
 * @athor:lhl
 * @create:2019-09-01 14:36
 *
 * 注意: 异常类与静态方法不能使用类的泛型
 *
 * 在创建数组之类的结构时使用泛型  :  T[] arr= (T[])new Object[10];
 *
 * 泛型方法: 在返回值之前面加<T> ,注意T不是类的泛型static也可以这样用
 *
 * 泛型在继承方面的特性: A 是 B的父类 但是 G<A> 与 G<B> 不存在任何关系,是两个对立并列的类,他们的父类是 G<?>,<?>是通配符
 * 注意以通配符 G<?> 的形式不能修改数据或者增加,唯一例外是null应为null是所以类型的成员,只能读取数据并且返回最高级父类 Object
 *
 *                     A 是 B的父类 A<G> 与 B<G> 存在继承关系
 * 有限制条件的通配符使用:
 * A是B的父类
 *  List<? extends A> list; //还可以向里面添加数据
 *  List<? super A> list;  //还可以向里面添加数据
 *  ? extends A: 限制 ? 为小于或等于 A  list=new ArrayList<Object>(); ×
 *  ? super A: 限制 ? 为大于或等于 A list=new ArrayList<B>(); ×
 *
 */
public class Generic01 {


    //使用泛型来创建集合
    @Test
    public void test1(){
        float sum=0f;
        int count=0;

        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(98);
        list.add(75);
        list.add(143);

        for (Integer integer : list) {
            //避免了强转操作
            sum+=integer;
            count++;
            System.out.println("当前总成绩 : "+sum);
        }

        float avg=sum/count;
        System.out.println("平均成绩 : "+avg);

    }

    @Test
    public void test2(){
        Map<String,Integer> map =new HashMap<>();

        map.put("tom",110);
        map.put("jack",29);
        map.put("jerry",65);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator =entries.iterator();

        while (iterator.hasNext()){

            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }



    }

    //测试继承关系
    @Test
    public void test3(){
        List<Object> list1=new ArrayList<>();
        List<String> list2=null;
        //编译报错
//        list2=list1;
        show(list2);

    }
    public void show(List list){

    }
    //测试继承关系
    @Test
    public void test4(){
        List<String> list1=null;
        ArrayList<String> list2=new ArrayList<>();
        list1=list2;

    }

    @Test
    public void test5(){
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(123);
        show2(list1);

    }

    public <T> void show2(List<T> list){
        System.out.println(list);
    }
}
