/**
 * FileName:   AtomicTest.java
 * @Description 原子类
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wanglei
 *
 */
public class AtomicTest {
    static AtomicLong seq = new AtomicLong(0);
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0 ; i < 1000 ; i++){
            executorService.submit(new Runnable() {
                
                @Override
                public void run() {
                    get();
                }
            });
            
        }
    }
    
    public static long get(){
        long l = seq.getAndIncrement();
        System.out.println(l);
        return l;
    }
}
