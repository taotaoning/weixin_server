package com.nt.weixinapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.nt.weixinapp.message.menu.pojo.Menu;
import com.nt.weixinapp.message.menu.pojo.MenuRespMessage;

public class MenuUtils {

	private static final Logger log = LoggerFactory.getLogger(MessageUtils.class);
	private static final Gson gson = new Gson();
	private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	
	//创建菜单  0 成功   1 失败
	public static int createMenu(Menu menu, String accessToken) {
		
		int result = 0;
		//拼装创建菜单的url
		String menu_url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		
		//将菜单对象转换为json格式
		String json = gson.toJson(menu);
		
		//发送创建菜单请求
		String menu_resp = TokenUtiles.httpRequest(menu_url, "POST", json);
		
		MenuRespMessage menuResp = gson.fromJson(menu_resp, MenuRespMessage.class);
		
		if( null != menuResp) {
			if(0 != menuResp.getErrorcode()) {
				result = menuResp.getErrorcode();
				log.error("菜单创建失败 error msg ",menuResp.toString());
			}
		}
		
		return result;
		
	}
	
	
}
