package src.com.nosay.javase.demo.util;

public class Person implements Comparable {

    public String name;

    public int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return Integer.compare(this.age, p.age);
//        if (this.age == p.age) {
//            return 0; // this = o
//        } else if (this.age > p.age) {
//            return -1; // this < o
//        } else {
//            return 1; // this > o
//        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
