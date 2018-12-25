/**
 * FileName:   House.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.designpatterns.struts.decorator;

/**
 * @author wanglei
 *
 */
public class House implements Decorator{

    @Override
    public void decorate() {
        System.out.println("房子的基本装修");
    }


}
