package com.nt.weixinapp.message.menu.pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.utils.MenuUtils;
import com.nt.weixinapp.utils.TokenUtiles;

public class MenuManager extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5503076040133264142L;

	private static final Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	private static final String APPID = "wx062990e4b039faee";
	
	private static final String APPSECRET = "c5791049e801335c46d163244496bb05";
	
	
	private static Menu getMenu() {
		
		CommonButton btn11 = new CommonButton();
		btn11.setName("天气预报");
		btn11.setType("click");
		btn11.setKey("11");
 
		CommonButton btn12 = new CommonButton();
		btn12.setName("公交查询");
		btn12.setType("click");
		btn12.setKey("12");
 
		CommonButton btn13 = new CommonButton();
		btn13.setName("周边搜索");
		btn13.setType("location_select");
		btn13.setKey("13");
 
		CommonButton btn14 = new CommonButton();
		btn14.setName("历史上的今天");
		btn14.setType("click");
		btn14.setKey("14");
 
		CommonButton btn21 = new CommonButton();
		btn21.setName("歌曲点播");
		btn21.setType("click");
		btn21.setKey("21");

		CommonButton btn22 = new CommonButton();
		btn22.setName("经典游戏");
		btn22.setType("click");
		btn22.setKey("22");
 
		CommonButton btn23 = new CommonButton();
		btn23.setName("美女电台");
		btn23.setType("click");
		btn23.setKey("23");
 
		CommonButton btn24 = new CommonButton();
		btn24.setName("人脸识别");
		btn24.setType("pic_weixin");
		btn24.setKey("24");
 
		CommonButton btn25 = new CommonButton();
		btn25.setName("聊天唠嗑");
		btn25.setType("click");
		btn25.setKey("25");

		CommonButton btn31 = new CommonButton();
		btn31.setName("Q友圈");
		btn31.setType("click");
		btn31.setKey("31");
 
		CommonButton btn32 = new CommonButton();
		btn32.setName("电影排行榜");
		btn32.setType("click");
		btn32.setKey("32");
 
		CommonButton btn33 = new CommonButton();
		btn33.setName("幽默笑话");
		btn33.setType("click");
		btn33.setKey("33");
 
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("生活助手");
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });
 
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("休闲驿站");
		mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("更多体验");
		mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });
 
		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButtons(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
 
		return menu;
		
	}
	
	@Override
	public void init() throws ServletException {
		
		AccessToken accessToken = TokenUtiles.getAccessToken(APPID, APPSECRET);
		
		int result = MenuUtils.createMenu(getMenu(), accessToken.getAccess_token());
		
		if(0 != result) {
			log.error("创建菜单失败 result = " + result);
		}else {
			log.info("创建菜单成功！！");
		}
		
		super.init();
	}
	
}
