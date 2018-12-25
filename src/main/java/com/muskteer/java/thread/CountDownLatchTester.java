package com.muskteer.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author wanglei 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 *         CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 *         比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 */
public class CountDownLatchTester {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable1("1"));
        t1.start();
        latch.countDown();

        Thread t2 = new Thread(new Runnable1("2"));
        t2.start();
        latch.countDown();

        // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
        latch.await();
        System.out.println("all thread is done");
    }

}

class Runnable1 implements Runnable {
    public String name;

    public Runnable1(String str) {
        name = str;
    }

    @Override
    public void run() {
        System.out.println("thread == " + name);
    }

}