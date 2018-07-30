package com.example.mybaitsdemo;

import com.example.mybaitsdemo.entity.User;
import com.example.mybaitsdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybaitsdemoApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(MybaitsdemoApplicationTests.class);
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		final int row1 = userMapper.insert(new User(1l,"u1", "p1"));
		log.info("[添加结果] - [{}]", row1);
		final int row2 = userMapper.insert(new User(2l,"u2", "p2"));
		log.info("[添加结果] - [{}]", row2);
		final int row3 = userMapper.insert(new User(3l,"u1", "p3"));
		log.info("[添加结果] - [{}]", row3);
		final List<User> u1 = userMapper.findByUsername("u1");
		log.info("[根据用户名查询] - [{}]", u1);

	}

}
