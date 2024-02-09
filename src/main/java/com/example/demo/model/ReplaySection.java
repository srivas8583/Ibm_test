package com.example.demo.model;

public class ReplaySection {

	    private String videoId;
	    private int startSecond;
	    private int endSecond;
		public String getVideoId() {
			return videoId;
		}
		public void setVideoId(String videoId) {
			this.videoId = videoId;
		}
		public int getStartSecond() {
			return startSecond;
		}
		public void setStartSecond(int startSecond) {
			this.startSecond = startSecond;
		}
		public int getEndSecond() {
			return endSecond;
		}
		public void setEndSecond(int endSecond) {
			this.endSecond = endSecond;
		}
		public ReplaySection(String videoId, int startSecond, int endSecond) {
			super();
			this.videoId = videoId;
			this.startSecond = startSecond;
			this.endSecond = endSecond;
		}
	    
	    

}
