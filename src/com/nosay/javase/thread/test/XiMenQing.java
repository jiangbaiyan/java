package src.com.nosay.javase.thread.test;

public class XiMenQing {
    public static void main(String[] args) {
        // wangpo代理panjinlian，实际干活的是panjinlian
        WangPo wangPo = new WangPo(new PanJinLian());
        wangPo.playWithMen();
        wangPo.makeEyesWithMen();
    }
}
