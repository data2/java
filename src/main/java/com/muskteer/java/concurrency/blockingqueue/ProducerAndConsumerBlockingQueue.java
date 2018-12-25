/**
 * FileName:   BlockingQueueTest.java
 * @Description producer and consumer.
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerAndConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>();
        for(int i  = 1 ; i < 3 ; i ++){
            new Thread(new Producer("producer" + i, queue)).start();
            new Thread(new Consumer("consumer" + i , queue)).start();
        }
        
    }

}

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private String name;
    
    public Producer(String name, BlockingQueue<Integer> queue) {
        super();
        this.name = name;
        this.queue = queue;
    }


    public void run() {
        try {
            System.out.println(name + " begin produce");
            int r = new Random().nextInt();
            queue.put(r);
            System.out.println(name + " produce " + r);
            System.out.println(name + " end produce");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private String name;
    
    public Consumer(String name, BlockingQueue<Integer> queue) {
        super();
        this.name = name;
        this.queue = queue;
    }


    public void run() {
        try {
            System.out.println(name + " begin consume");
            System.out.println(name + " consume " + queue.take());
            System.out.println(name + " end consume");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
