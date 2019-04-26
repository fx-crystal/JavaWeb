package com.tinzel.mapper;

import java.util.List;

import com.tinzel.pojo.BaseDict;

public interface BaseDictMapper {
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
