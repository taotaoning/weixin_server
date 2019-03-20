package com.nt.weixinapp.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.message.respmessage.RoobotBaseResp;
import com.nt.weixinapp.message.respmessage.RoobotResp;

public class TextUtils {

	//聊天机器人请求地址
	private static final String roobotUrl = "http://open.drea.cc/chat/get?keyWord=KEYWORD&userName=drea_bbs";
	private static final Logger log = LoggerFactory.getLogger(TextUtils.class);
	
	public static boolean isQQFace(String content) {
		
		
		
		
		// 判断QQ表情的正则表达式
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher matcher = p.matcher(content);
		return matcher.matches();
		
	}
	
	public static String sendToChatRoobot(String content) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			String requestUrl = roobotUrl.replace("KEYWORD", java.net.URLEncoder.encode(content, "UTF-8"));
			String httpRequest = TokenUtiles.httpRequests(requestUrl, "GET", null);
			RoobotBaseResp fromJson = TokenUtiles.gson.fromJson(httpRequest, RoobotBaseResp.class);
			if(fromJson.isSuccess()) {
				RoobotResp fromJsons = TokenUtiles.gson.fromJson(httpRequest, RoobotResp.class);
				result = fromJsons.getData().getReply();
			}else {
				result = "小M不懂你的意思？";
			}
		} catch (UnsupportedEncodingException e) {
			log.error("编码请求失败！");
		}
		
		
		
		return result;
	}
}
