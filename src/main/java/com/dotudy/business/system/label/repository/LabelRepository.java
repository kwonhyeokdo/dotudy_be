package com.dotudy.business.system.label.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dotudy.business.system.label.model.Label;

@Mapper
public interface LabelRepository {
	public List<Label> selectLabelCodeByLabelCodeAndLabelName(String labelCode, String labelName) throws Exception;
	public List<Label> selectLabelCodeByLabelCode(String labelCode) throws Exception;
	public List<Label> selectLabelCodeByLabelName(String labelName) throws Exception;
	public List<Label> selectAllLabelCode() throws Exception;
	public List<Label> selectLabelNameByLabelId(String labelId) throws Exception;
	public void expireLabelCode(Label labelDao) throws Exception;
	public void insertLabelCode(Label labelDao) throws Exception;
	public void expireLabelName(Label labelDao) throws Exception;
}
