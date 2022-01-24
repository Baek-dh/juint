package edu.kh.app.member.model.service;

import org.springframework.stereotype.Service;

import edu.kh.app.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public Member login(String inputId, String inputPw) {
		Member loginMember = null;
		
		if(inputId.equals("user01") && inputPw.equals("pass01!")) {
			loginMember = new Member();
			loginMember.setMemberId(inputId);
			loginMember.setMemberPw(inputPw);
			loginMember.setMemberName("유저일");
		}
		
		return loginMember;
	}

	
}
