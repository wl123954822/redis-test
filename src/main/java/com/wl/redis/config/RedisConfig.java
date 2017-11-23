package com.wl.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/23-16:46
 */
@Configuration
public class RedisConfig {

    /**
     * 注入RedisConnectionFactory
     */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * 实例化 RedisTemplate对象
     */
    @Bean
    public RedisTemplate<String,Object> functionDomainRedisTemplate(){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate,redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis的序列化方式
     */
    private void initDomainRedisTemplate(RedisTemplate<String,Object> redisTemplate, RedisConnectionFactory factory){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * 实例化 HashOperations 对象，可以使用Hash类型操作
     */
    @Bean
    public HashOperations<String,String,Object> hashOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForHash();
    }

    /**
     * 实例化ListOperations 对象，可以用List类型操作
     */
    @Bean
    public ListOperations<String,Object> listOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForList();
    }

    /**
     * 实例化 ValueOperations 对象，可以用String类型操作
     */
    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForValue();
    }

    /**
     * 实例化 SetOperations 对象，可以用set类型操作
     */
    @Bean
    public SetOperations<String,Object> setOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForSet();
    }
    /**
     * 实例化 ZSetOperations 对象，可以用ZSet操作
     */
    @Bean
    public ZSetOperations<String,Object> zSetOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }

}
