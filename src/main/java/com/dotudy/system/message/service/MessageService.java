package com.dotudy.system.message.service;

import java.util.Map;

import com.dotudy.business.system.label.model.Label;

public interface MessageService {
	public Map<String, Map<String, String>> selectMessages(Label labelParam);
}
