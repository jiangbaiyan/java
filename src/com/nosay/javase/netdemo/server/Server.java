package src.com.nosay.javase.netdemo.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket server = serverSocket.accept();
        InputStream inputStream = server.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println(str);
        dataInputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
