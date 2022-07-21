package com.toyproject.dotudy.auth.phone.serviceImp;

import org.springframework.stereotype.Service;

import com.toyproject.dotudy.auth.phone.service.PhoneAuthService;

@Service
public class PhoneAuthServiceImp implements PhoneAuthService {
	private final int RANDOM_DIGIT = 6;
	@Override
	public String getAuthNumber() {
		// 인증번호 발생
		String authNumber = createAuthNumber();
		
		// DB에 인증번호 저장
		
		return authNumber;
	}
	
	private String createAuthNumber() {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < RANDOM_DIGIT; i++) {
			sb.append((int)(Math.random() * 9));
		}
		
		return sb.toString();
	}
}
