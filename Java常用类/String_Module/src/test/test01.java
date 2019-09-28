package test;

import org.junit.Test;

/**
 * 测试继承与接口
 * 若某个方法需要接口类型的参数,可以用实现接口的类
 * 及时该类的子类
 * @athor:lhl
 * @create:2019-07-27 12:09
 */
public class test01 {
    static void w2(i i){

    }
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        w2(b);
        w2(a);
    }
    @Test
    public void test01(){
        //测试强转,向上转,向下转


        //1不报错(向上转后又向下转,下转后属性方法不丢失)
        D d=new D("lhl");
        C d1 =(C) d;

        D d11 = (D) d1;
        System.out.println(d11.age);
        System.out.println(d11.name);

        //2报错
//        C c = new C();
//        D c1 = (D) c;

    }

    @Test
    public void test02(){
        String str1="a";
        String str2=str1;

        System.out.println(str1.toUpperCase());
        System.out.println(str2);


    }
}

interface i{
    void w();
}

class A implements i{


    @Override
    public void w() {

    }
}

class B extends A{

}

class C{
    int age=10;
    String name="lee";
}

class D extends C{
    
    String name="lee";

    public D(String name) {
        this.name = name;
    }
}