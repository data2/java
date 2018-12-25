/**
 * FileName:   Executors.java
 * @Description Executors并发框架
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.framework;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wanglei
 *
 */
public class Executor {

    private static ExecutorService executors = Executors.newFixedThreadPool(10);

    public static void main(String[] args) 
            throws InterruptedException, ExecutionException {
        Future<Boolean> future = null;
        Random random = new Random();
        for(int i = 0 ; i < 10; i++){
            /**java.util.concurrent.ExecutorService.submit(Callable<V> task)**/
            future = executors.submit(new CallableImpl(random));
            System.out.println(future.get());
        }
        /**Future<?> java.util.concurrent.ExecutorService.submit(Runnable task)**/
        executors.submit(new RunnableImpl());
    }
}

class CallableImpl implements Callable<Boolean>{

    private Random random;
    public CallableImpl(Random random) {
        this.random = random;
    }
    
    @Override
    public Boolean call() throws Exception {
        return random.nextInt(10) > 5;
    }
    
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable");
    }
    
}
