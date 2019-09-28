package Collection_Test.Map_Test;

import org.junit.Test;

import java.util.*;

/**
 * @athor:lhl
 * @create:2019-08-27 2:05
 *  Map实现类结构:
 *  |--- Map:双列数据,存储Key-Value键值对
 *        |---HashMap:Map的主要实现类,可以存储null的值或者键,线程不安全的,效率高
 *              |---LinkedHashMap:可以保证遍历时可以按照添加顺序遍历(添加了指向前一个与后一个指针),对于频繁的遍历操作用它效率高
 *        |---TreeMap:实现key-value遍历时排序,底层使用红黑树
 *        |---Hashtable:古老的实现类,线程安全的,效率低,不能存储null
 *               |---Properties:常用于处理配置文件(key和value都是String)
 *
 *   HashMap底层(数组+链表)  jdk7及之前
 *              (数组+链表+红黑树)  jdk8
 *
 *
 *   Map结构:
 *   key:无序的,不可重复,使用set存储所有的key   所有key所在的类要重写hashCode方法和equals(以hashMap为例,
 *   若是TreeMap就重写比较大小的方法等)
 *
 *   value:无序的,可重复的,可以使用Collection存储,所在类重写equals
 *   key-value:一对键值对构成一个entry对象
 *   Map中的entry:无序,不可重复,使用set存储所有的entry
 *
 *  重点1 HashMap底层实现原理 ?
 *     2 HashMap与Hashtable异同 ?
 *     3 CurrentHashMap与Hashtable的异同 ?
 *
 *
 *  1. HashMap底层实现原理 jdk7:
 *   HashMap map=new HashMap();创建一个长度为16的 Entry[] table
 *   .......
 *   map.put(key1,value1)
 *  先把key1的hash值算出来通过算法计算出entry应该在数组中存放的位置
 *  情况一:若是在该位置没有数据,则将entry(key1,value1)添加进去,添加成功
 *  情况二:若是在该位置上已经存在数据或者多个数据,则用equals进行比较数据是否相同
 *        不同则在数据链表的末尾添加entry(key1,value1)
 *  情况三:相同则替换原来数据的value值
 *
 *  HashMap扩容扩为原来的两倍,并将原来的数据复制过来
 *  jdk7什么时候扩容:当长度超过临界值,并且要放的位置不为空
 *
 *  jdk8:HashMap map=new HashMap();
 *  1没有立即创建长度为16
 *  2jdk8底层数组是Node[],而不是Entry[]
 *  3首次调用put是才创建Node[]
 *  4jdk7底层只有数组+链表   jdk8:数组+链表+红黑树
 *  若是某一个索引位置上数据链表长度超过8且当前数组长度超过64,此时位置上的索引数据改为使用红黑树存储
 *
 *
 *
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 * MAXIMUM_CAPACITY ： ： HashMap的最大支持容量，2^30
 * DEFAULT_LOAD_FACTOR ：HashMap的默认加载因子
 * TREEIFY_THRESHOLD ：Bucket中链表长度大于该默认值8，转化为红黑树
 * UNTREEIFY_THRESHOLD ：Bucket中红黑树存储的Node小于该默认值，转化为链表
 * MIN_TREEIFY_CAPACITY ：桶中的Node被树化时最小的hash表容量64。若数组长度小于64则会选择扩容的方式存储
 * table ：存储元素的数组，总是2的n次幂
 * entrySet： ：存储具体元素的集
 * size ：HashMap中存储的键值对的数量
 * modCount ：HashMap扩容和结构改变的次数。
 * threshold ：扩容的临界值，=容量*填充因子
 * loadFactor： ：填充因子
 *
 *
 *
 * Map中声明的一些方法:
 * Boolean containsKey(Object Key) 判断是个包含某个Key
 * Boolean containsValue(Object Value) 判断是否包含某个Value
 */
public class Map_Test_01 {

    @Test
    public void test1(){
        Map map=new HashMap();
        map.put("lee",1);
        map.put("cheen",1);
        map.put("dou",1);

        System.out.println(map);
    }

    /**
     *
     * 测试HashMap的子类LinkedHashMap
     * 重写了HashMap中的NewNode方法
     * 其Node结构如下:
     *static class Entry<K,V> extends HashMap.Node<K,V> {
     *         Entry<K,V> before, after;
     *         Entry(int hash, K key, V value, Node<K,V> next) {
     *             super(hash, key, value, next);
     *         }
     *     }
     */
    @Test
    public void test2() {
        Map map = new LinkedHashMap();
        map.put("lee", 1);
        map.put("cheen", 1);
        map.put("dou", 1);

        System.out.println(map);


    }

    /**
     * 如何遍历map呢？思路：
     * key由Set存储
     * value由Collection存储
     * key-value由entry存储
     */

    @Test
    public void test3(){
        Map map = new LinkedHashMap();
        map.put("lee", 1);
        map.put("cheen", 2);
        map.put("dou", 3);
        
        //得到keySet
        Set set = map.keySet();
//        Iterator iterator = set.iterator();

        for (Object o : set) {
            System.out.println(o);
        }

        Collection collection = map.values();
        for (Object o : collection) {
            System.out.println(o);
        }


        //方式一
        //得到entrySet()  ----getKey()  getValue()
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        for (Object o : entrySet) {
            //强转o
            Map.Entry entry = (Map.Entry) o;
            System.out.println("********");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }

        //方式二
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            System.out.println(next + "  " + map.get(next));
        }


    }
}