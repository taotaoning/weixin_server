package com.nt.weixinapp.model.factory.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.weixinapp.message.pojo.Article;
import com.nt.weixinapp.message.respmessage.ArticleRespMessage;
import com.nt.weixinapp.model.factory.intrf.IMessageProcesser;
import com.nt.weixinapp.utils.MessageUtils;
import com.nt.weixinapp.utils.TextUtils;

public class TextProcesser implements IMessageProcesser {

	private static final Logger LOGGER = LoggerFactory.getLogger(TextProcesser.class);

	@Override
	public String handle(Map<String, String> parseRequest) {

		String content = parseRequest.get("Content");

		// 聊天机器人

		// 表情响应（文本响应）
		if (TextUtils.isQQFace(content)) {
			return content;
		}
		// 图文响应
		else if ("1".equals(content)) {

			ArticleRespMessage articleResp = articleProcess(parseRequest);

			return MessageUtils.articleMessageToXML(articleResp);

		} else {
			String sendToChatRoobot = TextUtils.sendToChatRoobot(content);
			return sendToChatRoobot;
		}
	}

	private ArticleRespMessage articleProcess(Map<String, String> parseRequest) {

		Article article = new Article();
		article.setDescription("这是一个图文响应!!");
		article.setPicUrl("http://gmay63.natappfree.cc/weixinapp/images/wife.jpg");
		article.setUrl("http://mp.weixin.qq.com");
		article.setTitle("王八蛋！！");

		List<Article> list = new ArrayList<>();
		list.add(article);

		ArticleRespMessage articleResp = new ArticleRespMessage();
		articleResp.setArticles(list);
		articleResp.setArticleCount(list.size());
		articleResp.setCreateTime(new Date().getTime());
		articleResp.setFromUserName(parseRequest.get("ToUserName"));
		articleResp.setToUserName(parseRequest.get("FromUserName"));
		articleResp.setFuncFlag(0);
		articleResp.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_NEWS);

		return articleResp;
	}

	// 图文响应图片地址
	private String getPath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

		String replaceAll = path.replaceAll("WEB-INF/classes/", "images/wifee.jpg");
		System.out.println("path = " + replaceAll);

		return replaceAll;
	}

}
