package com.nhfc99.template.modules.user.service;

import com.nhfc99.template.modules.user.entity.SysCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 公司信息 服务类
 * </p>
 *
 * @author nhf
 * @since 2020-07-31
 */
public interface ISysCompanyService extends IService<SysCompany> {
    /**
     *  分页获取
     */
    public IPage<SysCompany> selectPage(IPage<SysCompany> page, QueryWrapper queryWrapper);

    /**
     *  不分页获取数据
     */
    public List<SysCompany> selectList(QueryWrapper queryWrapper);
}
