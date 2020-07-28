package com.nhfc99.template.service;

import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.dao.DeviceipinfoDomainMapper;
import com.nhfc99.template.domain.DeviceipinfoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeviceipinfoService {
    @Autowired
    DeviceipinfoDomainMapper deviceipinfoDomainMapper;

    @Autowired
    RedisUtil redisUtil;

    public int insert(DeviceipinfoDomain deviceipinfoDomain) {
        int count = deviceipinfoDomainMapper.insertSelective(deviceipinfoDomain);
        if (count > 0) {
            redisUtil.set(deviceipinfoDomain.getIp(), deviceipinfoDomain.getName());
        }
        return count;
    }

    public DeviceipinfoDomain selectByName(String name) {
        DeviceipinfoDomain deviceipinfoDomain = deviceipinfoDomainMapper.selectByName(name);
        return deviceipinfoDomain;
    }

    public ArrayList<DeviceipinfoDomain> selectAll() {
        return deviceipinfoDomainMapper.selectAll();
    }

    public int update(DeviceipinfoDomain deviceipinfoDomain) {
        int count = deviceipinfoDomainMapper.updateByPrimaryKey(deviceipinfoDomain);
        if (count > 0) {
            redisUtil.del(deviceipinfoDomain.getIp());
            redisUtil.set(deviceipinfoDomain.getIp(), deviceipinfoDomain.getName());
        }
        return count;
    }

    public int delete(Long id) {
        int count = deviceipinfoDomainMapper.deleteByPrimaryKey(Math.toIntExact(id));
        if (count > 0) {
            DeviceipinfoDomain deviceipinfoDomain = deviceipinfoDomainMapper.selectByPrimaryKey(Math.toIntExact(id));
            redisUtil.del(deviceipinfoDomain.getIp());
        }
        return count;
    }
}
