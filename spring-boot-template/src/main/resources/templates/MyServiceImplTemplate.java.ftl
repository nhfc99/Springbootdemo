package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Resource
    private ${table.mapperName} ${table.mapperName ? uncap_first};

    /**
     *  分页获取
     */
    public IPage<${entity}> selectPage(IPage<${entity}> page, QueryWrapper queryWrapper) {
        return ${table.mapperName ? uncap_first}.selectPage(page, queryWrapper);
    }

    /**
     *  不分页获取数据
     */
    public List<${entity}> selectList(QueryWrapper queryWrapper) {
        return ${table.mapperName ? uncap_first}.selectList(queryWrapper);
    }
}
</#if>
