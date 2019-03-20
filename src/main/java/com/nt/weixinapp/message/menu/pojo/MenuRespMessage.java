package com.nt.weixinapp.message.menu.pojo;

public class MenuRespMessage {

	private int errorcode;
	private String errmsg;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "MenuRespMessage [errorcode=" + errorcode + ", errmsg=" + errmsg + "]";
	}
	
}
