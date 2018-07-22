package com.beau.mapper;

import com.beau.pojo.Girls;

public interface BeautiesMapper {

		public void add (Girls girl);
		
		public Girls find(int no);
		
		public Girls findMax();
		
		public int Numbers();
		
		public void ScoreChange(int no1,int no2,int score1,int score2);
		
		public void change(Girls girl);

}
