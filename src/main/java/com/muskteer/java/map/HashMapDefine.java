package com.muskteer.java.map;

import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by wanglei on 2018/7/23.
 */
public class HashMapDefine {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        System.out.println(m.size());
        m.put(1,2);
        m.put(2,2);
        System.out.println(m.size());

        //hashMap扩容，当size > 0.75 * 容量
    }
}
