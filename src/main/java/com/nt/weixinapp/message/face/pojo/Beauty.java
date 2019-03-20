package com.nt.weixinapp.message.face.pojo;

public class Beauty {

	/*
	 * male_score：男性认为的此人脸颜值分数。值越大，颜值越高。 female_score：女性认为的此人脸颜值分数。值越大，颜值越高。
	 */
	
	private double male_score;
	private double female_score;
	public double getMale_score() {
		return male_score;
	}
	public void setMale_score(double male_score) {
		this.male_score = male_score;
	}
	public double getFemale_score() {
		return female_score;
	}
	public void setFemale_score(double female_score) {
		this.female_score = female_score;
	}
	@Override
	public String toString() {
		return "Beauty [male_score=" + male_score + ", female_score=" + female_score + "]";
	}
	
	
}
