package com.beau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beau.mapper.BeautiesMapper;
import com.beau.pojo.Girls;

//当前全局分数最高
@Service
public class MostBeautifulGirl {
	@Autowired
	BeautiesMapper mapper;
	
	public Girls most() {
		Girls girl = new Girls();
		girl = mapper.findMax();
		return girl;
	}
}
