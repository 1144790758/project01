package Reflection_Test;

import org.junit.Test;

/**
 * 子类继承父类,若是子类自己没有任何构造器则,子类默认继承父类空参构造器
 * public:没有限制,外包非子类也可以访问
 * protected:限制包外的而且不是子类的访问,它的子类可以访问
 * 默认:只有本包才能访问,子类也不行
 * private:只有自己才能访问
 *
 * @athor:lhl
 * @create:2019-09-20 20:27
 */
public class _3_newInstance {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        //IllegalAccessException 权限访问异常
        //InstantiationException 没有空参构造器
        //1用此方法创建的对象是调用了空参构造器创建的
        //2空参构造器的访问权限得够

        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        Person p=new Person();

    }
}
