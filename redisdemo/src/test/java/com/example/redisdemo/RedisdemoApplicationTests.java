package com.example.redisdemo;

import com.example.redisdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisdemoApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(RedisdemoApplicationTests.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String,Serializable> redisCacheTemplate;
	@Test
	public void contextLoads() {
		//测试线程安全
		ExecutorService executorService = Executors.newFixedThreadPool(1000);
		IntStream.range(0,1000).forEach(i ->
					executorService.execute(()-> stringRedisTemplate.opsForValue().increment("kk",1))
		);
		stringRedisTemplate.opsForValue().set("k1","v1");
		final String k1 = 	stringRedisTemplate.opsForValue().get("k1");
		log.info("[字符缓存结果]-[{}]",k1);
		String key = "redisDemo:user:1";
		redisCacheTemplate.opsForValue().set(key,new User(1L,"u1","pa"));
		final User user = (User) redisCacheTemplate.opsForValue().get(key);
		log.info("[对象缓存结果]-[{}]",user);


	}

}
