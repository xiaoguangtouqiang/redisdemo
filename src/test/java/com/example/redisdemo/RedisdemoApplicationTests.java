package com.example.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisdemoApplicationTests {

	@Autowired
	private HashOperations hashOperations;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHashOperation(){
		hashOperations.put("myHash", "age", "18");
		String o = (String)hashOperations.get("myHash", "age");
		System.out.println(o);
	}

}
