package src.javase.netdemo.server;

import src.javase.netdemo.client.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User)objectInputStream.readObject();

            String str;
            if (user.getUsername().equals("jiangbaiyan") && user.getPassword().equals("123456")) {
                str = "登录成功";
            } else {
                str = "登录失败";
            }
            socket.shutdownInput();

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(str);

            socket.shutdownOutput();

            inputStream.close();
            objectInputStream.close();
            dataOutputStream.close();
            socket.close();
        }
        // serverSocket.close();
    }
}
