package com.dotudy.system.message.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dotudy.business.system.label.model.Label;

@Mapper
public interface MessageRepository {
	public List<Label> selectMessages(Label labelParam);
}