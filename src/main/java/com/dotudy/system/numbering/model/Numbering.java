package com.dotudy.system.numbering.model;

import java.util.List;

import com.dotudy.business.system.label.model.Label;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Numbering {
	// numbering
	String numberingId;
	String numberingModule;
	String prefix;
	String postfix;
	String value;
	
	// 공통
	String expireDateTime;
	String createUserId;
	String createModuleId;
	String createDateTime;
	String modifyUserId;
	String modifyModuleId;
	String modifyDateTime;
}
