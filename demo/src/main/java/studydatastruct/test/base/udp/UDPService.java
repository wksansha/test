package studydatastruct.test.base.udp;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

/**
 * @author wangkai
 * @create 2019/8/8
 */
public class UDPService {
    public static final String SERVICE_IP = "10.8.86.28";

    public static final int SERVICE_PORT = 8888;

    public static final int MAX_BYTES = 2048;

    private DatagramSocket service;

    public static void main(String[] args) {
        UDPService udpService = new UDPService();
        udpService.startService(SERVICE_IP,SERVICE_PORT);//启动服务端
    }

    private void startService(String ip, int port) {
        try {
            //包装IP地址
            InetAddress address = InetAddress.getByName(ip);
            //创建服务端的DatagramSocket对象，需要传入地址和端口号
            service = new DatagramSocket(port,address);

            byte[] receiveBytes = new byte[MAX_BYTES];
            //创建接受信息的包对象
            DatagramPacket receivePacket = new DatagramPacket(receiveBytes,receiveBytes.length);

            //开启一个死循环，不断接受数据
            while(true){
                try{
                    //接收数据，程序会阻塞到这一步，直到收到一个数据包为止
                    service.receive(receivePacket);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //解析收到的数据
                String receiveMsg = new String(receivePacket.getData(),0,receivePacket.getLength());
                //解析客户端地址
                InetAddress clientAddress = receivePacket.getAddress();
                //解析客户端端口
                int clientPort = receivePacket.getPort();

                //组建响应信息
                String response = "Hello world " + System.currentTimeMillis() + " " + receiveMsg;
                byte[] responseBuf = response.getBytes();
                //创建响应信息的包对象，由于要发送到目的地址，所以要加上目的主机的地址和端口号
                DatagramPacket responsePacket = new DatagramPacket(responseBuf,responseBuf.length,clientAddress,clientPort);

                try{
                    //发送数据
                    service.send(responsePacket);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭DatagramSocket对象
            if(service!=null){
                service.close();
                service = null;
            }
        }
    }
}
