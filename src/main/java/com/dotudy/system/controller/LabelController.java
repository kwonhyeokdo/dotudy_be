package com.dotudy.system.controller;

import java.util.List;

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
	public List<Label> selectLabel(HttpServletRequest request) {
		List<Label> labelList = labelService.selectLabelCode();
		return labelList;
	}
}
