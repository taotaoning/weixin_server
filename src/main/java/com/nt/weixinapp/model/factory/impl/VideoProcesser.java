package com.nt.weixinapp.model.factory.impl;

import java.util.Map;

import com.nt.weixinapp.model.factory.intrf.IMessageProcesser;

public class VideoProcesser implements IMessageProcesser {

	@Override
	public String handle(Map<String, String> parseRequest) {
		// TODO Auto-generated method stub
		return "视频消息";
	}

}
