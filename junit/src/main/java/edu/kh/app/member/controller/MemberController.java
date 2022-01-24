package edu.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kh.app.member.model.service.MemberService;
import edu.kh.app.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(String inputId, String inputPw, Model model) {
		
		Member loginMember = service.login(inputId, inputPw);
		
		String path = null;
		
		if(loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			path = "result";
		}else {
			path = "error";
		}
		
		return path;
	}
}
