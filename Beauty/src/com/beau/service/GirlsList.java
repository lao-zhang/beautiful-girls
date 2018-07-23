package com.beau.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beau.mapper.BeautiesMapper;
import com.beau.pojo.ListNode;


//图片队列生成
@Service
public class GirlsList {
	
	@Autowired
	BeautiesMapper mapper;
	
	public ListNode getList(int num) {
		ListNode node = new ListNode();
		ListNode result = node;
		Random rand = new Random();
		int max = mapper.Numbers();//用户选择观看的图片数量，也是下面随机图片队列的长度
		LinkedHashSet <Integer>s = new LinkedHashSet<>();//在最大图片数目的范围内生成随机no，然后此图入列（图片的no统一都是从1递增的）
		while(s.size()<num) {
			int i = rand.nextInt(max)+1;
			s.add(i);
		}
	//	System.out.println("set's size="+s.size());
		Iterator<Integer> iter = s.iterator();
		node.val=iter.next();
		while(iter.hasNext()) {
			node.next=new ListNode(iter.next());
			node=node.next;
		}
		return result;
	}

}
