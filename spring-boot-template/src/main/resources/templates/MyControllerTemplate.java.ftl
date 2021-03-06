package ${package.Controller};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Api(tags = "${table.comment!}服务")
@RestController
@RequestMapping("/api<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")

<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${table.serviceName ? uncap_first};

    @ApiOperation("创建")
    @PostMapping("/create")
    public Object create(@Valid @RequestBody ${entity} ${entity ? uncap_first}) {
    ${table.serviceName ? uncap_first}.save(${entity ? uncap_first});
        return JSONResult.result(0, "创建成功");
    }

    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestParam Integer id) {
        ${table.serviceName ? uncap_first}.removeById(id);
        return JSONResult.result(0, "删除成功");
    }

    @ApiOperation(value = "修改")
    @PostMapping("/modify")
    public Object modify(@Valid @RequestBody ${entity} ${entity ? uncap_first}) {
        ${table.serviceName ? uncap_first}.updateById(${entity ? uncap_first});
        return JSONResult.result(0, "修改成功");
    }

    @ApiOperation(value = "查询详情")
    @GetMapping("/detail")
    public Object detail(@RequestParam Integer id) {
        return ${table.serviceName ? uncap_first}.getById(id);
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/queryByPage")
    public Object queryByPage(@RequestBody ${entity} ${entity ? uncap_first}, @RequestBody(required = false) RequestPageVo requestPageVo)
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //添加条件
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        //添加条件 -- 可以去掉添加自己的条件
        ToolUtils.queryWrapperEQ(${entity ? uncap_first}, queryWrapper);
        //queryWrapper.ge("age", 26);
        //判断是否分页
        if (requestPageVo != null) {
            Page<${entity}> sysCompanyPage = new Page<>(requestPageVo.getPage(), requestPageVo.getPageSize(), false);
            IPage<${entity}> iPage = ${table.serviceName ? uncap_first}.page(sysCompanyPage, queryWrapper);
            PageUtils pageUtils = new PageUtils(iPage.getRecords(), iPage.getTotal());
            return pageUtils;
        } else {
            return ${table.serviceName ? uncap_first}.list(queryWrapper);
        }
    }
}
