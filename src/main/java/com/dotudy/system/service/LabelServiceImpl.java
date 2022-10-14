package com.dotudy.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotudy.system.model.Label;
import com.dotudy.system.repository.LabelRepository;

@Service("LabelService")
public class LabelServiceImpl implements LabelService {
	@Autowired
	LabelRepository labelRepository;
	
	@Override
	public List<Label> selectLabelCode(){
		return labelRepository.selectLabelCode();
	}
}
