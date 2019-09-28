package IO_Test;

import org.junit.Test;

import java.io.*;

/**
 *
 * 提一下: 在主函数中的工作目录在当前project,而单元测试工作目录在当前Module
 *
 * 使用抛异常的方式处理流可能出现的异常,在流操作的某个过程中若是
 * 出现异常就不会执行后面的代码,流的资源就无法关闭,应该使用try-catch-finally
 *
 *
 * @athor:lhl
 * @create:2019-09-12 19:16
 */
public class _2_Writer_and_Reader_Test {

    //读取hello.txt文件的内容并输出在控制台
    @Test
    public void test1() throws IOException {
        //1 实例化file
        File file=new File("hello.txt");

        //2创建字符流
        FileReader fr=new FileReader(file);

//        int point=fr.read();

        //循环读取
        //方式一:
//        while (point!=-1){
//            System.out.print((char)point);
//            point=fr.read();
//        }
        int point;
        //方式二
        while ((point=fr.read())!=-1){
            System.out.print((char)point);
        }
        fr.close();
    }

    //流异常处理的改进
    @Test
    public void test2()   {
        int point;

        //1 实例化file
        File file=new File("hello.txt");

        //2创建字符流
        FileReader fr= null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        int point=fr.read();

        //循环读取
        //方式一:
//        while (point!=-1){
//            System.out.print((char)point);
//            point=fr.read();
//        }
        //方式二
        try {
            while ((point=fr.read())!=-1){
                System.out.print((char)point);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //创建缓冲数组加快读取

    @Test
    public void test3(){

        FileReader fr=null;
        try {
            fr=new FileReader("hello.txt");

            //创建一个char[] 用于缓存
            char[] buff=new char[4];

            int len;
            //The number of characters read, or -1 if the end of the stream has been reached
            //public int read(char cbuf[]) 把字符串复制到cbuf[]中,返回的是读取到的长度,-1为读取完毕

            //注意buff[]中任然残留着上次的未覆盖的字符
            while ((len =fr.read(buff))!=-1){
                for (int i = 0; i < len; i++) {
                    System.out.print(buff[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null){
                    fr.close();
                    System.out.println("\n流已关闭");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //File_Writer 的测试
    /*
    1. 如果目标文件类不存在则会创建文件
    2. 若是目标文件存在则会覆盖原有内容
    3. public FileWriter(File file, boolean append) append:在末尾添加
    4. write(char cbuf[], int off, int len) 可以从缓冲区中读取指定长度的字符
     */
    @Test
    public void test4(){
        //1 来一个目标文件类
        File dest=new File("hello2.txt");
        FileWriter fw=null;
        //创建字符写入流
        try {
             fw=new FileWriter(dest);

            fw.write("you need a dream.");
            fw.write("\ni need a dream.");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
