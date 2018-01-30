package com.mybatis.mapper;

import com.mybatis.pojo.Tuser;

public interface UserMapper {

	public void save(Tuser tuser);
	
	public Tuser listall(String name);
	
}
