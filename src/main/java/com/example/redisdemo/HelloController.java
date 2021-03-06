package com.example.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangDi on 18/7/17.
 */
@RestController
public class HelloController {

    @Autowired
    private ValueOperations valueOperations;

    @Autowired
    private HashOperations hashOperations;

    @RequestMapping("/hello")
    public String HelloWorld() {
        valueOperations.set("1223", "456");
        hashOperations.put("myHash", "name", "xiaosan");
        return "hello world";
    }

    @RequestMapping("/getkey")
    public String getKey() {
        String o = (String)hashOperations.get("myHash", "name");
        return o;
    }
}
