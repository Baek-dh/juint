package edu.kh.app.member.model.service;

import edu.kh.app.member.model.vo.Member;

public interface MemberService {

	Member login(String inputId, String inputPw);
	
}
