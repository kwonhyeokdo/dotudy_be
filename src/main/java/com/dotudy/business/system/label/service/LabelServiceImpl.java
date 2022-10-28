package com.dotudy.business.system.label.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.dotudy.business.system.label.model.Label;
import com.dotudy.business.system.label.repository.LabelRepository;
import com.dotudy.system.util.service.UtilService;

@Service("LabelService")
public class LabelServiceImpl implements LabelService {
	@Autowired
	private LabelRepository labelRepository;
	@Autowired
	private UtilService utilService;

	@Value("${expire_date_time}")
	private String expireDateTime;

	@Override
	public Label selectLabel(String labelCode, String labelName) throws Exception {
		Label result = Label.builder().build();
		List<Label> resultCode = null;
		List<Label> resultName = new ArrayList<>();
		if(!labelCode.isEmpty() && !labelName.isEmpty()) {
			resultCode = labelRepository.selectLabelCodeByLabelCodeAndLabelName(labelCode, labelName);
		}else if(!labelCode.isEmpty() && labelName.isEmpty()) {
			resultCode = labelRepository.selectLabelCodeByLabelCode(labelCode);
		}else if(labelCode.isEmpty() && !labelName.isEmpty()) {
			resultCode = labelRepository.selectLabelCodeByLabelName(labelName);
		}else {
			resultCode = labelRepository.selectAllLabelCode();
		}
		
		if(resultCode != null && resultCode.size() > 0) {
			String labelId = resultCode.get(0).getLabelId();
			resultName = labelRepository.selectLabelNameByLabelId(labelId);
		}
		
		result.setLabelCodeVO(resultCode);
		result.setLabelNameVO(resultName);
		
		return result;
	}

	@Override
	public boolean saveLabelCode(List<Label> insertLabelCodeList, List<Label> deleteLabelCodeList,
			List<Label> updateLabelCodeList) throws Exception {
		// Delete
		deleteLabelCode(deleteLabelCodeList);
		// Update
		updateLabelCode(updateLabelCodeList);
		// Insert
		insertLabelCode(insertLabelCodeList);

		return true;
	}

	private void deleteLabelCode(List<Label> deleteLabelCodeList) throws Exception {
		if (deleteLabelCodeList.isEmpty()) {
			return;
		}

		String userId = "혁도";
		String moduleId = "labelCode";
		String currentDateTime = utilService.getCurrentDateTime();
		Label labelDao = Label.builder()
				.expireDateTime(currentDateTime)
				.target(deleteLabelCodeList)
				.modifyUserId(userId)
				.modifyModuleId(moduleId)
				.modifyDateTime(currentDateTime)
				.build();

		labelRepository.expireLabelCode(labelDao);
		labelRepository.expireLabelName(labelDao);
	}

	public void updateLabelCode(List<Label> updateLabelCodeList) throws Exception {
		if (updateLabelCodeList.isEmpty()) {
			return;
		}

		String userId = "혁도";
		String moduleId = "labelCode";
		String currentDateTime = utilService.getCurrentDateTime();
		Label labelDao = Label.builder()
				.expireDateTime(currentDateTime)
				.target(updateLabelCodeList)
				.createUserId(userId)
				.createModuleId(moduleId)
				.createDateTime(currentDateTime)
				.modifyUserId(userId)
				.modifyModuleId(moduleId)
				.modifyDateTime(currentDateTime)
				.build();

		labelRepository.expireLabelCode(labelDao);
		labelDao.setExpireDateTime(expireDateTime);
		labelRepository.insertLabelCode(labelDao);
	}

	private void insertLabelCode(List<Label> insertLabelCodeList) throws Exception {
		if (insertLabelCodeList.isEmpty()) {
			return;
		}

		String userId = "혁도";
		String moduleId = "labelCode";
		String currentDateTime = utilService.getCurrentDateTime();
		Label labelDao = Label.builder()
				.expireDateTime(expireDateTime)
				.target(insertLabelCodeList)
				.createUserId(userId)
				.createModuleId(moduleId)
				.createDateTime(currentDateTime)
				.modifyUserId(userId)
				.modifyModuleId(moduleId)
				.modifyDateTime(currentDateTime).build();

		labelRepository.insertLabelCode(labelDao);
	}
}
