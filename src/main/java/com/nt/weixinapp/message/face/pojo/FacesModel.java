package com.nt.weixinapp.message.face.pojo;

public class FacesModel {

	private String face_token;
	private Attributes attributes;
	private FaceRectangle face_rectangle;

	public String getFace_token() {
		return face_token;
	}
	public void setFace_token(String face_token) {
		this.face_token = face_token;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public FaceRectangle getFace_rectangle() {
		return face_rectangle;
	}
	public void setFace_rectangle(FaceRectangle face_rectangle) {
		this.face_rectangle = face_rectangle;
	}

	
	
}
