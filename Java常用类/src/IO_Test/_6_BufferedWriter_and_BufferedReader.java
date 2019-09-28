package IO_Test;

import org.junit.Test;

import java.io.*;

/**
 * @athor:lhl
 * @create:2019-09-16 17:08
 */
public class _6_BufferedWriter_and_BufferedReader {

    //使用缓冲流加速复制文本
    @Test
    public void test1(){
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));

            //方式一使用字符数组:
//            char[] buff=new char[5]; //放5个字符
//            int len=0;
//            while ((len=br.read(buff))!=-1){
//                bw.write(buff,0,len);
//
//    //            bw.flush(); //自动就刷写了
//            }

            //方式二 readLine 返回字符串,返回null为读取完毕,但是不包含换行符
            String str=null;
            while ((str=br.readLine())!=null){
                bw.write(str+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw!=null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
