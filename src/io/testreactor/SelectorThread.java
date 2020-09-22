package src.io.testreactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorThread implements Runnable {
    // 每个线程对应一个selector，多线程情况下该主机，该程序的并发客户端被分配到多个selector上
    // 每个客户端只绑定到其中一个selector

    Selector selector = null;

    SelectorThread() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Loop
        while (true) {
            try {
                // 1.select
                int nums = selector.select(); // 不传任何参数会阻塞，什么都没注册的时候会永久阻塞。如果在另外一个线程往里注册了，那么需要让他解除阻塞，重新调select询问
                // 2. 有事件了处理selectKeys
                if (nums > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    // 线性处理
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) { // 复杂，接受客户端的过程（接收之后要注册，然后要分发到某个selector上）
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        } else if (key.isWritable()) {

                        }
                    }
                }
                // 3.处理一些task
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readHandler(SelectionKey key) {
        ByteBuffer buffer = (ByteBuffer)key.attachment();
        SocketChannel client = (SocketChannel)key.channel();
        buffer.clear();
        while (true) {
            try {
                int num = client.read(buffer);
                // 读到了东西
                if (num > 0) {
                    buffer.flip(); // 将读到的内容翻转，然后直接写
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (num == 0) { // 没读到东西
                    break;
                } else { // 客户端断开了
                    System.out.println("client:" + client.getRemoteAddress() + "closed...");
                    key.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel server = (ServerSocketChannel)key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            // TODO: choose a selector and register
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
