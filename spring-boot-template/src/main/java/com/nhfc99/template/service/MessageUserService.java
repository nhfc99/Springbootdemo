package com.nhfc99.template.service;

import com.nhfc99.template.dao.MessageUserDomainMapper;
import com.nhfc99.template.domain.MessageUserDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageUserService {
    @Autowired
    MessageUserDomainMapper messageUserDomainMapper;

    public ArrayList<MessageUserDomain> selectAll() {
        return messageUserDomainMapper.selectAll();
    }

    public Object insert(@Param("messageUserDomain") MessageUserDomain messageUserDomain) {
        return messageUserDomainMapper.insert(messageUserDomain);
    }

    public Object delete(Long id) {
        return messageUserDomainMapper.deleteByPrimaryKey(id);
    }

    public MessageUserDomain selectByPrimaryKey(Long id) {
        return messageUserDomainMapper.selectByPrimaryKey(id);
    }

    public ArrayList<MessageUserDomain> selectByIds(ArrayList<Long> ids) {
        return messageUserDomainMapper.selectByIds(ids);
    }
}
