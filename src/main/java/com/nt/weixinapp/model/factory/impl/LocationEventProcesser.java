package com.nt.weixinapp.model.factory.impl;

import java.util.Map;

import com.nt.weixinapp.model.factory.intrf.IEventProcesser;

public class LocationEventProcesser implements IEventProcesser {

	@Override
	public String handle(Map<String, String> parseRequest) {
		// TODO Auto-generated method stub
		return "上报地理位置 事件";
	}

}
