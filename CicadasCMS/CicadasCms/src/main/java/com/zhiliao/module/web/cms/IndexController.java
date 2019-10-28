package com.zhiliao.module.web.cms;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.zhiliao.common.constant.CmsConst;
import com.zhiliao.common.exception.CmsException;
import com.zhiliao.common.utils.CmsUtil;
import com.zhiliao.common.utils.ControllerUtil;
import com.zhiliao.common.utils.HtmlKit;
import com.zhiliao.common.utils.StrUtil;
import com.zhiliao.component.beetl.thread.HtmlThread;
import com.zhiliao.module.web.cms.service.*;
import com.zhiliao.mybatis.model.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Description:前台首页
 *
 * @author Jin
 * @create 2017-04-13
 **/
@Controller
@RequestMapping("/")
public class IndexController {

    private final static Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private SiteService siteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelFiledService modelFiledService;

    @Autowired
    private LuceneService luceneService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private AdService adService;

    @Value("${system.site.prefix}")
    private String sitePrefix;

    @Value("${system.site.subfix}")
    private String siteSubfix;

    @Value("${system.site.static}")
    private String siteStatic;

    @Value("${system.site.page.size}")
    private String pageSize;

    @Value("${system.site.static.path}")
    String staticPath;

    /*网站首页*/
    @GetMapping
    public ModelAndView index(@RequestParam(value = "keyword",required = false) String keyword){
        String domain = ControllerUtil.getDomain();
        log.debug("通过域名访问网站首页[{}]",domain);
        TCmsSite site = siteService.findByDomain(domain);
        if(CmsUtil.isNullOrEmpty(site))
            site = siteService.findById(1);
        if(!StrUtil.isBlank(keyword))
            return new ModelAndView( "forward:/"+sitePrefix+"/search");
        return new ModelAndView( "forward:/"+sitePrefix+"/"+site.getSiteId());
    }

    /*网站首页*/
    @GetMapping("/index{siteSubfix}")
    public ModelAndView index(){
        TCmsSite site = siteService.findById(1);
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        return new ModelAndView( "forward:/"+sitePrefix+"/"+site.getSiteId());
    }

    /*网站首页*/
    @GetMapping("/${system.site.prefix}/{siteId}/index{siteSubfix}")
    public ModelAndView index(@PathVariable("siteId") String siteId,@RequestParam(value = "keyword",required = false) String keyword){
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        if(!StrUtil.isBlank(keyword))
            return new ModelAndView( "forward:/"+sitePrefix+"/search");
        return new ModelAndView( "forward:/"+sitePrefix+"/"+site.getSiteKey());
    }

