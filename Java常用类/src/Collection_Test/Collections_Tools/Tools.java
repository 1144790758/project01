package Collection_Test.Collections_Tools;

import org.junit.Test;

import java.util.*;

/**
 *
 * Collections与Collection的区别:
 * Collections是操Collection和Map的工具类
 * Collection是单列存储数据的接口,常用子接口有List和set
 *
 *Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 * 还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 *
 * Collections工具类提供的常用方法:
 * 排序操作：为 （均为static 方法）
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 *
 *查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
 * 给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
 * List 对象的所有旧值
 *
 * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集
 * 合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全
 * 问题
 *
 * @athor:lhl
 * @create:2019-08-31 19:24
 */
public class Tools {
    /**
     * 关于Collections.copy(List dest,List src)方法使用注意事项:
     */
    @Test
    public void test1(){
        List list=new ArrayList();

        list.add(1);
        list.add(22);
        list.add(-1);
        list.add(100);


        //List list2=new ArrayList();
        //if (srcSize > dest.size())
        //            throw new IndexOutOfBoundsException("Source does not fit in dest");
        //将会抛出异常,因为目标descList的元素个数小于srcList元素个数

        //正确的做法为:根据其srcList长度创建一个new Object[list.size()],再把它转为list
        List<Object> list2 = Arrays.asList(new Object[list.size()+2]);

        Collections.copy(list2,list);

        System.out.println(list2);

    }

    @Test
    public void test2(){
        //测试转为线程安全的
        HashSet set =new HashSet();

        //返回的是一个线程安全的Set
        Set synchronizedSet = Collections.synchronizedSet(set);




    }

    public static void main(String[] args) {


//        Map map=new HashMap();

        Map map = Collections.synchronizedMap(new HashMap());

        map.put("q",1);

//        Person2 p1=new Person2(map);
//        Person2 p2=new Person2(map);
//
//        p1.start();
//        p2.start();

        Person p=new Person(map);
        new Thread(p).start();
        new Thread(p).start();

    }
}


class Person implements Runnable{

    int i=100;
    Map map;

    public Person(Map map) {
        this.map = map;
    }

    @Override
    public void run() {

        while (true){
            if((int)map.get("q")>0){
                map.put("q",i--);
                System.out.println(map.values()+"  "+Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else break;
        }
    }
}

class Person2 extends Thread{

    static int i=100;
    Map map;

    public Person2(Map map) {
        this.map = map;
    }

    @Override
    public void run() {

        while (true){
            if((int)map.get("q")>0){
                map.put("q",i);
                System.out.println(map.values()+"  "+Thread.currentThread().getName());
                i=i-1;

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else break;
        }

    }
}