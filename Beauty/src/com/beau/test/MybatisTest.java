package com.beau.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beau.mapper.BeautiesMapper;
import com.beau.pojo.Girls;
import com.beau.service.ScoreChange;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:MyapplicationContext.xml")
public class MybatisTest {
	@Autowired
	private BeautiesMapper mapper;
	@Autowired
	ScoreChange change;
	
	//@Test
	public void add() {
		String url="/Users/zhangxuan/Pictures/妹子/";
		for(int i=1;i<=10;i++) {
			String src=url+i+".jpg";
			mapper.add(new Girls(i,src,1400));
		}
	}
	//@Test
	public void testfind() { 
		Girls girl = mapper.findMax();
		System.out.println(girl.getSrc());
	}
	
	@Test
	public void change() {
		change.change(3, 4, 1, 0);
	}

}
