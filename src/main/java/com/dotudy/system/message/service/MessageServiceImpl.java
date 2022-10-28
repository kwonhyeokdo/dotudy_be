package com.dotudy.system.message.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotudy.business.system.label.model.Label;
import com.dotudy.system.message.repository.MessageRepository;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public Map<String, Map<String, String>> selectMessages(Label labelParam) {
		List<Label> messageList = messageRepository.selectMessages(labelParam);
		
		Map<String, Map<String, String>> resultMap = new HashMap<>();
		
		for(Label label : messageList) {
			String languageCode = label.getLanguageCode();
			String labelCode = label.getLabelCode();
			String labelName = label.getLabelName();
			
			Map<String, String>codeNameMap = null;
			if(resultMap.containsKey(languageCode)) {
				codeNameMap = resultMap.get(languageCode);
			}else {
				codeNameMap = new HashMap<>();
			}
			codeNameMap.put(labelCode, labelName);
			resultMap.put(languageCode, codeNameMap);
		}
		
		return resultMap;
	}

}
