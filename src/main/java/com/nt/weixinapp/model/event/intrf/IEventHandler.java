package com.nt.weixinapp.model.event.intrf;

import java.util.Map;

public interface IEventHandler {

	public abstract String handler(Map<String, String> parseRequest);
}
