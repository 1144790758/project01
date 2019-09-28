package IO_Test;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 标准输入流(键盘):System.in
 * 标准输出流(控制台):System.out
 *
 * @athor:lhl
 * @create:2019-09-16 18:47
 */
public class _7_other_stream {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    //标准输入流,输出流
    //可以使用System.setIn,System.setIn进行改变默认的输入输出流

    //练习:从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
    //进行输入操作，直至当输入“e”或者“exit”时，退出程序。
    public static void test1() {
        //方式一:使用Scanner实现
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNext("e") && !scan.hasNext("exit")) {
            String str = scan.next();
            System.out.println(str.toUpperCase());
        }
        scan.close();
    }

    public static void test2() {
        BufferedReader br = null;
        try {
            //方式二:
            //1 首先把键盘的输入流转为字符输入流
            InputStreamReader isr = new InputStreamReader(System.in);
            //加入缓冲流提速
            br = new BufferedReader(isr);

            //循环读取键盘的输入内容(键盘一直输入就一直有新的内容添加进来)
            while (true) {
                String str = br.readLine();
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //练习:Create a program named MyInput.java: Contain the methods for reading int,
    //double, float, boolean, short, byte and String values from the keyboard.
//    public static void test3() {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//
//        while (true) {
//            String str = br.readLine();
//            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
//                break;
//            }
//
//        }
//    }

    @Test
    //打印流测试,直接输出到文件中,不经过控制台
    public void test4() throws IOException {
        File f=new File("E:\\ASCII.txt");
        FileOutputStream fos=new FileOutputStream(f);

        PrintStream ps=new PrintStream(fos);

        //修改标准输出流
        System.setOut(ps);

        for (int i = 0; i < 256; i++) {
            System.out.print(" "+(char)i);
            if((i+1)%20==0){
                System.out.println("/n");
            }
        }

        fos.close();
    }
}
