package com.example.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
	Map<String, Object> query();
	
	List<Map<String, Object>> page();
}
