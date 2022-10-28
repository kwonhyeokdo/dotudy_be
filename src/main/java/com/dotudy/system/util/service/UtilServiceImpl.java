package com.dotudy.system.util.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotudy.system.util.repository.UtilRepository;

@Service("UtilService")
public class UtilServiceImpl implements UtilService {
	@Autowired
	UtilRepository utilRepository;
	
	@Override
	public String getCurrentDateTime() throws Exception {
		return utilRepository.selectCurrentDateTime();
	}

}
