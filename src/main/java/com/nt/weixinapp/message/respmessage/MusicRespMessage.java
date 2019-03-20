package com.nt.weixinapp.message.respmessage;

import com.nt.weixinapp.message.pojo.Music;

public class MusicRespMessage extends BaseRespMessage {
	
	//回复的音乐消息类
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
