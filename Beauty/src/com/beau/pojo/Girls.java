package com.beau.pojo;


//图片
public class Girls {
	
	private int No;
	private String src;
	private int score;
	
	public Girls() {
		
	}
	
	public Girls(int No,String src,int score) {
		this.No = No;
		this.src = src;
		this.score = score;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
