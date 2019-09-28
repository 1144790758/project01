package IO_Test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * try-catch 异常处理:是将异常直接处理了,可以继续往下运行
 * @athor:lhl
 * @create:2019-09-14 20:46
 */
public class _3_FileInputstream_and_FileOutPutStream {

    //复制
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        //记录当前时间
        long start_time=System.currentTimeMillis();
        try {
            //1 创建一个文件对象
            File f=new File("G:\\AE教程\\C4D案例部分\\03 案例 广东体育频道节目预告包装案例\\3 足球场三层环绕观看台建模.mp4");
            File f2=new File("C:\\Users\\Administrator\\Desktop\\copy.mp4");

            //2 创建输入流 输出流
            fis = new FileInputStream(f);
            fos = new FileOutputStream(f2);

            byte[] buff=new byte[1024];
            int len=0;


            //3 读取资源
            while ((len = fis.read(buff))!=-1){
                //把buff中的有效数据写入到输出流中
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


        //4 关闭资源
        if(fos!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //记录当前时间
        long end_time=System.currentTimeMillis();

        System.out.println("花费时间 : "+(end_time - start_time));//花费时间 : 1708
    }

}
