package com.example.repetitioncommitdemotwo;

import com.example.repetitioncommitdemotwo.interceptor.CacheKeyGenerator;
import com.example.repetitioncommitdemotwo.interceptor.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RepetitionCommitDemoTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepetitionCommitDemoTwoApplication.class, args);
	}

	@Bean
	public CacheKeyGenerator cacheKeyGenerator(){
		return new LockKeyGenerator();
	}
}
