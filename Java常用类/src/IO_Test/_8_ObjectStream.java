package IO_Test;

import org.junit.Test;

import java.io.*;

/**
 *
 *  ObjectInputStream 和 ObjectOutputSteam
 *  用于存储和读取 基本数据类型数据或 对象的处理流。它的强大之处就是可
 * 以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *   序列化：用ObjectOutputStream类 保存基本类型数据或对象的机制
 *   反序列化：用ObjectInputStream类 读取基本类型数据或对象的机制
 *  ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 *
 * 自定义对象必须实现:
 * 1. Serializable接口才能序列化
 * 2. 序列化版本号(全局常亮,值没有要求),
 *      如果没有这个UID,则在原来的类改变后反序列化无法找到原来的类
 * 3. 除了类本身实现Serializable,其内部成员也必须实现Serializable
 *
 * 补充  :
 *      transient 和 static 修饰的成员不能被序列化
 *      transient:可以使你不想被序列化的内容不被序列化
 *      static:是类共享的变量,不能被序列化
 *
 * @athor:lhl
 * @create:2019-09-17 19:56
 */
public class _8_ObjectStream {

    //序列化
    @Test
    public void test1(){
        ObjectOutputStream oos= null;
        try {
            //创建流
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //写入对象
            oos.writeObject(new Person());
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                //关闭资源
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //反序列化
    @Test
    public void test2(){
        ObjectInputStream ois= null;
        try {
            //创建流
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            //读取对象
            Object person = ois.readObject();

            Person p= (Person) person;
            p.method();
            p.method2();
            System.out.println(p.weight);  //0
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){
                //关闭
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class Person implements Serializable{

    static public final long serialVersionUID = 1234112312442L;

    static final String name="lee";

    static int aget=10;

    transient int weight=50;

    public void method(){
        System.out.println(name);
    }

    public void method2(){
        System.out.println(aget);
    }


}
