package com.zhiliao.component.beetl.tag.cms;

import com.google.common.collect.Maps;
import com.zhiliao.common.exception.CmsException;
import com.zhiliao.common.utils.CmsUtil;
import com.zhiliao.common.utils.StrUtil;
import com.zhiliao.module.web.cms.service.CategoryService;
import com.zhiliao.module.web.cms.service.SiteService;
import com.zhiliao.mybatis.model.TCmsCategory;
import com.zhiliao.mybatis.model.TCmsSite;
import org.beetl.core.GeneralVarTagBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description:内容列表标签
 *
 * @author Jin
 * @create 2017-05-26
 **/
@Service
@Scope("prototype")
public class CategoryTag extends GeneralVarTagBinding {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SiteService siteService;

    @Value("${system.http.protocol}")
    private String httpProtocol;

    @Value("${system.http.host}")
    private String httpHost;

    @Value("${system.site.prefix}")
    private String sitePrefix;

    @Value("${system.site.subfix}")
    private String siteSubfix;

    @Override
    public void render() {
        HttpServletRequest request = (HttpServletRequest) ctx.getGlobal("request");
        Map result = Maps.newHashMap();
        Long categoryId = (this.getAttributeValue("categoryId") instanceof String) ? Long.parseLong((String) this.getAttributeValue("categoryId")) : (Long) this.getAttributeValue("categoryId");
        Integer isParent = (this.getAttributeValue("isParent") instanceof String) ? Integer.parseInt((String) this.getAttributeValue("isParent")) : (Integer) this.getAttributeValue("categoryId");
        TCmsCategory category = categoryService.findById(categoryId);
        TCmsSite site = siteService.findById(category.getSiteId());
        String staticHtmlPath = ctx.getGlobal("staticHtmlPath") == null ? "" : (String) ctx.getGlobal("staticHtmlPath");
        if (CmsUtil.isNullOrEmpty(category))
            throw new CmsException("栏目[" + categoryId + "]不存在！");
        if (isParent == 1 && category.getParentId() != 0)
            category = categoryService.findById(category.getParentId());
        result.put("categoryId", category.getCategoryId());
        result.put("categoryIcon", category.getCategoryIcon());
        result.put("categoryName", category.getCategoryName());
        result.put("content", category.getContent());
        result.put("url", !StrUtil.isBlank(category.getUrl()) ? category.getUrl() : request.getContextPath() + staticHtmlPath + "/" + site.getSiteKey() + "/" + category.getAlias() + siteSubfix);
        result.put("more", !StrUtil.isBlank(category.getUrl()) ? category.getUrl() : request.getContextPath() + staticHtmlPath + "/" + category.getAlias() + "/index_1" + siteSubfix);
        result.put("prototype", category);
        this.binds(result);
        this.doBodyRender();
    }

}
