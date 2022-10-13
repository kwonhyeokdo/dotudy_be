package com.dotudy.system.repository;

import org.apache.ibatis.annotations.Mapper;

import com.dotudy.system.model.Label;

@Mapper
public interface LabelRepository {
	public Label selectLabelCode();
}
