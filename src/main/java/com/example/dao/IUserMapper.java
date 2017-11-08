package com.example.dao;

import java.util.List;
import java.util.Map;

public interface IUserMapper {

	Map<String, Object> query();
	
	List<Map<String, Object>> page();

}
