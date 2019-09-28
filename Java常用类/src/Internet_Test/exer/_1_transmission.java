package Internet_Test.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习:客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端
 * @athor:lhl
 * @create:2019-09-19 12:13
 */
public class _1_transmission {
    
    @Test
    public void testClient(){
        Socket client= null;
        OutputStream stream = null;
        ByteArrayOutputStream baos=null;
        try {
            //1创建客户端套接字
            InetAddress ia=InetAddress.getByName("localhost");
            client = new Socket(ia,9797);

            //2 来个输出流
            stream = client.getOutputStream();

            //读取文本内容
            FileInputStream fis=new FileInputStream("hello2.txt");

            //循环写入到socket的输出流中
            byte[] buff=new byte[5];
            int len=0;
            while ((len=fis.read(buff))!=-1){
                stream.write(buff,0,len);
            }
            //输出内容结束关闭输出流
            client.shutdownOutput();

            InputStream inputStream = client.getInputStream();
            baos=new ByteArrayOutputStream();

            len=0;
            while ((len = inputStream.read(buff))!=-1) {
                baos.write(buff,0,len);
            }

            System.out.println(baos.toString());

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

    //服务端,接受字符并转为大写
    @Test
    public void testServer(){
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

            //bos 相当于一个中间介质,往他里面写东西他会保存在内部,所以分段的数据写入,
            // 在最后一个toString()就可以读取整段完整的字符数据
            bos=new ByteArrayOutputStream();
            int len=0;
            byte[] buff=new byte[5];
            while ((len=inputStream.read(buff))!=-1){
                bos.write(buff,0,len);
            }

            //再将处理过后的字符传回去
            String toUpperCase = bos.toString().toUpperCase();
            OutputStream ops = socket.getOutputStream();

            ops.write(toUpperCase.getBytes());

            socket.shutdownOutput();

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
