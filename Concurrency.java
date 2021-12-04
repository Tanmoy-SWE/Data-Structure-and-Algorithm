import java.util.concurrent.atomic.AtomicInteger;


class Foo {
    public void first() {
        System.out.println("first");
    }
    public void second() {
        System.out.println("second");
    }

    public void third() {
        System.out.println("third");
    }
}

public class PrintInOrder {

    public static void main(String[] args) {
        AtomicInteger current = new AtomicInteger(0);
        Foo foo = new Foo();
        Thread first = new Thread(() -> {
            while (current.intValue() != 0) ;
            foo.first();
            current.incrementAndGet();
        });
        Thread second = new Thread(() -> {
            while (current.intValue() != 1) ;
            foo.second();
            current.incrementAndGet();
        });
        Thread third = new Thread(() -> {
            while (current.intValue() != 2) ;
            foo.third();
            current.incrementAndGet();
        });

        first.start();
        second.start();
        third.start();
    }
}