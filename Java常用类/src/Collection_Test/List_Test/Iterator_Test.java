package Collection_Test.List_Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @athor:lhl
 * @create:2019-08-25 0:20
 */
public class Iterator_Test {

    //iterator()
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add("A");
        coll.add("B");
        coll.add("C");
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //iterator.next() 超出范围会报错
        //指针下移
        Object o = iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        o=iterator.next();
        System.out.println(o);

        //iterator.hasNext() 与iterator.next()搭配使用返回是否还有元素

    }

    @Test
    /**
     * 测试iterator中的remove()
     * iterator中的remove()不同于集合中的remove()
     * 注意:iterator中的remove()中不能连续调用而未调用next()
     */
    public void test2(){
        Collection coll=new ArrayList();
        coll.add("A");
        coll.add("B");
        coll.add("C");
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //删除集合中的"tom"
        while (iterator.hasNext()){
            if(iterator.next().equals("tom")){
                iterator.remove();
            }
        }

        //再次遍历
        Iterator iterator2 = coll.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
