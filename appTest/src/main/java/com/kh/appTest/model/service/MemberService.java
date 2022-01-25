package com.kh.appTest.model.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service("service")
public class MemberService {

	public int memberRegister(HashMap<String, String> paraMap) {
		return 1; // 무조건 회원 가입
	}

}
