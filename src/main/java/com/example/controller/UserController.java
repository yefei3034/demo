package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.bean.User;
import com.example.service.impl.UserServiceImpl;
import com.example.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Value("${com.name}")
	private String name;
	
	@Autowired
	private RedisUtil jedis;
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/{name}")
	@ResponseBody
	public User view(@PathVariable("name") String name)
	{
		User user = new User();
		user.setName(name);
		user.setSex(1);
		return user;
	}
	
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> testQuery(HttpServletRequest request, HttpServletResponse response)
	{
		log.info("name={}",name);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map=  userService.query();
		map.put("value", name);
		return map;
	}
	
	@RequestMapping(value ="/jedis", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String getKey(HttpSession session)
	{
		jedis.set(name, System.currentTimeMillis()+"");
		
		session.setAttribute("session", session.getId());
		System.out.println("sessionId="+session.getId());
		return jedis.get(name);
	}
	
	@RequestMapping(value="/freemarker/welcome", method={RequestMethod.GET})
	public ModelAndView freemarker(Model map)
	{
		map.addAttribute("name", name);
		return new  ModelAndView("hello");
	}
	
	
}
