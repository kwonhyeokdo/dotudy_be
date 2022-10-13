package com.dotudy.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotudy.system.model.Label;
import com.dotudy.system.service.LabelService;

@RestController
public class LabelController {
	@Autowired
	LabelService labelService;
	
	@GetMapping("/system/labels")
	public Label selectLabel(HttpServletRequest request) {
		Label label = labelService.selectLabelCode();
		return label;
	}
}
