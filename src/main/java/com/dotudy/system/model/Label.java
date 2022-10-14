package com.dotudy.system.model;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Label {
	// LabelCode
	private String labelUid; // FE -> Grid ID용
	private String labelCode;
	
	// 공통
	private String createUserId;
	private String createModuleId;
	private Date createDateTime;
	private String modifyUserId;
	private String modifyModuleId;
	private Date modifyDateTime;
}
