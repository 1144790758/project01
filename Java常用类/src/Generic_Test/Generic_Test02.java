package Generic_Test;

/**
 * 子类继承父类的泛型
 * @athor:lhl
 * @create:2019-09-09 12:21
 *
 * 子类继承了带泛型的父类时,指明了泛型类型,则实例化子类对象时不需要指明泛型
 * 其实已近不是泛型类了,可以说是继承了一个指明了泛型的类
 */
public class Generic_Test02 {

    public static void main(String[] args) {

        Son son=new Son("123");
        son.MyName();

    }
}

class Father <E>{
    E name;


    public Father(E name) {
        this.name = name;
//        E[] arr = (E[]) (new Object[10]);
    }

    public void MyName(){
        System.out.println(name);
    }
}

class Son extends Father<String>{

    public Son(String name) {
        super(name);
    }
}