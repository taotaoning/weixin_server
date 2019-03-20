package com.nt.weixinapp.message.face.pojo;

public class Emotion {

	/*
	 * anger：愤怒 disgust：厌恶 fear：恐惧 happiness：高兴 neutral：平静 sadness：伤心 surprise：惊讶
	 */

		private double anger;
		private double disgust;
		private double fear;
		private double happiness;
		private double neutral;
		private double sadness;
		private double surprise;
		public double getAnger() {
			return anger;
		}
		public void setAnger(double anger) {
			this.anger = anger;
		}
		public double getDisgust() {
			return disgust;
		}
		public void setDisgust(double disgust) {
			this.disgust = disgust;
		}
		public double getFear() {
			return fear;
		}
		public void setFear(double fear) {
			this.fear = fear;
		}
		public double getHappiness() {
			return happiness;
		}
		public void setHappiness(double happiness) {
			this.happiness = happiness;
		}
		public double getNeutral() {
			return neutral;
		}
		public void setNeutral(double neutral) {
			this.neutral = neutral;
		}
		public double getSadness() {
			return sadness;
		}
		public void setSadness(double sadness) {
			this.sadness = sadness;
		}
		public double getSurprise() {
			return surprise;
		}
		public void setSurprise(double surprise) {
			this.surprise = surprise;
		}
		@Override
		public String toString() {
			return "Emotion [anger=" + anger + ", disgust=" + disgust + ", fear=" + fear + ", happiness=" + happiness
					+ ", neutral=" + neutral + ", sadness=" + sadness + ", surprise=" + surprise + "]";
		}
		
		
	
}
