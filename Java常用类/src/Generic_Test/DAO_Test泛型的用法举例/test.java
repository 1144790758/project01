package Generic_Test.DAO_Test泛型的用法举例;

import org.junit.Test;

/**
 * @athor:lhl
 * @create:2019-09-09 18:45
 */
public class test {
    @Test
    public void test1(){
        //由于StudentDAO指明了泛型为Student所以继承了DAO的StudentDAO变为专门操作Student类型的DAO

        StudentDAO studentDAO=new StudentDAO();

        studentDAO.add(new Student());

    }
}
