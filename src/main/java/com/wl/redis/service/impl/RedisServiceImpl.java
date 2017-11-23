package com.wl.redis.service.impl;

import com.wl.redis.entity.City;
import com.wl.redis.service.RedisService;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/23-17:17
 */
public class RedisServiceImpl extends RedisService<City> {

    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
