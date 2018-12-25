/**
 * FileName:   ReenTrantLockTest.java
 * @Description ReenTrantLockTest
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockTest {
 
    int i = 0 ;
    
    private ReentrantLock lock = new ReentrantLock();
    
    public int setValue() {
        lock.lock();
        try {
            i = i + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
        return i;
    }
    
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        final ReenTrantLockTest obj = new ReenTrantLockTest();
        for(int i = 0 ; i < 100; i ++ ){
            es.submit(new CallableUU(i, obj));
        }
    }
}

class CallableUU implements Callable<Object> {
    
    int i = 0;
    ReenTrantLockTest obj;
    public CallableUU(int i, ReenTrantLockTest obj) {
        this.i = i ;
        this.obj = obj;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("第" + i + "个线程,执行结果为：" +obj.setValue());
        return null;
    }
    
}
