package com.nhfc99.duty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.SdutyDOMapper;
import com.nhfc99.duty.model.SdutyDO;

@Service
public class SdutyService {
    @Autowired
    SdutyDOMapper sdutyDOMapper;

    public List<SdutyDO> selectAll() {
        return sdutyDOMapper.selectAll();
    }
}
