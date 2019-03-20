package com.nt.weixinapp.model.event.impl;

import java.util.Map;

import com.nt.weixinapp.model.event.intrf.IEventHandler;

public class ElevenHandler implements IEventHandler {

	@Override
	public String handler(Map<String, String> parseRequest) {
		// TODO Auto-generated method stub
		return "天气查询";
	}

}
