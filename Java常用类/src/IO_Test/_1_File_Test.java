package IO_Test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * File类:俗称一个文件或者文件夹,声明在java.io,文件实际可以不必存在
 * 在不同的平台中分割符是不同的:Windows,dos 是 \\
 *                           Linux 是 /
 *
 * 可以使用常量 File.separator 来代替所有平台的分割符
 *
 * @athor:lhl
 * @create:2019-09-10 10:15
 *
 *
 *
 *
 *  public String getAbsolutePath()：获取绝对路径
 *  public String getPath() ：获取路径
 *  public String getName() ：获取名称
 *  public String getParent()：获取上层文件目录路径。若无，返回null
 *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
 *  public long lastModified() ：获取最后一次的修改时间，毫秒值
 *  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 *  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 *  File 类的重命名功能
 *  public boolean renameTo(File dest):把文件重命名为指定的文件路径
 *
 *
 *  File 类的判断功能
 *  public boolean isDirectory()：判断是否是文件目录
 *  public boolean isFile() ：判断是否是文件
 *  public boolean exists() ：判断是否存在
 *  public boolean canRead() ：判断是否可读
 *  public boolean canWrite() ：判断是否可写
 *  public boolean isHidden() ：判断是否隐藏
 *
 *
 *  File 类的创建功能
 *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
 * 如果此文件目录的上层目录不存在，也不创建。
 *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
 * 注意事项：如果你创建文件或者 文件 目录没有 写 盘符路径 ， 那么 ， 默认在项目
 * 路径下 。
 *
 *  File 类的删除功能
 *  public boolean delete()：删除文件或者文件夹
 * 删除注意事项：
 * Java中的删除不走 回收站。
 * 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
 *
 * 以上的方法并未涉及到写入或者读取操作IO
 */
public class _1_File_Test {
    public static void main(String[] args) {
//        Directory_Size();
        Delete_File();
    }

    //输出当前工作路径
    @Test
    public void test1(){
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }


    //boolean renameTo(File dest)重命名指定路径
    //要想返回true file1必须是存在的,且file2不能存在
    @Test
    public void test2() throws IOException {
        File file1=new File("hello.txt");
        File file2=new File("E:\\SoftWare\\hi.txt");

        //移动了且重命名了
        boolean b = file2.renameTo(file1);
        System.out.println(b);

        //创建create.txt文件
        File file3=new File("create.txt");
        file3.createNewFile();
//        file3.isDirectory();
    }

    /*
    遍历指定目录所有文件名称，包括子文件目录中的文件。
    拓展1：并计算指定目录占用空间的大小
    拓展2：删除指定文件目录及其下的所有文件
    */

    public static void Directory_Size(){
        System.out.println("输入路径");
        Scanner scan=new Scanner(System.in);
        String path = scan.nextLine();

        File file=new File(path);

        if(file.exists()){
            long size = MyFileIterator(file);
            System.out.println(size);
        }
        else System.out.println("文件不存在");
    }

    public static void Delete_File(){

        System.out.println("输入路径");
        Scanner scan=new Scanner(System.in);
        String path = scan.nextLine();

        File file=new File(path);

        if(file.exists()){
            boolean b = My_Delete(file);
            System.out.println(b);
        }
        else System.out.println("文件不存在");

    }

    public static long MyFileIterator(File file){
        long size=0L;

        if(file.isFile()){
            return size+file.length();
        }
        else{
            File[] files = file.listFiles();
            for (File f : files) {
                long file_size = MyFileIterator(f);
                size= file_size+size;
            }
        }
        return size;
    }

    public static boolean My_Delete(File file){
        boolean falg=false;

        if (file.isFile()){
            file.delete();
            return true;
        }
        else {
            if(file.delete()){
                return true;
            }
            File[] files = file.listFiles();
            for (File f : files) {
                boolean b = My_Delete(f);
                falg=b;
            }
        }
        return falg;
    }
}
