package com.dotudy.business.system.label.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotudy.business.system.label.model.Label;
import com.dotudy.business.system.label.service.LabelService;

@RestController
public class LabelController {
	@Autowired
	LabelService labelService;
	
	@GetMapping("/system/label")
	public Label selectLabelCode(
		HttpServletRequest request,
		@RequestParam(value="labelCode", required=false) String labelCode,
		@RequestParam(value="labelName", required=false) String labelName
	) throws Exception {
		return labelService.selectLabel(labelCode, labelName);
	}
	
	@PostMapping("/system/labelCode")
	public boolean saveLabelCode(
		HttpServletRequest request,
		@RequestBody Label labelCodeDto
	) throws Exception {
		List<Label> insertLabelCodeList = labelCodeDto.getInsert();
		List<Label> deleteLabelCodeList = labelCodeDto.getDelete();
		List<Label> updateLabelCodeList = labelCodeDto.getUpdate();
		
		return labelService.saveLabelCode(insertLabelCodeList, deleteLabelCodeList, updateLabelCodeList);
	}
}
