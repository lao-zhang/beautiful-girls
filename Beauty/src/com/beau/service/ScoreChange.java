package com.beau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beau.mapper.BeautiesMapper;
import com.beau.pojo.Girls;


//分数变化，这里使用了《社交网络》里的公式
@Service
public class ScoreChange {
	@Autowired
	BeautiesMapper mapper ;
	public void change(int no1,int no2,int S1,int S2) {
		Girls girl1 = mapper.find(no1);
		Girls girl2 = mapper.find(no2);
		int score1= girl1.getScore();
		int score2= girl2.getScore();
		float E1=(float) (1/(1+Math.pow(10, (score2-score1)/400)));
		float E2=(float) (1/(1+Math.pow(10, (score1-score2)/400)));
		int newscore1 = (int)(score1+32*(S1-E1));
		int newscore2 = (int)(score2+32*(S2-E2));
		System.out.println( newscore1+","+newscore2);
		//score1=newscore1;
		//score2=newscore2;
		//mapper.ScoreChange(no1,no2,newscore1,newscore2);
		girl1.setScore(newscore1);
		girl2.setScore(newscore2);
		mapper.change(girl1);
		mapper.change(girl2);
	}

}
