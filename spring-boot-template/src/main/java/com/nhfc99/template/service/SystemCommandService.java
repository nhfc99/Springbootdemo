package com.nhfc99.template.service;

import com.nhfc99.template.dao.SystemcommandDomainMapper;
import com.nhfc99.template.domain.SystemcommandDomain;
import com.nhfc99.template.domain.VoicecommandDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SystemCommandService {

    @Autowired
    SystemcommandDomainMapper systemcommandDomainMapper;

    public ArrayList<SystemcommandDomain> selectAll() {
        return systemcommandDomainMapper.selectAll();
    }

    public ArrayList<SystemcommandDomain> selectBy(Long id, String value) {
        return systemcommandDomainMapper.selectBy(id, value);
    }

    public int insert(SystemcommandDomain record) {
        return systemcommandDomainMapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return systemcommandDomainMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(SystemcommandDomain record) {
        return systemcommandDomainMapper.updateByPrimaryKeySelective(record);
    }
}
