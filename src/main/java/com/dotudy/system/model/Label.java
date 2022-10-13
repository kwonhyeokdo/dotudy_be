package com.dotudy.system.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Label {
	private String labelCode;
	
	// 공통
	private String createUserId;
	private String createModuleId;
	private Date createDateTime;
	private String modifyUserId;
	private String modifyModuleId;
	private Date modifyDateTime;
}
