package com.example.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();// 请使用valueSerializer
        byte[] channel = message.getChannel();
        // 请参考配置文件，本例中key，value的序列化方式均为string。
        // 其中key必须为stringSerializer。和redisTemplate.convertAndSend对应
        String msgContent = (String) redisTemplate.getValueSerializer().deserialize(body);
        String topic = (String) redisTemplate.getStringSerializer().deserialize(channel);
        System.out.println("topic:" + topic + "msgContent:" + msgContent);
    }
}
