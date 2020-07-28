package com.nhfc99.template.service;

import com.nhfc99.template.dao.TunneltestfaultDomainMapper;
import com.nhfc99.template.domain.HomeQualityStatisticsAllAreaDomain;
import com.nhfc99.template.pojo.DataCalculatDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class HomeNService {
    @Autowired
    TunneltestfaultDomainMapper tunneltestfaultDomainMapper;
}
