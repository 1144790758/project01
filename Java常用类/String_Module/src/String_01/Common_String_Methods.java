package String_01;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @athor:lhl
 * @create:2019-07-28 21:27
 */
public class Common_String_Methods {
    @Test
    public void test1(){
        String s1="Hello Word";

        System.out.println(s1.length()); //输出长度

        System.out.println(s1.charAt(0));//获取底层char[0] 元素(因为无法直接操作char[])

        System.out.println(s1.isEmpty());//判断是否为空

        System.out.println(s1.toLowerCase());//转为小写,返回新的引用地址
        System.out.println(s1.toUpperCase());//转为小写,返回新的引用地址

        String s2 = s1.trim();
        System.out.println(s2); //将字符串中的首尾空格除去


    }

    @Test
    public void test02(){
        String s1="HelloWord";
        String s2="helloword";

        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写比较

    }

    @Test
    public void test03(){
        String s1="abc";
        String s2=new String("abe");

        System.out.println(s1.compareTo(s2));//比较大小,value[]依次做比较,不相同就返回前面的减后面的
    }

    @Test
    public void test04(){
        String s1="012345";

        String s2=s1.substring(1); //取子串 12345
        System.out.println(s2);

        String s3=s1.substring(1,4);// 取子串 123
        System.out.println(s3);

    }

    @Test
    public void test05(){
        String s1="hello word";

        System.out.println(s1.endsWith("rd")); //返回是否以某个字符串结尾

        System.out.println(s1.startsWith("he"));//返回是否以某个字符串开头

        System.out.println(s1.startsWith("l", 2));//返回是否从索引开始以某个字符串开头

        System.out.println(s1.contains("o w"));//返回是否字符串包含某个字符串
    }

    @Test
    public void test06(){
        String s1="hello word";

        System.out.println(s1.indexOf("l")); //返回第一次字符串或字符出现的索引,没找到返回-1

        System.out.println(s1.indexOf("w", 1));//从自定位子后查找字符串或字符,并返回索引(6)

        System.out.println(s1.lastIndexOf("o"));//从后往前找,返回索引

        String s2="hello woword";
        System.out.println(s2.lastIndexOf('o', s2.length() - 1 - 3));//从指定索引往后找,并返回索引(7)
    }

    @Test
    public void test07(){
        //从前往后找==从后往前找
        //1 只有一个元素
        //2 没有改字符串
        //3 长度为奇数,找的是一个字符,并且在中间

        String s1="1pop2";

        System.out.println(s1.lastIndexOf("o"));

        System.out.println(s1.indexOf("o"));

    }

    @Test
    public void test08(){
        //替换
        //
        String s1="hellow word";

//      String replace(char oldChar, char newChar) //替换所有oldChar为newChar
//      String replace(CharSequence target, CharSequence replacement)

//      s1.replaceAll(); //匹配正则表达式
//      s1.matches(); //匹配正则表达式

//      s1.split(); //切片
    }

    @Test
    public void test09(){
        //String与基本数据类型 int 的互相转换
        String s1="123";

        int n1=Integer.parseInt(s1);
        System.out.println(n1);

        String s2 = String.valueOf(n1);
        System.out.println(s2);

    }

    @Test
    public void test10(){
        //String与基本数据类型 char[] 的互相转换
        String s1="abc";

        char[] s2 = s1.toCharArray(); //String -> char[]

        String s3=new String(s2); //char[] -> String

    }

    @Test
    public void test11() throws UnsupportedEncodingException {
        //String 与基本数据类型 byte[] 的互相转换
        //也就是编码与解码
        String s1="abc中国";
        byte[] bytes = s1.getBytes(); // String -> bytes[] (默认的字符编码集)
        byte[] gbks = s1.getBytes("gbk");//  byte[] getBytes(Charset charset),charset为字符编码集名字

        System.out.println(Arrays.toString(bytes)); //利用工具包中静态方法Arrays.toString(element) 遍历element
        System.out.println(Arrays.toString(gbks));

        String s2= new String(bytes);//用默认的解码集去解析为字符串,bytes[] -> String
        System.out.println(s2);

        String s3=new String(gbks,"gbk");//指定解码集解码,bytes[] -> String
        System.out.println(s3);

    }

}
