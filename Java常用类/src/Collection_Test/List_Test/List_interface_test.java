package Collection_Test.List_Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection的子接口List方法测试
 * @athor:lhl
 * @create:2019-08-25 0:59
 * Collection:存储单列数据
 *      |---List接口:元素有序,可重复(动态数组)
 *           |---ArrayList:主要实现类,线程不安全,效率高,底层使用Object[]
 *           |---LinkedList:使用双向链表存储:频繁插入,删除操作效率较高
 *           |---Vector:古老实现类,线程安全,效率低,底层使用Object[]
 *
 * ArrayList源码分析: jdk7:
 * 底层先造一个长度为10的Object[] elementData
 * list.add(123)  //elementData[0]=new Integer(123)
 * 扩容是扩为原来的1.5倍,再将内容复制到扩容后的数组
 * 结论:建议使用带参构造器,以此确定容量
 *
 *                   jdk8中的变化:
 * 若使用空参构造器则不会立即造对象,而是在第一次add()操作后实例化对象长度为10
 *
 * ArrayList,LinkedList,Vector的异同
 * 同:都实现了List接口,存储数据特点相同
 * 不同:ArrayList:见上
 *
 *
 *
 * void add(int index, Object ele): 在index 位置插入ele 元素
 * boolean addAll(int index, Collection eles): 从index 位置开始将eles中 中
 * 的所有元素添加进来
 * Object get(int index): 获取指定index 位置的元素
 * int indexOf(Object obj): 返回obj 在集合中首次出现的位置
 * int lastIndexOf(Object obj): 返回obj 在当前集合中末次出现的位置
 * Object remove(int index): 移除指定index 位置的元素，并返回此元素
 * Object set(int index, Object ele): 设置指定index 位置的元素为ele
 * List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex
 * 位置的子集合
 *
 */
public class List_interface_test {

    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);

        System.out.println(list);

        //void add(int index, Object ele): 在index 位置插入ele 元素
        list.add(1,"bb");
        System.out.println(list); //[123, bb, 456, 789]
        //boolean addAll(int index, Collection eles): 从index 位置开始将eles中 中
        //的所有元素添加进来

//        int indexOf(Object obj): 返回obj 在集合中首次出现的位置
//        int lastIndexOf(Object obj): 返回obj 在当前集合中末次出现的位置

        //Object remove(int index): 移除指定index 位置的元素，并返回此元素

        //Object set(int index, Object ele): 设置指定index 位置的元素为ele(修改元素)

        //List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex

    }




}
