/**
 * FileName:   CountDownLatchTest.java
 * @Description 同步辅助类
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.util;

import java.util.concurrent.CountDownLatch;

/**
 * @author wanglei
 *
 */
public class CountDownLatchTest {

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
        System.out.println(latch.getCount());//count变量就是抽象队列同步器内部的变量state
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