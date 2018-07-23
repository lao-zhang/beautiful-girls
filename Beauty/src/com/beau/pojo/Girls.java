package com.beau.pojo;


//图片信息
public class Girls {
	
	private int No;    //图片id，在数据库中可充当主键   
	private String src;//图片存放路径	
	private int score;//分数
	
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
