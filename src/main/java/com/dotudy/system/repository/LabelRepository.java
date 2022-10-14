package com.dotudy.system.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dotudy.system.model.Label;

@Mapper
public interface LabelRepository {
	public List<Label> selectLabelCode();
}
