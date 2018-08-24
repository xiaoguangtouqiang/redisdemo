package com.example.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * redis发布消息
     *
     * @param channel
     * @param message
     */
    public void sendMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
