package com.nt.weixinapp.message.face.pojo;

public class Attributes implements Comparable<Attributes> {

	// 性别 Male Female
	private Gender gender;

	// 年龄
	private Age age;

	/**
	 * 笑容分析结果。返回值包含以下属性：
	 * 
	 * value：值为一个 [0,100] 的浮点数，小数点后3位有效数字。数值越大表示笑程度高。 threshold：代表笑容的阈值，超过该阈值认为有笑容。
	 */
	// gender,age,eyestatus,emotion,ethnicity,beauty,smile

	private Smile smile;
	private Emotion emotion;
	private Eyestatus eyestatus;

	private Ethnicity ethnicity;
	private Beauty beauty;

	@Override
	public String toString() {
		return "Face [gender=" + gender + ", age=" + age + ", smile=" + smile + ", emotion=" + emotion + ", eyestatus="
				+ eyestatus + ", ethnicity=" + ethnicity + ", beauty=" + beauty + "]";
	}

	public Smile getSmile() {
		return smile;
	}

	public void setSmile(Smile smile) {
		this.smile = smile;
	}

	public Emotion getEmotion() {
		return emotion;
	}

	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}

	public Eyestatus getEyestatus() {
		return eyestatus;
	}

	public void setEyestatus(Eyestatus eyestatus) {
		this.eyestatus = eyestatus;
	}

	public Ethnicity getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Beauty getBeauty() {
		return beauty;
	}

	public void setBeauty(Beauty beauty) {
		this.beauty = beauty;
	}

	@Override
	public int compareTo(Attributes o) {

		if (o.getBeauty().getFemale_score() * o.getBeauty().getMale_score() + o.getSmile().getThreshold()
				* o.getSmile().getValue() == this.getSmile().getThreshold() * this.getSmile().getValue()
						+ this.getBeauty().getFemale_score() * this.getBeauty().getMale_score()) {
			return 0;
		}

		return -1;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

}
