package Enum_Test;

/**
 *
 * 枚举类的使用
 * 类的对象是有限个确定的,称之为枚举类
 * 当需要定义一组常亮是,建议用枚举类
 * @athor:lhl
 * @create:2019-08-20 23:48
 *
 * jdk5.0之前自定义枚举类
 * jdk5.0之后用Enum关键字
 *
 */

//自定义方法:
public class Season_test {

    public static void main(String[] args) {
        Season s1=Season.Summer;
        System.out.println(s1);

    }
}

class Season{
    //1声名属性,用private final 修饰

    private final String SeasonName;
    private final String SeasonDesc;


    //2 私有化构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }

    //3 public static final 修饰
    public static final Season Spring=new Season("Spring","春天");
    public static final Season Summer=new Season("Summer","夏天");
    public static final Season Autumn=new Season("Autumn","秋天");
    public static final Season Winter=new Season("Winter","冬天");

    //4 其他需求比如:toString,get,set 方法

    @Override
    public String toString() {
        return SeasonName+"是"+SeasonDesc;
    }
}
