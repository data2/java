package com.muskteer.java.thread;

/**
 * 单例模式
 * 
 * @author wanglei
 *
 */
public class SingletonModuleTest {
    /**
     * synchronized是作用在对象上的 double-check
     */
    private static SingletonModuleTest _instance;

    public static SingletonModuleTest getInstance() {
        if (_instance == null) {
            synchronized (SingletonModuleTest.class) {
                if (_instance == null) {
                    _instance = new SingletonModuleTest();
                }
            }
        }
        return _instance;
    }
}