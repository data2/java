package com.muskteer.java;

import org.junit.Test;
import java.lang.Byte;

public class JavaBaseTypeExample {

    @Test
    public void testMinMax(){
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }

    /**
     * Integer与int比较时会自动拆箱
     * int常量池范围-128～127
     * Integer i = 127 等价于 Integer.valueOf(127)
     * Integer.valueOf 会判断值在-128-127间取缓存池中的Integer对象，否则新建对象Integer
     */
    @Test
    public void testInt(){
        int a = 127;
        Integer b = 127;//Integer b = Integer.valueOf(127);
        Integer c = new Integer(127);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

    }

    @Test
    public void testString(){

    }


}
