import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class TestNIO {

    // 一个线程处理多个客户端连接
    public static void main(String[] args) throws Exception {
        // 用来存储客户端连接，后面讲
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();  //服务端开启监听，接受客户端
        ss.bind(new InetSocketAddress(8090));
        ss.configureBlocking(false); //重点，不阻塞
        while (true) {
            SocketChannel client = ss.accept(); //不会阻塞
            // 在BIO 的时候一直阻塞，但是在NIO不阻塞，直接返回NULL
            // 如果来客户端的连接，accept 返回的是这个客户端的fd  5，client  object
            if (client == null) {
                Thread.sleep(1000); // 如果没有客户端连接，每隔一秒打印一次null
                // 没有客户端连进来
                System.out.println("null.....");
            } else {
                // 有客户端连进来
                client.configureBlocking(false); // 客户端连接也设置成非阻塞
                System.out.println("client..port: " + client.socket().getPort());
                clients.add(client); // 重点，将得到的客户端连接加入到集合中
            }
            // 读取客户端连接数据
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            //遍历已经链接进来的客户端，看看每一个客户端连接是否能够读写数据
            for (SocketChannel c : clients) {
                int num = c.read(buffer);  // >0  -1  0   //不会阻塞
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);
                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + " : " + b);
                    buffer.clear();
                }
            }
        }
    }
}
