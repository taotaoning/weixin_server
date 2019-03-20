package com.nt.weixinapp.message.face.pojo;

public class Smile {

	private double value;
	private double threshold;
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	@Override
	public String toString() {
		return "Smile [value=" + value + ", threshold=" + threshold + "]";
	}
	
	
}
