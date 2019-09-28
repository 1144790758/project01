package Internet_Test;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端给服务端发送消息
 *
 * 注意客户端读取socket中的数据的方法是一个堵塞的方法
 * 直到输出流被关闭或者是使用socket.shutdownStream()方法关闭
 *
 * @athor:lhl
 * @create:2019-09-18 19:28
 */
public class _2_TCP_Test {
    //client
    @Test
    public void test1(){
        Socket client= null;
        OutputStream stream = null;
        try {
            //1创建客户端套接字
            InetAddress ia=InetAddress.getByName("localhost");
            client = new Socket(ia,9797);

            //2 来个输出流
            stream = client.getOutputStream();

            stream.write("我爱中国哦嗷嗷嗷".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (client!=null){

                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //server端
    @Test
    public void test2(){
        ServerSocket ss= null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bos=null;
        try {
            //来个服务器端口
            ss = new ServerSocket(9797);

            //接受客户端的socket并保存下来
            socket = ss.accept();

            //读取socket的内容(socket就像是装了货物的船)
            inputStream = socket.getInputStream();

            //方式一不推荐,缓冲容器太小的话 中文字符字节会被分为两段
//        int len=0;
//        byte[] buff=new byte[5];
//        while ((len=inputStream.read(buff))!=-1){
//            String str=new String(buff,0,len);
//            System.out.println(str);
//        }

            //方式二:
            //bos 相当于一个中间介质,往他里面写东西他会保存在内部,所以分段的数据写入,
            // 在最后一个toString()就可以读取整段完整的字符数据
            bos=new ByteArrayOutputStream();
            int len=0;
            byte[] buff=new byte[5];
            while ((len=inputStream.read(buff))!=-1){
                bos.write(buff,0,len);
            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
