package com.nt.weixinapp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.nt.weixinapp.message.respmessage.ArticleRespMessage;
import com.nt.weixinapp.message.respmessage.ImageRespMessage;
import com.nt.weixinapp.message.respmessage.MovieRespMessage;
import com.nt.weixinapp.message.respmessage.MusicRespMessage;
import com.nt.weixinapp.message.respmessage.TextRespMessage;
import com.nt.weixinapp.message.respmessage.VoiceRespMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class StringUtils {

	private static String token = "ninging";

	public static boolean checkParam(String signature, String timestamp, String nonce) {

		StringBuilder sb = new StringBuilder();

		String[] arr = { token, timestamp, nonce };

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		MessageDigest mg = null;
		String str = null;

		try {
			mg = MessageDigest.getInstance("SHA-1");
			byte[] digest = mg.digest(sb.toString().getBytes());
			str = byteToStr(digest);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str != null ? str.equals(signature.toUpperCase()) : false;
	}

	private static String byteToStr(byte[] byteArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			sb.append(byteToHexStr(byteArray[i]));
		}
		return sb.toString();
	}

	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}

}
