package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    /**
     *  分页获取
     */
    public IPage<${entity}> selectPage(IPage<${entity}> page, QueryWrapper queryWrapper);

    /**
     *  不分页获取数据
     */
    public List<${entity}> selectList(QueryWrapper queryWrapper);
}
</#if>
