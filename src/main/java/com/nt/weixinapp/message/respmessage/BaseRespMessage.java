package com.nt.weixinapp.message.respmessage;

public class BaseRespMessage {
	// 接收者id（收到的openid）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间
	private long CreateTime;
	// 消息类型（text/music/news)
	private String MsgType;
	// 位 0x0001被标记时，星标最新收到的消息
	private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

	public BaseRespMessage(String toUserName, String fromUserName, long createTime, String msgType, int funcFlag) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		FuncFlag = funcFlag;
	}

	public BaseRespMessage() {
		super();
	}

}
