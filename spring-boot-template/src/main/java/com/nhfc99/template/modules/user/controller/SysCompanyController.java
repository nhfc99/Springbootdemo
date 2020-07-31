package com.nhfc99.template.modules.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nhfc99.template.modules.Base.BaseController;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.utils.PageUtils;
import com.nhfc99.template.utils.ToolUtils;
import com.nhfc99.template.vo.RequestPageVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.nhfc99.template.modules.user.service.ISysCompanyService;
import com.nhfc99.template.modules.user.entity.SysCompany;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * 公司信息
 * </p>
 *
 * @author nhf
 * @since 2020-07-31
 */
@Api(tags = "公司信息服务")
@RestController
@RequestMapping("/api/user/sysCompany")

public class SysCompanyController extends BaseController {

    @Resource
    private ISysCompanyService iSysCompanyService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Object create(@Valid @RequestBody SysCompany sysCompany) {
    iSysCompanyService.save(sysCompany);
        return JSONResult.result(0, "创建成功");
    }

    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestParam Integer id) {
        iSysCompanyService.removeById(id);
        return JSONResult.result(0, "删除成功");
    }

    @ApiOperation(value = "修改")
    @PostMapping("/modify")
    public Object modify(@Valid @RequestBody SysCompany sysCompany) {
        iSysCompanyService.updateById(sysCompany);
        return JSONResult.result(0, "修改成功");
    }

    @ApiOperation(value = "查询详情")
    @GetMapping("/detail")
    public Object detail(@RequestParam Integer id) {
        return iSysCompanyService.getById(id);
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/queryByPage")
    public Object queryByPage(@RequestBody SysCompany sysCompany, @RequestBody(required = false) RequestPageVo requestPageVo)
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //添加条件
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();
        //添加条件 -- 可以去掉添加自己的条件
        ToolUtils.queryWrapperEQ(sysCompany, queryWrapper);
        //queryWrapper.ge("age", 26);
        //判断是否分页
        if (requestPageVo != null) {
            Page<SysCompany> sysCompanyPage = new Page<>(requestPageVo.getPage(), requestPageVo.getPageSize(), false);
            IPage<SysCompany> iPage = iSysCompanyService.page(sysCompanyPage, queryWrapper);
            PageUtils pageUtils = new PageUtils(iPage.getRecords(), iPage.getTotal());
            return pageUtils;
        } else {
            return iSysCompanyService.list(queryWrapper);
        }
    }
}
