package com.nt.weixinapp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.nt.weixinapp.message.pojo.Article;
import com.nt.weixinapp.message.respmessage.ArticleRespMessage;
import com.nt.weixinapp.message.respmessage.ImageRespMessage;
import com.nt.weixinapp.message.respmessage.MovieRespMessage;
import com.nt.weixinapp.message.respmessage.MusicRespMessage;
import com.nt.weixinapp.message.respmessage.TextRespMessage;
import com.nt.weixinapp.message.respmessage.VoiceRespMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtils {

	//基本参数
	public static final String FROM_USER_NAME = "FromUserName";
	public static final String TO_USER_NAME = "ToUserName";
	public static final String MSGTYPE = "MsgType";
	public static final String CreateTime = "CreateTime";
	public static final String Event = "Event";
	public static final String EventKey = "EventKey";
	public static final String Content = "Content";
	public static final String MsgId = "MsgId";
	public static final String PicUrl = "PicUrl";
	public static final String MediaId = "MediaId";
	public static final String Format = "Format";
	public static final String Recognition = "Recognition";
	public static final String ThumbMediaId = "ThumbMediaId";
	public static final String Location_X = "Location_X";
	public static final String Location_Y = "Location_Y";
	public static final String Scale = "Scale";
	public static final String Title = "Title";
	public static final String Description = "Description";
	public static final String Url = "Url";
	
	
	// 返回消息类型
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	// 请求消息类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
	public static final String REQ_MESSAGE_TYPE_NEWS = "news";
	public static final String REQ_MESSAGE_TYPE_LOCALTION = "location";

	// 事件
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	// 事件类型
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	//自定义菜单事件
	public static final String EVENT_TYPE_CLICK = "CLICK";
	// 上报地理位置事件
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	//用户已关注时的事件推送 （用户扫描二维码时传递的信息）
	public static final String EVENT_TYPE_SCAN = "SCAN";

	// 使xstream在生成xml时 添加cdata 块
	private static XStream xstream = new XStream(new XppDriver() {
		public PrettyPrintWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}

	});

	// 解析请求消息
	public static Map<String, String> parseRequest(HttpServletRequest req) {

		HashMap<String, String> reqMap = new HashMap<String, String>();
		// 从请求的输入流中读取请求信息

		// 解析请求
		SAXReader reader = new SAXReader();
		InputStream reqIn = null;

		try {
			reqIn = req.getInputStream();
			Document doc = reader.read(reqIn);

			Element rootElement = doc.getRootElement();

			@SuppressWarnings("unchecked")
			List<Element> elements = rootElement.elements();

			for (Element element : elements) {

				reqMap.put(element.getName(), element.getText());
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				reqIn.close();
				reqIn = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reqMap;
	}

	/**
	 * 
	 * 将响应消息封装成xml类型
	 * 
	 */

	// 文本响应消息
	public static String textMessageToXML(TextRespMessage textMessage) {

		// 关联相关类
		xstream.alias("xml", textMessage.getClass());

		return xstream.toXML(textMessage);
	}

	// 图片响应消息
	public static String imageMessageToXML(ImageRespMessage imageMessage) {

		// 关联相关类
		xstream.alias("xml", imageMessage.getClass());

		return xstream.toXML(imageMessage);
	}

//语音响应消息
	public static String voiceMessageToXML(VoiceRespMessage voiceMessage) {

		// 关联相关类
		xstream.alias("xml", voiceMessage.getClass());

		return xstream.toXML(voiceMessage);
	}

//视频响应消息
	public static String movieMessageToXML(MovieRespMessage movieMessage) {

		// 关联相关类
		xstream.alias("xml", movieMessage.getClass());

		return xstream.toXML(movieMessage);
	}

//音乐响应消息
	public static String musicMessageToXML(MusicRespMessage musicMessage) {

		// 关联相关类
		xstream.alias("xml", musicMessage.getClass());

		return xstream.toXML(musicMessage);
	}

//图文响应消息
	public static String articleMessageToXML(ArticleRespMessage articleMessage) {

		// 关联相关类
		xstream.alias("xml", articleMessage.getClass());
		xstream.alias("item", new Article().getClass());

		return xstream.toXML(articleMessage);
	}

}
