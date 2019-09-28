package Generic_Test;

/**
 * 子类继承了父类未指明的泛型
 *
 * 继承父类静态方法是子类重写也必须为静态的
 * 父类方法的权限修饰符必须小于子类权限修饰符
 * @athor:lhl
 * @create:2019-09-09 13:50
 */
public class Generic_Test03 {
    public static void main(String[] args) {

        Son2<String,Integer> s2=new Son2<>("xiaohong");
        s2.MyName();

    }
}


class Father2 <E>{
    E name;


    public Father2(E name) {
        this.name = name;
    }

    public  void MyName(){
        System.out.println(name);
    }
}

class Son2<T,E> extends Father2<T>{

    public Son2(T name) {
        super(name);
    }
}

