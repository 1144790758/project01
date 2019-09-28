package DeBug_Test;

/**
 * @athor:lhl
 * @create:2019-09-15 15:10
 *
 * 1要在某个众多接口的实现类中快速定位重写的方法,可以直接在接口中的方法上打断点
 * 2 View BreakPoint 进行添加设置后,可以在异常触发前一步中可以添加异常处捕获某种异常
 * 3 字段断点,在某个变量上打断点:所有与其的写操作流程都会停顿,用右键设置后读取(调用)该字段也可以停顿显示
 * 4 为断点设置条件表达式,让满足表达式后在此处停下来
 * 5 找到bug后若是不想让程序执行后面的内容,光是点击停止按钮是不行的,在frame中force return 然后再resume结束
 */
public class Test_1 {

    public static void main(String[] args) {
        Server s=new Server(10);
        s.excute();

//        Object o=null;
//        o.toString();
    }
}

class Server implements jiekou{

    int age;

    public Server(int age) {
        this.age = age;
    }

    @Override
    public void excute() {
        System.out.println("*********1**********");
        System.out.println("执行接口中的方法");
    }

    public void say(){
        System.out.println(age);

    }
}


