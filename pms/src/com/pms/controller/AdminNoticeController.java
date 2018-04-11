package com.pms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Admin;
import com.pms.pojo.Notice;
import com.pms.service.NoticeService;

@Controller
@RequestMapping(value = "adminNotice")
public class AdminNoticeController {

	@Resource(name = "noticeService")
	NoticeService noticeService;
	
	/**
	 * 发布新公告
	 * @param request
	 * @param session
	 * @return noticeAdd.jsp
	 */
	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	public String addNotice(HttpServletRequest request, HttpSession session){
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		if(noticeTitle.equals("")){
        	request.setAttribute("noticeError", "标题不能为空!");
			System.out.println("标题不能为空");
			return "/admin/noticeAdd";
        }
		if(noticeContent.equals("")){
        	request.setAttribute("noticeError", "内容不能为空!");
			System.out.println("内容不能为空");
			return "/admin/noticeAdd";
        }
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String stime = df.format(new Date());// new Date()为获取当前系统时间
		Date noticeTime = null;
		try {
			noticeTime = df.parse(stime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int adminId =  ((Admin)session.getAttribute("user")).getAdminId();
		String adminName = ((Admin)session.getAttribute("user")).getAdminName();
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeTime(noticeTime);
		notice.setAdminId(adminId);
		notice.setAdminName(adminName);
		
		int flag = noticeService.insertByNoId(notice);
		
		if(flag == 1){
			System.out.println("发布成功！");
			return "/admin/noticeAdd";
		}else{
			System.out.println("发布失败！");
			return "/admin/noticeAdd";
		}
	}
	
	/**
	 * 获取所有公告
	 * @return noticeSearch.jsp
	 */
	@RequestMapping(value = "getAllNotice")
	public ModelAndView getAllNotice(){
		ModelAndView noticeMV = new ModelAndView();  
        List<Notice> noticeList = noticeService.getAllNotice();
        
//        System.out.println(	noticeList.size());
		if(noticeList.isEmpty()){
//			System.out.println("空空如也");
		}else{
//			System.out.println("有点东西");
		}
        
        noticeMV.addObject("noticeList",noticeList);  
        noticeMV.setViewName("/admin/noticeSearch");  
        return noticeMV;
	}
	
	/**
	 * 公告详情
	 * @param noticeId 公告ID
	 * @return noticeShowAndDelete.jsp
	 */
	@RequestMapping("/showNotice/{noticeId}")
	public ModelAndView showNoticeById(@PathVariable String noticeId) {
//		System.out.println("notice id 是：" + noticeId);
		
		Notice notice = noticeService.getByPrimaryKey(Integer.valueOf(noticeId));
		
		if(notice != null){
//			System.out.println("AdminNoticeController.showNoticeById() 有notice记录");
			ModelAndView noticeMV = new ModelAndView();  
			noticeMV.addObject("notice", notice);  
	        noticeMV.setViewName("/admin/noticeShowAndDelete");  
	        return noticeMV;
		}else{
			return null;
		}
	}
	
	@RequestMapping("/deleteNotice/{noticeId}")
	public String deleteNoticeById(@PathVariable String noticeId) {
		
		int deleteNotice = noticeService.deleteByPrimaryKey(Integer.valueOf(noticeId));
		
		if(deleteNotice == 1){
			System.out.println("删除成功！");
			return "redirect:/adminNotice/getAllNotice";  
		}else{
			return null;
		}
	}
}
