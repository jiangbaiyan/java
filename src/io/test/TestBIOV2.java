import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestBIOV2 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8090);
        while (true) {
            Socket client = server.accept(); // 阻塞
            System.out.println("port:accept" + client.getPort());
            // 每来一个连接抛出一个线程，这样一个服务端线程可以处理多个客户端连接
            new Thread(() -> {
                try {
                    InputStream inputStream = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    // 读取客户端数据
                    while(true) {
                        System.out.println(reader.readLine()); // 阻塞
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
