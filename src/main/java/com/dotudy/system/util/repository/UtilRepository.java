package com.dotudy.system.util.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UtilRepository {
	public String selectCurrentDateTime() throws Exception;
}
