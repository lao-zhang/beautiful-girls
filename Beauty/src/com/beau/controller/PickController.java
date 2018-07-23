package com.beau.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beau.mapper.BeautiesMapper;
import com.beau.pojo.Girls;
import com.beau.pojo.ListNode;
import com.beau.service.GirlsList;
import com.beau.service.MostBeautifulGirl;
import com.beau.service.ScoreChange;

@Controller
@RequestMapping("/")
public class PickController {
	
	//图片队列
	@Autowired
	GirlsList girlList ;
	//当前分数最高
	@Autowired
	MostBeautifulGirl most;
	//分数变动方法
	@Autowired
	ScoreChange change;
	//数据库方法集
	@Autowired
	BeautiesMapper mapper;
	
	
	
	//页面跳转流程：首页-> 选择图片队列长度->生成队列->「选择界面->下一张->选择界面->下一张->」（循环）->本次result
	//首页
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		Girls girl  = most.most();
		String src= girl.getSrc();
		System.out.println(src);
		mav.addObject("mostBeautiful",src);
		return mav;
	}
	//获取图片队列（链表）
	@RequestMapping(value="getList")
	public ModelAndView GirlList(@Valid  int num,HttpServletRequest request) throws IOException,ServletException{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		ListNode list = girlList.getList(num);
		Girls g1=mapper.find(list.val);
		list=list.next;
		Girls g2=mapper.find(list.val);
		list=list.next;
		session.setAttribute("ListNode", list);
		mav.addObject("no1",g1.getNo());
		mav.addObject("no2",g2.getNo());
		mav.addObject("src1",g1.getSrc());
		mav.addObject("src2",g2.getSrc());
		mav.setViewName("pickGirls");
		return mav;
	}
	//下一张
	//将存放图片队列的链表存进session，每次读取下一张之后将变化的链表替换进session。
	@RequestMapping(value="next")
	public ModelAndView next(HttpServletRequest request) throws IOException,ServletException{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		int win=Integer.parseInt(request.getParameter("win"));
		int lost= Integer.parseInt(request.getParameter("lost"));
		String whereChange=request.getParameter("change");
		Girls g1=mapper.find(win);
		Girls g2=new Girls();
		change.change(win, lost, 1, 0);
		ListNode list =(ListNode) session.getAttribute("ListNode");
		if(list.next!=null) {
			g2=mapper.find(list.next.val);
			list=list.next;
			session.setAttribute("ListNode", list);
			if(whereChange.equals("1")) {
				mav.addObject("no1",g2.getNo());
				mav.addObject("no2",g1.getNo());
				mav.addObject("src1",g2.getSrc());
				mav.addObject("src2",g1.getSrc());
			}else if(whereChange.equals("2")){
				mav.addObject("no1",g1.getNo());
				mav.addObject("no2",g2.getNo());
				mav.addObject("src1",g1.getSrc());
				mav.addObject("src2",g2.getSrc());
			}
			mav.setViewName("pickGirls");
		}
		else {
			//System.out.println("here is else");
			mav.addObject("src",g1.getSrc());
			//System.out.println(g1.getSrc());
			mav.setViewName("YourGirl");
		}
		return mav;
	}
}
