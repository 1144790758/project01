package Reflection_Test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过类加载器获取流资源
 * @athor:lhl
 * @create:2019-09-20 20:05
 */
public class _2_ClassLoader {

    //测试properties加载配置文件
    //properties都是键值对形式的字符
    @Test
    public void test1() throws IOException {

        //1 new 一个properties对象
        Properties pro=new Properties();

        //方式一:
        //JunitTest默认是当前module路径
//        FileInputStream is=new FileInputStream("2myProperties.properties");

        //方式二:
        //获取系统类加载器(通常加载自定义的类)
        //默认目录实在当前类的同包名下
        ClassLoader loader = _2_ClassLoader.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("2myProperties.properties");

        //2加载文件
        pro.load(is);

        //读取配置信息
        String name = pro.getProperty("name");
        String password = pro.getProperty("password");

        System.out.println("name:  " + name + "\npassword:  " + password);


    }
}