    /**
     * 站点首页
     * @param siteId
     * @param model
     * @return
     */
    @GetMapping("/${system.site.prefix}/{siteId}")
    public String index(@PathVariable("siteId") String siteId,
                        Model model){
        log.debug("通过站点Id访问网站首页[{}]",siteId);
        /*判断是否开启静态*/
        File file = new File(staticPath+File.separator +"html"+ File.separator+ siteId + File.separator+"index.html");
        if (file.exists() && Boolean.parseBoolean(siteStatic)&& HtmlThread.size()<=0&&!ControllerUtil.isMobile())
            return "redirect:/html/"+ siteId + "/index.html";
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        if(!site.getStatus())
            throw new CmsException(CmsConst.SITE_LOCKED);
        model.addAttribute("title",site.getTitle());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(CmsConst.INDEX_TPL);
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(), CmsConst.INDEX_TPL);
    }

    /**
     * 站点首页
     * @param siteId
     * @param model
     * @return
     */
    @GetMapping("/{siteId}/index${system.site.subfix}")
    public String indexNoPrefix(@PathVariable("siteId") String siteId,
                                Model model){
        log.debug("通过站点Id访问网站首页[{}]",siteId);
        /*判断是否开启静态*/
        File file = new File(staticPath+File.separator +"html"+ File.separator+ siteId + File.separator+"index.html");
        if (file.exists() && Boolean.parseBoolean(siteStatic)&& HtmlThread.size()<=0&&!ControllerUtil.isMobile())
            return "redirect:/html/"+ siteId + "/index.html";
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        if(!site.getStatus())
            throw new CmsException(CmsConst.SITE_LOCKED);
        model.addAttribute("title",site.getTitle());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(CmsConst.INDEX_TPL);
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(), CmsConst.INDEX_TPL);
    }


    @GetMapping("/${system.site.prefix}/{siteId}/{categoryId}")
    public String category(@PathVariable("siteId") String siteId,
                           @PathVariable("categoryId") String categoryId,
                           @RequestParam(value = "ajaxRender",required = false) String  ajaxRender,
                           Model model){
        log.debug("栏目");
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        PageInfo page = contentService.page(1,site.getSiteId(),category.getCategoryId());
        model.addAttribute("title",category.getCategoryName());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(category.getIndexTpl());
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getIndexTpl(),ajaxRender);
    }

    @GetMapping("/{siteId}/{categoryId}${system.site.subfix}")
    public String categoryNoPrefix(@PathVariable("siteId") String siteId,
                           @PathVariable("categoryId") String categoryId,
                           @RequestParam(value = "ajaxRender",required = false) String  ajaxRender,
                           Model model){
        log.debug("栏目");
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        PageInfo page = contentService.page(1,site.getSiteId(),category.getCategoryId());
        model.addAttribute("title",category.getCategoryName());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(category.getIndexTpl());
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getIndexTpl(),ajaxRender);
    }

    /*网站栏目列表页*/
    @GetMapping("/${system.site.prefix}/{siteId}/{categoryId}/index_{pageNumber}")
    public String page(@PathVariable("siteId") String siteId,
                             @PathVariable("categoryId") String categoryId,
                             @PathVariable(value = "pageNumber") Integer pageNumber,
                             @RequestParam(value = "ajaxRender",required = false) String  ajaxRender,
                             Model model){
        log.debug("列表");
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        if(CmsUtil.isNullOrEmpty(pageNumber))
            throw new CmsException(CmsConst.PAGE_NOT_FOUND);
        PageInfo page = contentService.page(pageNumber,site.getSiteId(),category.getCategoryId());
        model.addAttribute("title",category.getCategoryName());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(category.getListTpl());
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getListTpl(),ajaxRender);
    }

    /*网站栏目列表页*/
    @GetMapping("/{siteId}/{categoryId}/index_{pageNumber}${system.site.subfix}")
    public String pageNoPrefix(@PathVariable("siteId") String siteId,
                       @PathVariable("categoryId") String categoryId,
                       @PathVariable(value = "pageNumber") Integer pageNumber,
                       @RequestParam(value = "ajaxRender",required = false) String  ajaxRender,
                       Model model){
        log.debug("列表");
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        if(CmsUtil.isNullOrEmpty(pageNumber))
            throw new CmsException(CmsConst.PAGE_NOT_FOUND);
        PageInfo page = contentService.page(pageNumber,site.getSiteId(),category.getCategoryId());
        model.addAttribute("title",category.getCategoryName());
        model.addAttribute("keyword",site.getKeyword());
        model.addAttribute("description",site.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        if(StrUtil.isBlank(site.getTemplate()))
            return view(category.getListTpl());
        return view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getListTpl(),ajaxRender);
    }

    /*网站内容页*/
    @GetMapping("/${system.site.prefix}/{siteId}/{categoryId}/{contentId}")
    public String content(@PathVariable("siteId") String siteId,
                                @PathVariable("categoryId") String categoryId,
                                @PathVariable("contentId") Long contentId,
                                 Model model){
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        TCmsModel contentModel = modelService.findById(category.getModelId());
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.PAGE_NOT_FOUND);
        Map content = contentService.findContentByContentIdAndTableName(contentId,contentModel.getTableName());
        if(CmsUtil.isNullOrEmpty(content))
            throw new CmsException(CmsConst.CONTENT_NOT_FOUND);
        contentService.viewUpdate(contentId);
        model.addAttribute("title",content.get("title"));
        model.addAttribute("keyword",content.get("keywords"));
        model.addAttribute("description",content.get("description"));
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("content",content);
        if(StrUtil.isBlank(site.getTemplate()))
            return this.view(category.getContentTpl());
        return this.view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getContentTpl());
    }

    /*网站内容页*/
    @GetMapping("/{siteId}/{categoryId}/{contentId}${system.site.subfix}")
    public String contentNoPrefix(@PathVariable("siteId") String siteId,
                          @PathVariable("categoryId") String categoryId,
                          @PathVariable("contentId") Long contentId,
                          Model model){
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsCategory category= null;
        if(StringUtils.isNumeric(categoryId)) {
            category = categoryService.findById(Long.parseLong(categoryId));
        }else {
            category = categoryService.findByAlias(categoryId);
        }
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
        TCmsModel contentModel = modelService.findById(category.getModelId());
        if(CmsUtil.isNullOrEmpty(category))
            throw new CmsException(CmsConst.PAGE_NOT_FOUND);
        Map content = contentService.findContentByContentIdAndTableName(contentId,contentModel.getTableName());
        if(CmsUtil.isNullOrEmpty(content))
            throw new CmsException(CmsConst.CONTENT_NOT_FOUND);
        contentService.viewUpdate(contentId);
        model.addAttribute("title",content.get("title"));
        model.addAttribute("keyword",content.get("keywords"));
        model.addAttribute("description",content.get("description"));
        model.addAttribute("site",site);
        model.addAttribute("category",category);
        model.addAttribute("content",content);
        if(StrUtil.isBlank(site.getTemplate()))
            return this.view(category.getContentTpl());
        return this.view((ControllerUtil.isMobile()&&site.getIsMobile())?site.getMobileTpl():site.getTemplate(),category.getContentTpl());
    }

    /*全文检索和模型字段检索*/
    @RequestMapping("/search")
    public String search(@RequestParam(value = "keyword",required = false) String keyword,
                         @RequestParam(value = "m",defaultValue = "0") Integer modelId,
                         @RequestParam(value = "s",defaultValue = "0") Integer siteId,
                         @RequestParam(value = "c",defaultValue = "0") Long catId,
                         @RequestParam(value = "p",defaultValue = "1") Integer pageNumber,
                         HttpServletRequest request){
        log.debug("搜索");
        TCmsSite site = siteService.findById(siteId);
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        if (modelId > 0 && catId > 0) {
            String action = request.getContextPath() +"/"+sitePrefix+"/"+site.getSiteId();
            action += "/search?m=" + modelId + "&c=" + catId;
            TCmsCategory category = categoryService.findById(catId);
            if(CmsUtil.isNullOrEmpty(category))
                throw new CmsException(CmsConst.CATEGORY_NOT_FOUND);
            TCmsModel model = modelService.findById(modelId);
            Map<String, Object> param = Maps.newHashMap();
            List<TCmsModelFiled> modelFileds = modelFiledService.findModelFiledListByModelId(modelId);
            /* 循环检索获取filedName和fildValue*/
            for (TCmsModelFiled filed : modelFileds) {
                String filedValue = request.getParameter(filed.getFiledName());
                if (!StrUtil.isBlank(filedValue)) {
                    param.put(HtmlKit.getText(filed.getFiledName()).trim(), HtmlKit.getText(filedValue).trim());
                    action += "&" + filed.getFiledName() + "=" + filedValue;
                }
            }
            PageInfo page = contentService.findContentListByModelFiledValue(pageNumber,catId,model.getTableName(), param);
            request.setAttribute("title",category.getCategoryName());
            request.setAttribute("keyword",site.getKeyword());
            request.setAttribute("description",site.getDescription());
            request.setAttribute("site", site);
            request.setAttribute("category", category);
            request.setAttribute("page", page);
            request.setAttribute("param", param);
            request.setAttribute("action", action);
            return view(site.getTemplate(), category.getListTpl());
        }else{
            String action = request.getContextPath() +"/"+sitePrefix+"/"+site.getSiteId();
            if(StrUtil.isBlank(keyword))
                throw new CmsException(CmsConst.SEARCH_KEYWORD_NOT_FOUND);
            action +="/search?keyword="+keyword;
            PageInfo page =luceneService.page(pageNumber,Integer.parseInt(this.pageSize),keyword);
            request.setAttribute("page",page);
            request.setAttribute("site",site);
            request.setAttribute("action", action);
            request.setAttribute("keyword", keyword);
            return view(site.getTemplate(), CmsConst.SEARCH_TPL);
        }
    }

    /*专题*/
    @GetMapping("/${system.site.prefix}/{siteId}/topic/{topicId}")
    public String topic(@PathVariable("siteId") String siteId,
                        @PathVariable("topicId") Integer topicId,
                        Model model){
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsTopic topic =topicService.findById(topicId);
        if(CmsUtil.isNullOrEmpty(topic))
            throw new CmsException(CmsConst.TOPIC_NOT_FOUND);
        model.addAttribute("title",topic.getTopicName());
        model.addAttribute("keyword",topic.getKeywords());
        model.addAttribute("description",topic.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("topic",topic);
        return view(site.getTemplate(), !StrUtil.isBlank(topic.getTopicTpl())?topic.getTopicTpl(): CmsConst.TOPIC_TPL);
    }

    /*专题*/
    @GetMapping("/{siteId}/topic/{topicId}${system.site.subfix}")
    public String topicNoPrefix(@PathVariable("siteId") String siteId,
                        @PathVariable("topicId") Integer topicId,
                        Model model){
        TCmsSite site = null;
        if(StringUtils.isNumeric(siteId)) {
            site = siteService.findById(Integer.parseInt(siteId));
        }else {
            site = siteService.findBySiteKey(siteId.toLowerCase());
        }
        if(CmsUtil.isNullOrEmpty(site))
            throw new CmsException(CmsConst.SITE_NOT_FOUND);
        TCmsTopic topic =topicService.findById(topicId);
        if(CmsUtil.isNullOrEmpty(topic))
            throw new CmsException(CmsConst.TOPIC_NOT_FOUND);
        model.addAttribute("title",topic.getTopicName());
        model.addAttribute("keyword",topic.getKeywords());
        model.addAttribute("description",topic.getDescription());
        model.addAttribute("site",site);
        model.addAttribute("topic",topic);
        return view(site.getTemplate(), !StrUtil.isBlank(topic.getTopicTpl())?topic.getTopicTpl(): CmsConst.TOPIC_TPL);
    }

    @RequestMapping(value = "/ad/js/{id}",produces = "text/javascript; charset=UTF-8")
    @ResponseBody
    public String AdJs(@PathVariable Integer id){
        if(CmsUtil.isNullOrEmpty(id))
            throw new CmsException("广告不存在！");
        return adService.toJavascript(id);
    }


    private String view(String viewName){
        return  this.view("default",viewName);
    }

    private static String view(String theme,String viewName,String ajaxRender){
        //此处修改成这样的目的是，手机和web页模版可以分别设置 如 ： list#MobileList
        if(ControllerUtil.isMobile()||theme.contains("mobile")) {
            String[] vs =  viewName.split("#");
            if(vs.length>1){
                viewName = vs[1];
            }
            return StrUtil.isBlank(ajaxRender)?"www/" + theme.trim() + "/" + viewName.trim():"www/" + theme.trim() + "/" + viewName.trim()+"#"+ajaxRender;
        }else {
            String[] vs =  viewName.split("#");
            if(vs.length>1){
                viewName = vs[0];
            }
            return StrUtil.isBlank(ajaxRender)?"www/" + theme.trim() + "/" + viewName.trim():"www/" + theme.trim() + "/" + viewName.trim()+"#"+ajaxRender;
        }
    }


    private static String view(String theme,String viewName){
        //此处修改成这样的目的是，手机和web页模版可以分别设置 如 ： list#MobileList
        if(ControllerUtil.isMobile()||theme.contains("mobile")) {
            String[] vs =  viewName.split("#");
            if(vs.length>1){
                viewName = vs[1];
            }
            return "www/" + theme.trim() + "/" + viewName.trim();
        }else {
            String[] vs =  viewName.split("#");
            if(vs.length>1){
                viewName = vs[0];
            }
            return "www/" + theme.trim() + "/" + viewName.trim();
        }
    }

    @RequestMapping("/test/{id:^-?[1-9]\\d.*}")
    @ResponseBody
    public String test(@PathVariable Integer id){
        return new String(id.toString());
    }
}
