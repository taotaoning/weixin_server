package com.nt.weixinapp.message.respmessage;

import java.util.List;

import com.nt.weixinapp.message.pojo.Article;

public class ArticleRespMessage extends BaseRespMessage {

	// 图文消息个数限制为1条以内
	private int ArticleCount;

	// 图文消息信息,注意，如果图文数超过1，则将只发第1条
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	
}
