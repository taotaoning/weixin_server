package com.nt.weixinapp.message.face.pojo;


public class FaceRespMessage {

	private String image_id;
	private String request_id;

	private String time_used;
	private FacesModel[] faces;

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getTime_used() {
		return time_used;
	}

	public void setTime_used(String time_used) {
		this.time_used = time_used;
	}

	public FacesModel[] getFaces() {
		return faces;
	}

	public void setFaces(FacesModel[] faces) {
		this.faces = faces;
	}



}
