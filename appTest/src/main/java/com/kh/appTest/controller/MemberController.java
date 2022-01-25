package com.kh.appTest.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.appTest.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(value="/beginSpring/memberRegister.action", method={RequestMethod.POST})
	public String memberRegisterEnd(HttpServletRequest request, Model model) {
	
		try {
	
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
	
			HashMap<String,String> paraMap = new HashMap<String,String>();
			paraMap.put("userid", userid);
			paraMap.put("passwd", passwd);
			paraMap.put("name", name);
			paraMap.put("email", email);
			paraMap.put("tel", tel);
		
			int n = service.memberRegister(paraMap);
			String result = "";
			if(n==1)
				result = "회원가입 성공!!";
			else
				result = "회원가입 실패!!";
			
			model.addAttribute("result", result);
			return "memberRegisterResult";
	
		} catch (Exception e) {
			model.addAttribute("error", "회원가입도중 오류가 발생하였습니다");
			return "error";
		}
	
	}	
}
