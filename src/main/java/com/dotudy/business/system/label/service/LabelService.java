package com.dotudy.business.system.label.service;

import java.util.List;

import com.dotudy.business.system.label.model.Label;

public interface LabelService {
	public Label selectLabel(String labelCode, String labelName) throws Exception;
	public boolean saveLabelCode(List<Label> insertLabelCodeList, List<Label> deleteLabelCodeList, List<Label> updateLabelCodeList) throws Exception;
}
