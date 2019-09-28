package IO_Test.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 异或运算:二进制数相同为0,不同为1
 * 连续与同一个数进行两次异或还是原来的值
 *
 * @athor:lhl
 * @create:2019-09-15 16:45
 */
public class Encryption_and_Decryption {

    public static void main(String[] args) {
        Encryption("Java常用类/good.jpg","Java常用类/good_secret.jpg");
        //再加密一次就是解密
        Encryption("Java常用类/good_secret.jpg","Java常用类/good2.jpg");
    }

    public static boolean Encryption(String src,String dest){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);


            //读取与复制
            byte[] buff=new byte[5];
            int len;
            while ((len=fis.read(buff))!=-1){
                //加密
                for (int i = 0; i <len ; i++) {
                    buff[i]= (byte) (buff[i] ^ 7);
                }
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行");
            //资源关闭
            if(fos!=null){
                try {
                    fis.close();
                    System.out.println("资源已关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fos.close();
                    System.out.println("资源已关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;

    }

}
