package com.nt.weixinapp.servlet.servletservice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.utils.MessageUtils;
import com.nt.weixinapp.utils.TokenUtiles;

public class FaceService {

	private static final Logger log = LoggerFactory.getLogger(FaceService.class);
	private static final String faceUrl = "https://api-cn.faceplusplus.com/facepp/v3/detect";
	
	public static String httpRequest(Map<String,String> parseRequest) throws UnsupportedEncodingException {
		
		String PicUrl = parseRequest.get(MessageUtils.PicUrl);
		String makeFaceParam = makeFaceParam(PicUrl);
		String httpRequest = TokenUtiles.httpRequest(makeFaceParam, "POST", null);
		return httpRequest;
		
	}
	
	private static String makeFaceParam(String PicUrl) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(faceUrl)
			.append("?api_secret="+ URLEncoder.encode("Hf-tSrpIaAsY89IYb0XzW23j_uQ-tvfx", "UTF-8"))
			.append("&api_key="+ URLEncoder.encode("LCLEiDavsbh4u68d1IwmzPE_uOUcFwf0", "UTF-8"))
			.append("&image_url="+ PicUrl)
			.append("&return_attributes=glass,gender,age,smiling,eyestatus,emotion,ethnicity,beauty");
		
		} catch (UnsupportedEncodingException e) {
			log.error("构建请求参数失败 url = " + sb.toString());
		}
		
		

		return sb.toString();
	}
	
}
