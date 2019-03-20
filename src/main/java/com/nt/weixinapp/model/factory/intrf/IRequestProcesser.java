package com.nt.weixinapp.model.factory.intrf;

import java.util.Map;

public interface IRequestProcesser {

	public abstract String handle(Map<String,String> parseRequest);
}
