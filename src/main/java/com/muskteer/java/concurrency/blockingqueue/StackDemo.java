/**
 * FileName:   StackDemo.java
 * @Description stack
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.blockingqueue;

import java.util.Stack;

/**
 *后进先出 LIFO
 *继承自Vector,线程安全
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(1);
        System.out.println(s.pop());
    }

}
