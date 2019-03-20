package com.nt.weixinapp.model.factory.impl;

import java.util.Map;

import com.nt.weixinapp.model.event.intrf.IEventHandler;
import com.nt.weixinapp.model.factory.HandlerFactory;
import com.nt.weixinapp.model.factory.intrf.IEventProcesser;
import com.nt.weixinapp.utils.MessageUtils;

public class ClickEventProcesser implements IEventProcesser {

	
	@Override
	public String handle(Map<String, String> parseRequest) {
		
		String key = parseRequest.get(MessageUtils.EventKey);
		
		HandlerFactory hf = HandlerFactory.getInstance();
		IEventHandler eventHandler = hf.getEventHandler(key);
		
		System.out.println(key);
		
		return eventHandler.handler(parseRequest);
	}

}
