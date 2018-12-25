/**
 * FileName:   DequeDemo.java
 * @Description 双向队列 deque
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.blockingqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 *双向队列 deque
 *继承queue接口
 *Deque表示双端队列。双端队列是在两端都可以进行插入和删除的队列
 *Deque既可以用作后进先出的栈，也可以用作先进先出的队列。
 *Deque是一个比Stack和Queue功能更强大的接口，它同时实现了栈和队列的功能。
 *
 *
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<Integer>();
        d.offer(1);
        d.offer(2);
        d.offerFirst(0);
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        
        d = new ArrayDeque<Integer>();
        System.out.println(d.offerFirst(1));
    }
}
