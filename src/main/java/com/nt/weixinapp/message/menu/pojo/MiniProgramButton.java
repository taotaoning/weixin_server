package com.nt.weixinapp.message.menu.pojo;

public class MiniProgramButton extends Button {

	/*
	 * { "type":"miniprogram", "name":"wxa", "url":"http://mp.weixin.qq.com",
	 * "appid":"wx286b93c14bbf93aa", "pagepath":"pages/lunar/index" },
	 * 
	 */
	private String type;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	private String url;
	private String appid;
	private String pagepath;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
