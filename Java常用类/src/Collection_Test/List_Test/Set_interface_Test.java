package Collection_Test.List_Test;

import org.junit.Test;

import java.util.*;

/**
 * @athor:lhl
 * @create:2019-08-26 0:04
 *
 *  * Collection:存储单列数据
 *  *     |---Set接口:元素无序,不可重复
 *  *          |---HashSet:主要实现类,线程不安全,可以存储null
 *                  |---LinkedHashSet:HashSet的子类,可以按照添加的顺序遍历
 *                          |---//HashSet的子类在添加数据的同时还维护了两个引用,记录添加顺序
 *                          |---//优点:对于频繁的的遍历操作它的效率比父类HashSet要高
 *             |---TreeSet:二叉树结构(红黑树),可以按照添加的元素指定属性进行排序
 *                   |---注意TreeSet中判断元素是否相同是通过CompareTo()方法来确定的不再是根据equals(),
 *                   |---ComparableTo()返回0则意味两个对象相等,就不能添加,要想实现这只能重写CompareTo()
 *                   不容许放相同的元素
 *
 *  Set接口是Collection的子接口，set接口没有提供额外的方法
 *  Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
 *  Set 判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法
 *
 *
 *  要求一:添加进set中的类要重写HashCode(),和equals()方法
 *  要求二:相等的对象必须具有相等的散列码
 *   在程序运行时，同一个对象多次调用 hashCode() 方法应该返回相同的值。
 *   当两个对象的 equals() 方法比较返回 true 时，这两个对象的 hashCode()方法的返回值也应相等。
 *   对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 */
public class Set_interface_Test {
    /**
     * 以HashSet说明:
     * 元素无序:不等于随机性,存储并不是按照索引顺序添加的,而是根据数据的Hash值
     * 不可重复性:根据对象的equals()方法进行比较,相同的话就只能在集合中存在一个对象
     * 添加元素的过程(HashSet):
     * 调用HashCode(),通过算法找到集合中的某个位置,若是没有其他元素占用则添加成功
     * 若是有元素占用则比较hashCode值,值不相同则以链表的形式与占位元素相连来添加,
     * 值相同则调用equals()若是equal()比较的结果也是相同则元素就是真的相同了,不能添加,
     * equal()调用结果为false就以链表的形式与占位元素相连来添加
     * 索引底层是数组+链表的结构
     *
     */
    //HashSet的使用
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new A("Lee"));
        set.add(new A("Lee"));

//        System.out.println(set);
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        int i=2;
        int b=(i<<5)-i;
        int c=i*31;
        System.out.println(b);
        System.out.println(c);

    }

    //LinkedHashSet的使用
    //HashSet的子类在添加数据的同时还维护了两个引用,记录添加顺序
    //优点:对于频繁的的遍历操作它的效率比父类HashSet要高
    @Test
    public void test3(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new A("Lee"));
        set.add(new A("Lee"));

//        System.out.println(set);
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //TreeSet的使用
    /**
     * 向TreeSet中添加数据,要求是同一个类的对象
     *
     * 注意TreeSet中判断元素是否相同是通过CompareTo()方法来确定的不再是根据equals(),
     * ComparableTo()返回0则意味两个对象相等,就不能添加,要想实现这只能重写CompareTo()
     *
     * 自定义类时用TreeSet时只用重写CompareTo(Object obj)方法[Compare(Object obj1,Object obj1)]
     * @see Comparable
     *  TreeSet若是要用Comparator,则在其构造器中添加其实例化对象
     */
    @Test
    public void test4(){
        TreeSet set=new TreeSet();

        //添加Integer类型
        set.add(123);
        set.add(1);
        set.add(2);
        set.add(5);

        Iterator iterator = set.iterator();
        for (Object o : set) {
            System.out.println(o);
        }//会排序从小到大

        //使用Comparator排序
        //***********1**************
//        TreeSet set2=new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });

        //*************2******************
//        Comparator c=new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        };
//        TreeSet set2=new TreeSet(c);


    }


}

class A{

    String name;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return name != null ? name.equals(a.name) : a.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}