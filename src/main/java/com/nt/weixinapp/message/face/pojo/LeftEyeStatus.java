package com.nt.weixinapp.message.face.pojo;

public class LeftEyeStatus {

	/*
	occlusion：眼睛被遮挡的置信度
	no_glass_eye_open：不戴眼镜且睁眼的置信度
	normal_glass_eye_close：佩戴普通眼镜且闭眼的置信度
	normal_glass_eye_open：佩戴普通眼镜且睁眼的置信度
	dark_glasses：佩戴墨镜的置信度
	no_glass_eye_close：不戴眼镜且闭眼的置信度
	*/
	private double occlusion;
	private double no_glass_eye_open;
	private double normal_glass_eye_close;
	private double normal_glass_eye_open;
	private double dark_glasses;
	private double no_glass_eye_close;
	public double getOcclusion() {
		return occlusion;
	}
	public void setOcclusion(double occlusion) {
		this.occlusion = occlusion;
	}
	public double getNo_glass_eye_open() {
		return no_glass_eye_open;
	}
	public void setNo_glass_eye_open(double no_glass_eye_open) {
		this.no_glass_eye_open = no_glass_eye_open;
	}
	public double getNormal_glass_eye_close() {
		return normal_glass_eye_close;
	}
	public void setNormal_glass_eye_close(double normal_glass_eye_close) {
		this.normal_glass_eye_close = normal_glass_eye_close;
	}
	public double getNormal_glass_eye_open() {
		return normal_glass_eye_open;
	}
	public void setNormal_glass_eye_open(double normal_glass_eye_open) {
		this.normal_glass_eye_open = normal_glass_eye_open;
	}
	public double getDark_glasses() {
		return dark_glasses;
	}
	public void setDark_glasses(double dark_glasses) {
		this.dark_glasses = dark_glasses;
	}
	public double getNo_glass_eye_close() {
		return no_glass_eye_close;
	}
	public void setNo_glass_eye_close(double no_glass_eye_close) {
		this.no_glass_eye_close = no_glass_eye_close;
	}
	@Override
	public String toString() {
		return "LeftEyeStatus [occlusion=" + occlusion + ", no_glass_eye_open=" + no_glass_eye_open
				+ ", normal_glass_eye_close=" + normal_glass_eye_close + ", normal_glass_eye_open="
				+ normal_glass_eye_open + ", dark_glasses=" + dark_glasses + ", no_glass_eye_close="
				+ no_glass_eye_close + "]";
	}
	
	
}
