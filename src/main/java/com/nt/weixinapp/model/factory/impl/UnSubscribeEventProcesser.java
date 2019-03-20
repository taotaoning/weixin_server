package com.nt.weixinapp.model.factory.impl;

import java.util.Map;

import com.nt.weixinapp.model.factory.intrf.IEventProcesser;

public class UnSubscribeEventProcesser implements IEventProcesser {

	@Override
	public String handle(Map<String, String> parseRequest) {
		// TODO Auto-generated method stub
		return "取消订阅";
	}

}
