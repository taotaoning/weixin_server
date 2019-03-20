package com.nt.weixinapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.message.reqmessage.TextMessage;
import com.nt.weixinapp.message.respmessage.BaseRespMessage;
import com.nt.weixinapp.message.respmessage.TextRespMessage;
import com.nt.weixinapp.servlet.servletservice.CoreService;
import com.nt.weixinapp.utils.MessageUtils;
import com.nt.weixinapp.utils.StringUtils;


public class WeiXingServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5570438116228945603L;

	private static final Logger log = LoggerFactory.getLogger(WeiXingServlet.class);
	/**
	 * 
	 */

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		PrintWriter writer = resp.getWriter();
		
		boolean checkParam = StringUtils.checkParam(signature, timestamp, nonce);
		if(checkParam) {
			writer.print(echostr);
		}else {
			log.error("配置接口url失败，错误信息：signature = " + signature +",timestamp = " + timestamp + ",nonce = " + nonce + ",echostr = " + echostr);
		}
		writer.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码集
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String respMessage = CoreService.processRequest(req);
		
		PrintWriter writer = resp.getWriter();
		/**
		 * 转换为xml
		 */
		
		writer.println(respMessage);
		writer.close();
		
		
		
	}

	
	
}
