package com.june.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.june.common.bean.User;
import com.june.mapper.Mapper1;

@Component
@Configuration
public class TestServiceImpl {

	@Autowired
	private Mapper1 mapper1;
	
	public List<User> getUsers() {
		PageHelper.startPage(1, 2);
		List<User> users=mapper1.getUser();		
		System.out.println(users);
		List<User> users2=mapper1.getUser();		
		System.out.println(users2);
		return users;
	}

}
