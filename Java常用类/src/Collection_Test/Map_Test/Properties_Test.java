package Collection_Test.Map_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @athor:lhl
 * @create:2019-08-31 18:41
 */
public class Properties_Test {
    //Properties 的key和value都是字符串
    public static void main(String[] args)  {
        //properties的简单使用
        //常用于加载配置文件
        //读取myProperties中的信息

        Properties properties = new Properties();
        //获取当前工作目录(获取系统配置信息)
        System.out.println(System.getProperty("user.dir"));

        //若是出现了异常用throws抛出异常则流关闭不掉
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("2myProperties.properties");

            //加载流对应的文件内容
            properties.load(fis);


            //获取内容 getProperty(String Key)
            System.out.println("name"+"==="+properties.getProperty("name"));
            System.out.println("password"+"==="+properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //finally作为异常处理的一部分，它只能用在try/catch语句中，
            // 并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），
            // 经常被用在需要释放资源的情况下。
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
