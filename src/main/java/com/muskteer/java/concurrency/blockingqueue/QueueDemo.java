/**
 * FileName:   QueueDemo.java
 * @Description Queue
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.blockingqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        //LinkedList 实现Deque接口、list接口
        Queue<Integer> q = new LinkedList<Integer>() ;
        q.offer(1);
        System.out.println(q.poll());
        
        Queue<Integer> q2 = new PriorityQueue<Integer>();
        q2.offer(2);
        System.out.println(q2.peek());
        
    }
    
}
