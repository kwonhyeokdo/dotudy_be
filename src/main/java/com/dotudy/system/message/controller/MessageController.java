package com.dotudy.system.message.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotudy.business.system.label.model.Label;
import com.dotudy.system.message.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	MessageService messageService;
	
	@GetMapping("/system/messages")
	public Map<String, Map<String, String>> getMessages(
		HttpServletRequest request,
		@RequestParam(value="languageCode", defaultValue="") String languageCode
	) throws Exception{
		Label labelParam = Label.builder().languageCode(languageCode).build();
		return messageService.selectMessages(labelParam);
	}
}
