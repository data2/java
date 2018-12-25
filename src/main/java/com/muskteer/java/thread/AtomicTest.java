package com.muskteer.java.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author wanglei
 *         Java从JDK1.5开始提供了java.util.concurrent.atomic包，方便程序员在多线程环境下，无锁的进行原子操作。
 * 
 *         可用于多线程高并发的计数器
 * 
 *         AtomicBoolean，AtomicInteger，AtomicLong，AtomicReference
 * 
 *         AtomicIntegerArray，AtomicLongArray
 * 
 *         AtomicLongFieldUpdater，AtomicIntegerFieldUpdater，
 *         AtomicReferenceFieldUpdater
 * 
 *         AtomicMarkableReference，AtomicStampedReference，AtomicReferenceArray
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(1);
        atomicLong.getAndIncrement();
    }
}
