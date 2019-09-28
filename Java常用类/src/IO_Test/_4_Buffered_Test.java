package IO_Test;

import org.junit.Test;

import java.io.*;

/**
 * //加入字节缓冲流加快处理速度
 * @see BufferedWriter
 * @see BufferedReader
 * 附加:  BufferedReader中有一个方法 readLine(),读取一行内容并返回()不包含换行符(要自己添加,newLine()也可以),返回null表示读取完毕
 * @athor:lhl
 * @create:2019-09-14 23:45
 */
public class _4_Buffered_Test {

    //复制
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;

        //记录当前时间
        long start_time=System.currentTimeMillis();
        try {
            //1 创建一个文件对象
            File f=new File("G:\\AE教程\\C4D案例部分\\03 案例 广东体育频道节目预告包装案例\\3 足球场三层环绕观看台建模.mp4");
            File f2=new File("C:\\Users\\Administrator\\Desktop\\copy.mp4");

            //2 创建输入流 输出流
            fis = new FileInputStream(f);
            fos = new FileOutputStream(f2);

            //把流包裹起来
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);

            byte[] buff=new byte[1024];
            int len=0;

            //3 读取资源
            while ((len = bis.read(buff))!=-1){
                //把buff中的有效数据写入到输出流中
                //会自动调用flush()方法
                bos.write(buff,0,len);

//                bos.flush(); 刷新缓冲区,若缓冲数组没有满强制把缓冲区的内容写入到目标
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


        //4 关闭资源,应该先关闭最外层的流
        //关闭外层的流内层的流也会自动关闭
        if(bis!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(bos!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //记录当前时间
        long end_time=System.currentTimeMillis();

        System.out.println("花费时间 : "+(end_time - start_time));//花费时间 : 519
    }
}
