package Collection_Test.List_Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @athor:lhl
 * @create:2019-08-23 23:07
 *
 * java集合分两大接口 : Collection,Map
 * @see Collection:存储单列数据
 *     |---List接口:元素有序,可重复(动态数组)
 *           |---ArrayList       LinkedList       Vector
 *     |---Set接口:元素无序,不可重复
 *          |---HashSet          LinkedHashSet    TreeSet
 * Map:存储双列数据,保存具有映射关系的集合"key"-"value"
 *  |---HashMap       LinkedHashMap        TreeMap          HashTable       Properties
 */
public class Java_Collection {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        Collection coll=new ArrayList();

        //add(Object e) 添加元素
        coll.add("A");
        coll.add("B");
        coll.add("C");

        //size() 获取添加的元素个数
        System.out.println(coll.size());

        //addAll(Collection coll) 将coll中的所有元素添加到集合中
        coll.addAll(coll);
        System.out.println(coll);

        //clear 清空集合的元素
        coll.clear();

        //isEmpty 判断集合是否为空,是否有元素
        System.out.println(coll.isEmpty());

    }

    @Test
    public void test2(){
        //集合可以与数组相互转化
        Collection coll=new ArrayList();
        coll.add("a");
        coll.add("b");
        System.out.println(coll);

        //toArray()
        Object[] array = coll.toArray();
        System.out.println(Arrays.toString(array));

//        @SuppressWarnings("unused")
        //Arrays.asList()
        //注意在asList(param)中param为可变形参时,作为数组其类型必须为包装类
        //不然param就会被视为一个整体当做参数传入,而不会取到其中的元素
        List<Object> list = Arrays.asList(array);
        List<Object> list2 = Arrays.asList(new int[]{1,2,3});
        System.out.println(list);
        System.out.println(list2); //[[I@3d82c5f3]

    }


    @Test
    /**
     * 注意 我们涉及自定义类的时候或者有特殊比较的要求时
     * (删除等操作都会调用equal方法)
     * 要重写其父类Object的equal()方法,
     * 因为Object的equal()实际上比较的是地址也就是"=="
     */
    public void test3(){

        Collection coll=new ArrayList();
        coll.add("a");
        coll.add("b");

        //contains(Object obj) 判断集合中是否包含obj,containsAll(collection c)
        //判断就会涉及到其中的equal()方法

        //remove(),removeAll(collection c) coll移除c中包含的元素,并返回boolean值

        //retainAll(collection c) coll 取与c的交集部分,coll中元素变为交集部分

        //equal(Object obj)比较集合中的元素是否相同是否相同,都不是集合肯定不相同,具体看源码
        Collection coll2=new ArrayList();
        coll2.add("a");
        coll2.add("b");

        boolean equals = coll.equals(coll2);
        System.out.println(equals); //true

    }

    @Test
    public void test4(){
        //iterator()
        //返回Iterator接口的实例,用于遍历集合元素
        //测试在Iterator_Test中

    }
}
