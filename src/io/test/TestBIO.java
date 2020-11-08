import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestBIO {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8090);
        while (true) {

            System.in.read(); // 忽略，分水岭

            Socket client = server.accept(); // 阻塞
            System.out.println("port:" + client.getPort());
            InputStream inputStream = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 持续读取当前客户端数据
            while (true) {
                System.out.println(reader.readLine()); // 阻塞
            }
        }
    }
}
