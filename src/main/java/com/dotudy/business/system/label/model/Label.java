package com.dotudy.business.system.label.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Label {
	// LabelCode
	String labelId;
	String labelCode;
	String status; // DB에 없음

	// LabelName
	String languageCode;
	String language;
	String labelName;
	
	// 공통
	String expireDateTime;
	String createUserId;
	String createModuleId;
	String createDateTime;
	String modifyUserId;
	String modifyModuleId;
	String modifyDateTime;
	
	// DTO
	List<Label> insert;
	List<Label> delete;
	List<Label> update;
	List<Label> labelCodeVO;
	List<Label> labelNameVO;
	
	// DAO
	List<Label> target;
}
