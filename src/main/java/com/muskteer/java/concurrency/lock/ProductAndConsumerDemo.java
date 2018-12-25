/**
 * FileName:   ProductAndConsumerDemo.java
 * @Description use lock and condition to solve p-c model
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.lock;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * implement p-c with lock condition queue 
 *
 */
public class ProductAndConsumerDemo {
    
    static PriorityQueue<String> queue = new PriorityQueue<String>();
    int queueSize = 10;
    
    Lock lock = new ReentrantLock();
    Condition isFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProductAndConsumerDemo demo = new ProductAndConsumerDemo();
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 0 ; i < 20 ;i++){
            es.submit(demo.new Product());
            es.submit(demo.new Consumer());
        }
    }


    class Product implements Runnable{
        
        @Override
        public void run() {
            lock.lock();
            try {
                while(queue.size() == queueSize){
                    isFull.await();
                }
                String s = "str" + new Random().nextInt();
                queue.offer(s);
                System.out.println("offer queue :" + s);
                notEmpty.signalAll();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

    class Consumer implements Runnable{
        
        @Override
        public void run() {
            lock.lock();
            try {
                while(queue.size() == 0){
                    notEmpty.await();
                }    
                String s = queue.poll();
                System.out.println("take queue :" + s);
                isFull.signalAll();
            } catch (Exception e) {
            } finally{
                lock.unlock();
            }
        }
    }

}
