package com.muskteer.java.designpatterns.struts.adapter.impl;

import com.muskteer.java.designpatterns.struts.adapter.AndroidCharger;

public class AndroidChargeImpl implements AndroidCharger{

	@Override
	public void charge() {
		System.out.println("android 充电器 开始充电");
		
	}

}
