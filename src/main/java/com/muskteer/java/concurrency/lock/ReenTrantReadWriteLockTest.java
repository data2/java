/**
 * FileName:   ReenTrantWriteReadLockTest.java
 * @Description ReenTrantReadWriteLock
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * <p>ReentrantReadWriteLock实现了ReadWriteLock接口，并没有实现Lock接口，
 * 是其内部类ReadLock和WriteLock实现了Lock的接口</p>
 * 
 */
public class ReenTrantReadWriteLockTest {
    
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    String obj = new String("shareContent");

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        ReenTrantReadWriteLockTest test = new ReenTrantReadWriteLockTest();
        for(int  i = 0 ; i < 10 ; i ++ ){
            es.submit(test.new GetRunnable());
            if(i < 5){
                es.submit(test.new PutRunnable());
            }
        }
    }
    
    class GetRunnable implements Runnable {

        @Override
        public void run() {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " read " + obj);
            } catch (Exception e) {
            } finally{
                lock.readLock().unlock();
            }
        }

    }
    
    class PutRunnable implements Runnable {

        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                obj = "shareContent".concat(""+new Random().nextInt());
                System.out.println(Thread.currentThread().getName() + " write " + obj);
            } catch (Exception e) {
            } finally{
                lock.writeLock().unlock();
            }
        }

    }
    
}
