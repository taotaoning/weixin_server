package com.nt.weixinapp.model.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.model.event.impl.ElevenHandler;
import com.nt.weixinapp.model.event.impl.FifteenHandler;
import com.nt.weixinapp.model.event.impl.FourteenHandler;
import com.nt.weixinapp.model.event.impl.ThirteenHandler;
import com.nt.weixinapp.model.event.impl.ThirtyFiveHandler;
import com.nt.weixinapp.model.event.impl.ThirtyFourHandler;
import com.nt.weixinapp.model.event.impl.ThirtyOneHandler;
import com.nt.weixinapp.model.event.impl.ThirtyThreeHandler;
import com.nt.weixinapp.model.event.impl.ThirtyTwoHandler;
import com.nt.weixinapp.model.event.impl.TwelveHandler;
import com.nt.weixinapp.model.event.impl.TwentyFiveHandler;
import com.nt.weixinapp.model.event.impl.TwentyFourHandler;
import com.nt.weixinapp.model.event.impl.TwentyOneHandler;
import com.nt.weixinapp.model.event.impl.TwentyThirdHandler;
import com.nt.weixinapp.model.event.impl.TwentyTwoHandler;
import com.nt.weixinapp.model.event.intrf.IEventHandler;
import com.nt.weixinapp.model.factory.intrf.IRequestProcesser;

public class HandlerFactory extends AbstractFactory {

	private static final Logger log = LoggerFactory.getLogger(HandlerFactory.class);
	
	private static final HandlerFactory INSTANCE = new HandlerFactory();
	
	private  HandlerFactory() {
	
	}
	
	public static HandlerFactory getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public IRequestProcesser getRequestProcesser(String type, String event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEventHandler getEventHandler(String key) {

		IEventHandler eventHandler = null;
		
		if("11".equals(key)) {
			eventHandler = new ElevenHandler();
		}else if("12".equals(key)) {
			eventHandler = new TwelveHandler();
		}else if("13".equals(key)) {
			eventHandler = new ThirteenHandler();
		}else if("14".equals(key)) {
			eventHandler = new FourteenHandler();
		}else if("15".equals(key)) {
			eventHandler = new FifteenHandler();
		}else if("21".equals(key)) {
			eventHandler = new TwentyOneHandler();
		}else if("22".equals(key)) {
			eventHandler = new TwentyTwoHandler();
		}else if("23".equals(key)) {
			eventHandler = new TwentyThirdHandler();
		}else if("24".equals(key)) {
			eventHandler = new TwentyFourHandler();
		}else if("25".equals(key)) {
			eventHandler = new TwentyFiveHandler();
		}else if("31".equals(key)) {
			eventHandler = new ThirtyOneHandler();
		}else if("32".equals(key)) {
			eventHandler = new ThirtyTwoHandler();
		}else if("33".equals(key)) {
			eventHandler = new ThirtyThreeHandler();
		}else if("34".equals(key)) {
			eventHandler = new ThirtyFourHandler();
		}else if("35".equals(key)) {
			eventHandler = new ThirtyFiveHandler();
		}else {
			log.error("不支持的菜单操作！！ key = " + key);
		}
		
		
		return eventHandler;
	}

}
