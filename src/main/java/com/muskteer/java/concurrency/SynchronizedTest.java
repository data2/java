/**
 * FileName:   SynchronizedTest.java
 * @Description 同步关键字
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanglei
 *
 */
public class SynchronizedTest {
    
    private static int total = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i = 0 ; i < 100 ; i++){
            executorService.submit(new Runnable() {
                
                @Override
                public void run() {
                    System.out.println(addOne());
                }
            });
            
        }
        
    }
    
    /**
     * 
     */
    public static synchronized int addOne() {
        total = total + 1;
        return total;
    }
}

