package com.nt.weixinapp.message.respmessage;

public class VoiceRespMessage extends BaseRespMessage {
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
