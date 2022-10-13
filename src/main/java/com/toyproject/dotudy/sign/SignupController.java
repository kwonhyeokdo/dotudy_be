package com.toyproject.dotudy.sign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.dotudy.auth.phone.service.PhoneAuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	PhoneAuthService phoneAuthService;
	
	@GetMapping("/auth-number/수정수정")
	public String phone() {
		return phoneAuthService.getAuthNumber();
	}
}