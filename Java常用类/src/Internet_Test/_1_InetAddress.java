package Internet_Test;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 127.0.0.1 localhost 是本地回环的ip与主机名
 *
 * 端口号+IP 构成网络套接字 Socket
 *
 * @athor:lhl
 * @create:2019-09-18 19:06
 */
public class _1_InetAddress {

    //使用InetAddress.getByName(),获取InetAddress实例
    @Test
    public void test1() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("baidu.com");
        System.out.println(address);//baidu.com/39.156.69.79

        System.out.println(address.getHostAddress());//39.156.69.79
        System.out.println(address.getHostName());//baidu.com

        InetAddress address1 = InetAddress.getByName("localhost");
        System.out.println(address1);//localhost/127.0.0.1
        System.out.println(address1.getHostAddress());//127.0.0.1
    }
}
