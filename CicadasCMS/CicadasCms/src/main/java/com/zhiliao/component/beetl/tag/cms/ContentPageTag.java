package com.zhiliao.component.beetl.tag.cms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhiliao.common.exception.CmsException;
import com.zhiliao.common.utils.CmsUtil;
import com.zhiliao.common.utils.StrUtil;
import com.zhiliao.module.web.cms.service.CategoryService;
import com.zhiliao.module.web.cms.service.ContentService;
import com.zhiliao.module.web.cms.service.SiteService;
import com.zhiliao.mybatis.model.TCmsCategory;
import com.zhiliao.mybatis.model.TCmsSite;
import org.beetl.core.GeneralVarTagBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:内容列表标签
 *
 * @author Jin
 * @create 2017-05-26
 **/
@Service
@Scope("prototype")
public class ContentPageTag extends GeneralVarTagBinding {


    @Autowired
    private SiteService siteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ContentService contentService;

    @Value("${system.site.subfix}")
    private String siteSubfix;

    @Value("${system.site.prefix}")
    private String sitePrefix;
    /**
     *
     * 内容分页标签
     *
     */
    @Override
    public void render() {
        if (CmsUtil.isNullOrEmpty(this.args[1]))
            throw  new CmsException("[内容分页标签]标签参数不能为空！");
        Integer siteId=  (this.getAttributeValue("siteId") instanceof String)?Integer.parseInt((String) this.getAttributeValue("siteId")):(Integer)this.getAttributeValue("siteId");
        if (CmsUtil.isNullOrEmpty(siteId))
            throw  new CmsException("[内容分页标签]站点id不能为空");
        if (!CmsUtil.isNullOrEmpty(this.getAttributeValue("categoryId"))) {
            Long categoryId=  (this.getAttributeValue("categoryId") instanceof String)?Long.parseLong((String) this.getAttributeValue("categoryId")):(Long) this.getAttributeValue("categoryId");
            Integer pageNumber= this.getAttributeValue("pageNumber")==null?1:(this.getAttributeValue("pageNumber") instanceof String)?Integer.parseInt((String) this.getAttributeValue("pageNumber")):(Integer) this.getAttributeValue("pageNumber");
            PageInfo<Map> page = contentService.page(pageNumber,siteId,categoryId);
            this.binds(page);
            this.doBodyRender();
            return;
        }
        PageInfo<Map> pageInfo = (PageInfo) this.getAttributeValue("page");
        if (CmsUtil.isNullOrEmpty(pageInfo))
            throw  new CmsException("[内容分页标签]此标签只能栏目页和栏目列表页使用");
        String titleLen = (String) this.getAttributeValue("titleLen");
        if (CmsUtil.isNullOrEmpty(pageInfo))
            throw  new CmsException("[内容分页标签]站点id不能为空");

        this.wrapRender(pageInfo.getList(),Integer.parseInt(titleLen),siteId);
    }

    private void wrapRender(List<Map>  contents, int titleLen, int siteId){
        HttpServletRequest request = (HttpServletRequest)ctx.getGlobal("request");
        String staticHtmlPath =  ctx.getGlobal("staticHtmlPath")==null?"":(String) ctx.getGlobal("staticHtmlPath");
        int i = 1;
        for (Map content : contents) {
            String title = content.get("title").toString();
            int length = title.length();
            if (length > titleLen) {
                content.put("title",title.substring(0, titleLen) + "...");
            }
            if (StrUtil.isBlank(content.get("url").toString())) {
                TCmsSite site = siteService.findById(siteId);
                if(CmsUtil.isNullOrEmpty(site)) throw new CmsException("站点不存在[siteId:"+siteId+"]");
                TCmsCategory category= categoryService.findById(Long.parseLong(content.get("categoryId").toString()));
                if(CmsUtil.isNullOrEmpty(category)) throw new CmsException("栏目不存在[categoryId:"+category.getCategoryId()+"]");
                String url = request.getContextPath() + staticHtmlPath +"/"+  site.getSiteKey()+"/";
                url+=category.getAlias()+"/"+content.get("contentId");
                content.put("url",url+siteSubfix);
            }
            content.put("index",i);
            this.binds(content);
            this.doBodyRender();
            i++;
        }
    }

}
