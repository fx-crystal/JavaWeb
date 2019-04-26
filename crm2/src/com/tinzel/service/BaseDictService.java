package com.tinzel.service;

import java.util.List;

import com.tinzel.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictListByCode(String code);
}
