package IO_Test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二(字符流):
 * @see java.io.InputStreamReader
 * @see java.io.OutputStreamWriter
 *
 * 作用:提供字节流与字符流之间的转换
 * InputStreamReader:字节输入流 转为 字符输入流
 * OutputStreamWriter:字符输出流 转为 字节输出流
 *
 * 也就是解码的作用:字节--->字符
 * 编码:字符--->字节
 *
 * 文件(字节流) --> InputStreamReader(字符流)  --> 程序(字符流) --> OutpuStreamWriter(字节流) --> 文件(字节流)
 *
 * @athor:lhl
 * @create:2019-09-15 18:13
 */
public class _5_InputStreamReader_OutputStreamWriter {

    //转为字符流,指定字符集
    @Test
    public void test1(){
        InputStreamReader isr= null;
        try {
            FileInputStream fis=new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis,"utf8");

            int len=0;
            char[] buff=new char[5];

            while ((len=isr.read(buff))!=-1){
//                for (int i = 0; i < len; i++) {
//                    System.out.println((char) buff[i]);
//                }
                String str=new String(buff,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
