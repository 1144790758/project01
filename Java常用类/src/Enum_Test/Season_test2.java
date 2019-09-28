package Enum_Test;

/**
 *
 * 使用enum关键字定义枚举类
 * 定义的枚举类默认继承于class java.lang.Enum
 * @athor:lhl
 * @create:2019-08-21 0:56
 *
 *
 *  * 常用方法
 *  * values(),valueOf()都是在继承了java.lang.Enum之后才有的
 *  * values()返回 常亮的数组
 *  valueOf(objName) 返回对应参数的对象,没有那个对象则会抛出异常
 *
 *  关于其实现接口的特殊情况
 */
public class Season_test2 {

    public static void main(String[] args) {
        Season2 winter = Season2.Winter;
        System.out.println(winter);

        System.out.println(winter.getClass().getSuperclass());

        //values()
        Season2[] values = Season2.values();
        for (Season2 value : values) {
            System.out.println(value);
        }

        //valueOf()
        Season2 winter1 = Season2.valueOf("Winter");
        System.out.println(winter1);

        //通常实现接口的情况
        Season3.Winter.show(); //现在是春季

        //根据常量不同实现方法不同
        Season4.Winter.show(); //现在是冬季

    }


}

enum Season2{

    //1 首先把常亮对象放在前面,对象之间用逗号间隔,最后用分号结束,删除相同的部分
    Spring("Spring","春天"),
    Summer("Summer","夏天"),
    Autumn("Autumn","秋天"),
    Winter("Winter","冬天");

    //声名属性,用private final 修饰
    private final String SeasonName;
    private final String SeasonDesc;

    //私有化构造器,并给对象属性赋值
    private Season2(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }



    //其他需求比如:toString,get,set 方法
    @Override
    public String toString() {
        return SeasonName+"是"+SeasonDesc;
    }
}

interface info{
    void show();

}

enum Season3 implements info{

    //1 首先把常亮对象放在前面,对象之间用逗号间隔,最后用分号结束,删除相同的部分
    Spring("Spring","春天"),
    Summer("Summer","夏天"),
    Autumn("Autumn","秋天"),
    Winter("Winter","冬天");

    //声名属性,用private final 修饰
    private final String SeasonName;
    private final String SeasonDesc;

    //私有化构造器,并给对象属性赋值
    private Season3(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }



    //其他需求比如:toString,get,set 方法
    @Override
    public String toString() {
        return SeasonName+"是"+SeasonDesc;
    }

    @Override
    public void show() {
        System.out.println("现在是春季");
    }
}

enum Season4 implements info{

    //1 首先把常亮对象放在前面,对象之间用逗号间隔,最后用分号结束,删除相同的部分
    Spring("Spring","春天"){
        @Override
        public void show(){
            System.out.println("现在是春季");
        }
    },
    Summer("Summer","夏天"){
        @Override
        public void show(){
            System.out.println("现在是夏季");
        }

    },
    Autumn("Autumn","秋天"){
        @Override
        public void show(){
            System.out.println("现在是秋季");
        }

    },
    Winter("Winter","冬天"){
        @Override
        public void show(){
            System.out.println("现在是冬季");
        }

    };

    //声名属性,用private final 修饰
    private final String SeasonName;
    private final String SeasonDesc;

    //私有化构造器,并给对象属性赋值
    private Season4(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }



    //其他需求比如:toString,get,set 方法
    @Override
    public String toString() {
        return SeasonName+"是"+SeasonDesc;
    }

}
