package com.nt.weixinapp.servlet.servletservice;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.message.respmessage.TextRespMessage;
import com.nt.weixinapp.model.factory.ProcesserFactory;
import com.nt.weixinapp.model.factory.intrf.IMessageProcesser;
import com.nt.weixinapp.model.factory.intrf.IRequestProcesser;
import com.nt.weixinapp.utils.MessageUtils;
import com.nt.weixinapp.utils.StringUtils;

public class CoreService {

	private static final Logger log = LoggerFactory.getLogger(CoreService.class);
	/**
	 * 处理发送的请求
	 * 
	 * @param req
	 * @return
	 */
	public static String processRequest(HttpServletRequest req) {

		// 返回的消息xml
		String respMessage = null;


		// 解析请求
		Map<String, String> parseRequest = MessageUtils.parseRequest(req);

		/**
		 * 
		 * 获取请求的内容
		 */
		// 微信公众号
		String toUserName = parseRequest.get(MessageUtils.TO_USER_NAME);
		// 请求方账号（open_id）
		String fromUserName = parseRequest.get(MessageUtils.FROM_USER_NAME);
		// 请求消息类型
		String msgType = parseRequest.get(MessageUtils.MSGTYPE);
		//事件类型时 参数
		String event = parseRequest.get(MessageUtils.Event);
		IRequestProcesser requestProcesser = ProcesserFactory.getInstance().getRequestProcesser(msgType,event);
		
		
		//处理请求消息主流程
		String content = requestProcesser.handle(parseRequest);
		
		//图片消息返回face人脸检测结果
		if(msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_IMAGE)) {
			return content;
		}
		
		// 构建默认的响应文本消息
		TextRespMessage textMessage = new TextRespMessage();
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType(MessageUtils.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setFuncFlag(0);
		textMessage.setContent(content);
		//将响应消息类转化为xml
		respMessage = MessageUtils.textMessageToXML(textMessage);
		return respMessage;
	}

}
