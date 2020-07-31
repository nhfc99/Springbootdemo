package com.nhfc99.template.modules.user.service.impl;

import com.nhfc99.template.modules.user.entity.SysCompany;
import com.nhfc99.template.modules.user.mapper.SysCompanyMapper;
import com.nhfc99.template.modules.user.service.ISysCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公司信息 服务实现类
 * </p>
 *
 * @author nhf
 * @since 2020-07-31
 */
@Service
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements ISysCompanyService {
    @Resource
    private SysCompanyMapper sysCompanyMapper;
}
