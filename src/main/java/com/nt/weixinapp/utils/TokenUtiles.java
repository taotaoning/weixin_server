package com.nt.weixinapp.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.nt.weixinapp.message.menu.pojo.AccessToken;
import com.nt.weixinapp.message.menu.ssl.WeiXinX509TrustManager;

public class TokenUtiles {

	private static final Logger log = LoggerFactory.getLogger(TokenUtiles.class);
	
	public static final Gson gson = new Gson();
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public static AccessToken getAccessToken(String appId, String appsecret) {
		
		AccessToken token = null;
		
		String tokenUrl = ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appsecret);
		System.out.println(tokenUrl);
		String access_json = httpRequest(tokenUrl,"GET",null);
		
		if(access_json != null) {
			token = gson.fromJson(access_json, AccessToken.class);
		}
		else {
			log.error("token get is error");
		}
		
		return token;
		
	}

	//https请求
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		
		StringBuilder sb = new StringBuilder();
		try {
			
			SSLContext ssl = SSLContext.getInstance("SSL");
			TrustManager[] tm = {new WeiXinX509TrustManager()};
			ssl.init(null, tm , new java.security.SecureRandom());
			SSLSocketFactory socketFactory = ssl.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpsRequest = (HttpsURLConnection)url.openConnection();
			httpsRequest.setSSLSocketFactory(socketFactory);
			httpsRequest.setDoInput(true);
			httpsRequest.setDoOutput(true);
			httpsRequest.setUseCaches(false);
			//设置请求方式
			httpsRequest.setRequestMethod(requestMethod);
			httpsRequest.connect();
			//当有数据需要提交时
			if(outputStr != null) {
		
				OutputStream outputStream = httpsRequest.getOutputStream();
				//防止中文乱码
				outputStream.write(outputStr.getBytes("utf-8"));
				outputStream.close();
			}
			
			InputStream in  = httpsRequest.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			String str = null;
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
			
			in.close();
			isr.close();
			br.close();
			httpsRequest.disconnect();
			log.info("------------"+sb.toString());
			
			
		
		} catch (ConnectException e) {
			log.error("access_token connection error");
			
		} catch (Exception e) {
			log.error("httpRequest is error : error code is " , sb.toString());
		}
		return sb.toString();
	}
	
	//http请求
	public static String httpRequests(String requestUrl, String requestMethod, String outputStr) {
		
		StringBuilder sb = new StringBuilder();
		try {
			
			
			URL url = new URL(requestUrl);
			HttpURLConnection httpsRequest = (HttpURLConnection)url.openConnection();
			httpsRequest.setDoInput(true);
			httpsRequest.setDoOutput(true);
			httpsRequest.setUseCaches(false);
			//设置请求方式
			httpsRequest.setRequestMethod(requestMethod);
			httpsRequest.connect();
			//当有数据需要提交时
			if(outputStr != null) {
		
				OutputStream outputStream = httpsRequest.getOutputStream();
				//防止中文乱码
				outputStream.write(outputStr.getBytes("utf-8"));
				outputStream.close();
			}
			
			InputStream in  = httpsRequest.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			String str = null;
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
			
			in.close();
			isr.close();
			br.close();
			httpsRequest.disconnect();
			
			
		
		} catch (ConnectException e) {
			log.error("access_token connection error");
			
		} catch (Exception e) {
			log.error("httpRequest is error : error code is " , sb.toString());
		}
		return sb.toString();
	}

	
}
