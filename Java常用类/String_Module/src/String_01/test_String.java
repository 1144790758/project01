package String_01;


import org.junit.Test;

/**
 *
 * String s=new String("abc") 中创建了几个对象?
 * 创建了两个:一个是堆空间中的new结构,一个是常量池中的char[] "abc"
 *
 * 通过String自带的intern()方法,
 * 使其返回常量池中的地址,如果常量池中字符串存在,
 * 则返回地址,不存在则返回新的地址
 *
 * 难题小测试 fun3()
 *
 * @athor:lhl
 * @create:2019-07-27 20:40
 */
public class test_String {

    //String的实例化方式有两种
    //1 通过直接复制字符串,声名在方法区中的常量池中

    //2 通过new创建的对象,在堆空间中开辟空间
    @Test
    public void fun1(){
        String s1="abc";
        String s2="abc";
        String s3=new String("abc");
        String s4=new String("abc");

        System.out.println(s1 == s2); //true 常量池中
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false

        System.out.println("****************");

        A a=new A("Tom");
        B b=new B("Tom");

        System.out.println(a.name == b.name); //true
    }

    @Test
    public void fun2(){
        String s1="java";
        String s2="hadoop";
        String s3="java"+"hadoop";
        String s4=s1+"hadoop";
        String s5=s1+s2;
        String s6="javahadoop";
        String s7=s5.intern();

        System.out.println(s3 == s6);//true
        System.out.println(s4 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s7 == s6);//true
    }

    @Test
    public void fun3(){
        StringTest t=new StringTest();
        t.change(t.str,t.ch);
        System.out.println(t.str);
        System.out.println(t.ch);
    }


}

class A{

    String name;

    public A(String name) {
        this.name = name;
    }
}

class B{

    String name;

    public B(String name) {
        this.name = name;
    }
}

class StringTest{

//    String str=new String("good");
    String str="good";
    char[] ch={'t','e','s','t'};

    void change(String str,char ch[]){
//        this.str="test ok";

        str="test ok";//str拿到的是一个字符串地址,字符串不可变性,无法修改(这是很特殊的)
        //记住基本类型传递值,引用类型传递地址,具体问题具体分析

        ch[0]='b';
    }

}