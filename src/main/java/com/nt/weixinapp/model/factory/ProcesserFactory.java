package com.nt.weixinapp.model.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.model.event.intrf.IEventHandler;
import com.nt.weixinapp.model.factory.impl.ClickEventProcesser;
import com.nt.weixinapp.model.factory.impl.ErrorRequestProcesser;
import com.nt.weixinapp.model.factory.impl.ImageProcesser;
import com.nt.weixinapp.model.factory.impl.LinkProcesser;
import com.nt.weixinapp.model.factory.impl.LocationEventProcesser;
import com.nt.weixinapp.model.factory.impl.LocationProcesser;
import com.nt.weixinapp.model.factory.impl.ScanEventProcesser;
import com.nt.weixinapp.model.factory.impl.ShortVideoProcesser;
import com.nt.weixinapp.model.factory.impl.SubscriEventPorcesser;
import com.nt.weixinapp.model.factory.impl.TextProcesser;
import com.nt.weixinapp.model.factory.impl.UnSubscribeEventProcesser;
import com.nt.weixinapp.model.factory.impl.VideoProcesser;
import com.nt.weixinapp.model.factory.impl.VoiceProcesser;
import com.nt.weixinapp.model.factory.intrf.IRequestProcesser;
import com.nt.weixinapp.utils.MessageUtils;

public class ProcesserFactory extends AbstractFactory {

	private static final Logger log = LoggerFactory.getLogger(ProcesserFactory.class);
	private static ProcesserFactory INSTANCE = new ProcesserFactory();

	private ProcesserFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ProcesserFactory getInstance() {
		return INSTANCE;
	}

	public IRequestProcesser getRequestProcesser(String type, String event) {
		IRequestProcesser processer = null;

		if(event != null) {
			processer = getEventProcesser(event);
		}else {
			if (type.equals("text")) {
				processer = new TextProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_IMAGE)) {
				processer = new ImageProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_VOICE)) {
				processer = new VoiceProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
				processer = new ShortVideoProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_VIDEO)) {
				processer = new VideoProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_LOCALTION)) {
				processer = new LocationProcesser();
			} else if (type.equals(MessageUtils.REQ_MESSAGE_TYPE_LINK)) {
				processer = new LinkProcesser();
			} else {
				log.error("不支持的请求类型 eror type = " + type );
				processer = new ErrorRequestProcesser();
			}

		}

		return processer;
	}

	private IRequestProcesser getEventProcesser(String event) {
		IRequestProcesser processer = null;
		if(MessageUtils.EVENT_TYPE_SUBSCRIBE.equals(event)) {
			processer = new SubscriEventPorcesser();
		}else if(MessageUtils.EVENT_TYPE_UNSUBSCRIBE.equals(event)) {
			processer = new UnSubscribeEventProcesser();
		}else if(MessageUtils.EVENT_TYPE_LOCATION.equals(event)) {
			processer = new LocationEventProcesser();
		}else if(MessageUtils.EVENT_TYPE_SCAN.equals(event)) {
			processer = new ScanEventProcesser();
		}else if(MessageUtils.EVENT_TYPE_CLICK.equals(event)) {
			processer = new ClickEventProcesser();
		}else {
			log.error("不支持的事件类型 eror event = " + event );
			processer = new ErrorRequestProcesser();
		}
		
		return processer;
	}

	@Override
	public IEventHandler getEventHandler(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
