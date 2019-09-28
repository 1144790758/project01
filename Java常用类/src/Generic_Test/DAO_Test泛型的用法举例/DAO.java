package Generic_Test.DAO_Test泛型的用法举例;

/**
 * @athor:lhl
 * @create:2019-09-09 18:40
 */
public class DAO <T>{

    //增
    void add (T obj){

    };

    //删
    boolean del(T obj){
        return false;
    };

    //改
    boolean modify(T obj){
        return false;
    }

    //查
    T select(T obj){

        return null;
    }

}
