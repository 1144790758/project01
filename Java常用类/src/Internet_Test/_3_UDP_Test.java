package Internet_Test;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @athor:lhl
 * @create:2019-09-19 15:26
 */
public class _3_UDP_Test {

    //client
    @Test
    public void testClient() throws IOException {

        //创建UPD套接字
        DatagramSocket ds=new DatagramSocket();

        //封装数据包
        String str="gbkpppppp你好";
        InetAddress ia=InetAddress.getByName("localhost");//本机地址
        DatagramPacket packet=new DatagramPacket(str.getBytes(),0,str.getBytes().length,ia,8989);

        ds.send(packet);

        ds.close();
    }

    //Server
    @Test
    public void testServer()throws IOException{

        DatagramSocket ds=new DatagramSocket(8989);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        ds.receive(packet);

        System.out.println((new String(packet.getData(), 0, packet.getLength())));


        ds.close();



    }

}
