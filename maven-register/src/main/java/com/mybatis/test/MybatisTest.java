package com.mybatis.test;

import java.io.Reader;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.Tuser;

public class MybatisTest {

	private SqlSessionFactory ssf;
	private SqlSession ss;
	private UserMapper um;
	
	@Before
	public void fn1() {
		try {
			Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			ss = ssf.openSession();
			um = ss.getMapper(UserMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
	    Tuser t = new Tuser();
 		System.out.println(um.listall(""));
	}
	
	@After
	public void after() {
		ss.commit();
		ss.close();
	}
	
}
