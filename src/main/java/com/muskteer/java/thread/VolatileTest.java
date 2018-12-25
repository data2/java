package com.muskteer.java.thread;

public class VolatileTest {

    public static volatile int i = 10;

    public static void main(String[] args) throws InterruptedException {
        final A a = new A();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                a.write();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(a.read());
            }
        });

        t2.start();
        Thread.sleep(1000);
        t1.start();

    }

}

class A {

    volatile long a = 0;

    public long read() {
        while (a != 1) {
            System.out.println("不行");
        }
        System.out.println("行了");
        return a;
    }

    public void write() {
        a += 1;
    }
}