package com.example.service.impl;

import java.util.List;
import java.util.Map;

import com.example.dao.IUserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserMapper userMapper;

	@Override
	public Map<String, Object> query()
	{
		return userMapper.query();
	}

	@Override
	public List<Map<String, Object>> page() {
		//只有紧跟在 PageHelper.startPage 方法后的第一个 MyBatis 的查询(select)方法会被分页
		PageHelper.startPage(1, 10);
		return userMapper.page();
	}
}
