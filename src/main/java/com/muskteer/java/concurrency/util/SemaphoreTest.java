/**
 * FileName:   SemaphoreTest.java
 * @Description 信号量 对共享资源的控制一种控制
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>信号量是用来对某一共享资源所能访问的最大个数进行控制</p>
 * 
 * <p>Semaphore实现的功能就类似厕所有5个坑，假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？
 * 同时只能有5个人能够占用，当5个人中 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。</p>
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        ExecutorService es =  Executors.newFixedThreadPool(10);
        for(int i =0 ; i < 8; i++ ){
            es.submit(new SemaphoreThread("thread"+i, semaphore));
        }
    }
}

class SemaphoreThread extends Thread{

    private String name;
    private Semaphore semaphore;
    public SemaphoreThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(name + " start " + semaphore.availablePermits());
            semaphore.tryAcquire();
            System.out.println(name + "开始干活");
            Thread.sleep(1000);
            System.out.println(name + "完成干活");
            semaphore.release();
            System.out.println(name + " finish " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}
