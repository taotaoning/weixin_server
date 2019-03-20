package com.nt.weixinapp.model.factory.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.nt.weixinapp.message.face.pojo.Attributes;
import com.nt.weixinapp.message.face.pojo.FaceRespMessage;
import com.nt.weixinapp.message.face.pojo.FacesModel;
import com.nt.weixinapp.message.respmessage.TextRespMessage;
import com.nt.weixinapp.model.factory.intrf.IMessageProcesser;
import com.nt.weixinapp.servlet.servletservice.FaceService;
import com.nt.weixinapp.utils.MessageUtils;

public class ImageProcesser implements IMessageProcesser {

	private static final Logger log = LoggerFactory.getLogger(IMessageProcesser.class);
	
	@Override
	public String handle(Map<String, String> parseRequest) {
		String result = "图片消息";
		try {
			Gson gson = new Gson();
			result=FaceService.httpRequest(parseRequest);
			FaceRespMessage fromJson = gson.fromJson(result, FaceRespMessage.class);
			
			TextRespMessage faceRespMessage = getFaceRespMessage(fromJson,parseRequest);
			result = MessageUtils.textMessageToXML(faceRespMessage);
		} catch (UnsupportedEncodingException e) {
			log.error("获取图片信息失败！！");
		}
		
		
		
		return result;
	}

	private TextRespMessage getFaceRespMessage(FaceRespMessage fromJson,Map<String,String> parseRequest) {
		TextRespMessage tm = new TextRespMessage();
		log.info("fromJson = " + fromJson);
		FacesModel[] faces = fromJson.getFaces();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(FacesModel fm : faces) {
			
			Attributes attributes = fm.getAttributes();
			sb.append("第"+count+"位人物：\n");
			sb.append(constrouctMessage(attributes));
			sb.append("\n");
			count++;
		}
		tm.setContent(sb.toString());
		tm.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);
		tm.setCreateTime(new Date().getTime());
		tm.setFromUserName(parseRequest.get(MessageUtils.TO_USER_NAME));
		tm.setToUserName(parseRequest.get(MessageUtils.FROM_USER_NAME));
		

		return tm;
	}

	private String constrouctMessage(Attributes attributes) {
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n")
		.append("图片中人物的详细信息为：\r\n");
		sb.append(" 性别为：\n");
		if(attributes.getGender().getValue().equals("Male")) {
			sb.append("   男性，\n");
		}else {
			sb.append("   女性，\n");
		}
		sb.append(" 是否微笑：\n");
		if(attributes.getSmile().getValue()>attributes.getSmile().getThreshold()) {
			sb.append("   是,\n");
		}else {
			sb.append("   否,\n");
		}
		
		sb.append(" 是否佩戴眼镜：\n");
		if((attributes.getEyestatus().getLeft_eye_status().getNormal_glass_eye_close() > 50)
				||(attributes.getEyestatus().getRight_eye_status().getNormal_glass_eye_open()>50)) {
			
			sb.append("   是,\n");
		}else {
			sb.append("   否,\n");
		}
		sb.append(" 猜测的年龄：\n")
		.append("   "+attributes.getAge().getValue()+"\n");
		sb.append(" 所属人种：\n");
		sb.append("   "+attributes.getEthnicity().getValue() +"\n");
		sb.append(" 你的容貌得分：\n").append("   男性评分: " + attributes.getBeauty().getMale_score())
		.append("\n").append("   女性评分："+attributes.getBeauty().getFemale_score())
		.append("\n");
		return sb.toString();
	}

}
