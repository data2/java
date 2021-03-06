/**
 * FileName:   FloorDecorator.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.designpatterns.struts.decorator.impl;

import com.muskteer.java.designpatterns.struts.decorator.Decorator;
import com.muskteer.java.designpatterns.struts.decorator.HouseDecorator;

/**
 * @author wanglei
 *
 */
public class FloorDecorator extends HouseDecorator {
    Decorator decorator;
    public FloorDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void decorate() {
        decorator.decorate();
        this.floor();
    }

    private void floor() {
        System.out.println("装修地板");
    }

}
