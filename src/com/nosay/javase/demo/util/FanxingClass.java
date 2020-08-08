package src.com.nosay.javase.demo.util;

public class FanxingClass<E> {

    public E name;
    public E age;

    public FanxingClass(E name, E age) {
        this.name = name;
        this.age = age;
    }

    public <Q> void show(Q q) {
        System.out.println(q);
    }

}
