package IO_Test;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 继承Object,可作为输入输出流
 *
 *
 *  构造器
 * public RandomAccessFile(File file, String mode)
 * public RandomAccessFile(String name, String mode)
 * 创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指
 * 定 RandomAccessFile 的访问模式：
 * r:  以只读方式打开
 * rw ：打开以便读取和写入
 * rwd: 打开以便读取和 写入；同步文件内容的更新
 * rws: 打开以便读取和 写入； 同步文件内容和元数据 的 更新
 *  如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
 * 如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不
 * 存在则会去创建文件，如果存在则不会创建。
 *
 *
 * 我们可以用RandomAccessFile这个类，来实现一个多线程断点下载的功能，
 * 用过下载工具的朋友们都知道，下载前都会建立两个临时文件，一个是与
 * 被下载文件大小相同的空文件，另一个是记录文件指针的位置文件，每次
 * 暂停的时候，都会保存上一次的指针，然后断点下载的时候，会继续从上
 * 一次的地方下载，从而实现断点下载或上传的功能，有兴趣的朋友们可以
 * 自己实现下。
 *
 * @athor:lhl
 * @create:2019-09-17 21:58
 */
public class _9_RandomAccessFile {

    //简单的抛出异常应该用try-cath-finally
    //存是覆盖,但不是全覆盖,依次覆盖
    @Test
    public void test1() throws IOException {
        //来个流
        RandomAccessFile raf1=new RandomAccessFile("radom.txt","rw");

        //写
        raf1.write("gbk2312".getBytes());

        //关
        raf1.close();
    }

    //还可实现文件的复制
    @Test
    public void test2() throws IOException{
        //来两个流
        RandomAccessFile raf1=new RandomAccessFile("good.jpg","r");
        RandomAccessFile raf2=new RandomAccessFile("RAF_good.jpg","rw");

        //复制
        byte[] buff=new byte[1024];
        int len=0;
        while ((len=raf1.read(buff)) !=-1){
            //写进去
            raf2.write(buff,0,len);
        }

        raf1.close();
        raf2.close();
    }

    //文本文件的随机读取与写入
    @Test
    public void test3()throws IOException{
        RandomAccessFile raf1=new RandomAccessFile("radom.txt","rw");

        //文件指针位置
        raf1.seek(3);
        raf1.write("pppppp".getBytes());

        raf1.close();
    
    }

    public static void main(String[] args) {

        String str=new String("a0123123嗷嗷嗷");

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if(c-48>=0 && c-48<=10){
                System.out.println(true);
            }
            else System.out.println(false);
        }
    }

}
