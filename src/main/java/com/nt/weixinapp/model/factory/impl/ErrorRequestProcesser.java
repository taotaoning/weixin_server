package com.nt.weixinapp.model.factory.impl;

import java.util.Map;

import com.nt.weixinapp.model.factory.intrf.IMessageProcesser;
import com.nt.weixinapp.model.factory.intrf.IRequestProcesser;

public class ErrorRequestProcesser implements IRequestProcesser {

	@Override
	public String handle(Map<String, String> parseRequest) {
		// TODO Auto-generated method stub
		return "无法识别的请求！！！";
	}

}
