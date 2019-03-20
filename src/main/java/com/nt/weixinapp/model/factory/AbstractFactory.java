package com.nt.weixinapp.model.factory;

import com.nt.weixinapp.model.event.intrf.IEventHandler;
import com.nt.weixinapp.model.factory.intrf.IRequestProcesser;

public abstract class AbstractFactory {

	public abstract IRequestProcesser getRequestProcesser(String type, String event);
	public abstract IEventHandler getEventHandler(String key);
}
