package src.io.testreactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class SelectorThreadGroup {

    SelectorThread[] sts;
    ServerSocketChannel server = null;
    AtomicInteger xid = new AtomicInteger(0);

    SelectorThreadGroup(int num) {
        // num 线程数
        sts = new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread();
            // 开启线程，刚开启就阻塞在select()处
            new Thread(sts[i]).start();
        }
    }

    public void bind(int port) {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            // 注册到哪个select上呢？
            nextSelector(server);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nextSelector(Channel c) {
        SelectorThread st = next();

        // 1.通过队列传递消息
        st.lbq.add(c);
        // 2.通过打断阻塞，让对应的线程去自己完成注册selector（即线程内第3步的task）
        st.selector.wakeup();

        // 重点：c有可能是server，也有可能是client，需要强转。下面的代码是错误的
//        ServerSocketChannel s = (ServerSocketChannel)c;
//        try {
//            // 下边这两个语句执行有坑，是因为多线程语句执行顺序的不确定性，所以必须依赖线程通信机制
//            s.register(st.selector, SelectionKey.OP_ACCEPT); // 有可能他执行的快，wakeup还没来得及执行，一直阻塞
//            st.selector.wakeup(); // 需要线程通信（相当于go里面的channel）
//        } catch (ClosedChannelException e) {
//            e.printStackTrace();
//        }

    }

    // 选择一个selector。无论是serverSocket还是socket都复用这个方法
    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;
        return sts[index];
    }
}
