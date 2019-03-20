package com.nt.weixinapp.message.respmessage;

import com.nt.weixinapp.message.pojo.RoobotData;

public class RoobotResp extends RoobotBaseResp {

	private RoobotData data;
	public RoobotData getData() {
		return data;
	}
	public void setData(RoobotData data) {
		this.data = data;
	}
}
