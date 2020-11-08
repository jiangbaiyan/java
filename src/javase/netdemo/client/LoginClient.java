package src.javase.netdemo.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 10000);
        OutputStream outputStream = socket.getOutputStream();
        User user = new User("jiangbaiyan", "123456");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        socket.shutdownOutput();
        outputStream.close();
        objectOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String str = dataInputStream.readUTF();
        System.out.println(str);

        outputStream.close();
        dataInputStream.close();
        socket.close();
        objectOutputStream.close();
    }
}
