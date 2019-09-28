package Annotation_Test;

/**
 *  jdk5.0新增功能
 *  理解注解: 是代码中的特殊标记,在编译时被读取可以做相应的处理,
 * 在不改变原有逻辑上可以做一些信息的补充
 *
 * 可以标记过时,忽略编译器警告等,用法比较简单,在javaEE与Android开发中常用
 *
 * @athor:lhl
 * @create:2019-08-21 22:38
 *
 * 示例:
 * 1. 生成文档的相关注解
 * 2. 编译时进行格式检查(jdk内置的三个基本注解)
 *    @Override:重写方法
 *    @Dprecated:标记过时(其结构危险等)
 *    @SuppressWarnings(抑制编译器警告)
 * 3. 跟踪代码依赖性,实现代替配置文件功能
 *
 * 注解声名为@interface
 * 内部定义成员通常用value表示,有点像方法
 * 可以指定默认的成员变量用default
 * 如果注解没有成员变量则只是一个表示作用(Override等)
 * 如果注解有成员变量则要指定value的值  @MyAnnotation(value = "haha")
 *
 * 自定义注解必须配上信息处理流程(反射)才有意义
 *
 * 4. jdk5.0提供了4个元注解(用来修饰其他Annotation定义的注解)
 * 分别是Retention,Target,Documented,Inherited
 * Retention:修饰Annotation生命周期(value必须包含RetentionPolicy的某个成员变量[枚举对象])
 *           其中只有RetentionPolicy.RUNTIME 才能被反射所调取到
 * Target:修饰Annotation能被修饰在那些地方(类接口,方法,属性,构造器等)
 *
 * 出现率低:Documented,Inherited
 * Documented:使被修饰的Annotation将被javadoc提取为文档
 *            定义为Documented的注解必须Retention的value为RetentionPolicy.RUNTIME
 *Inherited:被其修饰的Annotation将具有继承性,某一个类的注解被@Inherited所修饰,他的子类也将被父类的注解修饰
 *
 * 5. jdk8.0之后可重复注解被@Repeatable修饰
 *
 * 6. 类型注解 :可以使用注解能够修饰其他参数比如泛型等
 *
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Animal a=new Animal();



    }

}

//示例自定义注解
@MyAnnotation(value = "haha")
@SuppressWarnings("unused")
class Animal{
    String name;

    void eat(){
        System.out.println("动物吃东西");

    }

    void walk(){
        System.out.println("动物走路");
    }

}