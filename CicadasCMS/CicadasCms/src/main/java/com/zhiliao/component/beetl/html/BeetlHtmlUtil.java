package com.zhiliao.component.beetl.html;


import com.zhiliao.common.utils.ControllerUtil;
import com.zhiliao.component.beetl.thread.HtmlThread;
import com.zhiliao.common.utils.PathUtil;
import com.zhiliao.common.utils.StrUtil;
import com.zhiliao.module.web.cms.service.SiteService;
import com.zhiliao.mybatis.model.TCmsSite;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;


@Component
public class BeetlHtmlUtil {


	@Autowired
	private GroupTemplate groupTemplate;

	@Autowired
	private SiteService siteService;

	@Value("${system.http.protocol}")
	private String httpProtocol;


	@Value("${system.http.host}")
	private String httpHost;

	@Value("${system.site.subfix}")
	private String siteSubfix;

	@Value("${system.site.prefix}")
	private String sitePrefix;

	@Value("${system.site.static.path}")
	String staticPath;

	private final String STATIC_SUFFIX = ".html";


	public void create(HttpServletRequest request,Integer siteId, String action, Map<String, Object> attr, String theme, String tpl) {
		String view = "www"+File.separator + theme + File.separator + view(tpl)+STATIC_SUFFIX;
		TCmsSite site = siteService.findVoById(siteId);
		Template template = groupTemplate.getTemplate(view);
		StringWriter writer = new StringWriter();
		template.binding("request", request);
		template.binding("ctxPath", request.getContextPath());
		template.binding("baseURL", httpProtocol + "://" + httpHost);
		template.binding("staticHtmlPath", "/html");
		template.binding(attr);
		template.renderTo(writer);
		HtmlObject obj = new HtmlObject();
		obj.setContent(format(writer.toString(),site.getSiteKey()));
		String fileUrl = staticPath+ File.separator +"html"+ File.separator + site.getSiteKey() + File.separator + (StrUtil.isBlank(action)?"index":action) + ".html";
		new File(fileUrl).delete();
		obj.setFileUrl(fileUrl);
		HtmlThread.addHtml(obj);
	}

	private static String view(String viewName){
		String[] vs =  viewName.split("#");
		if(vs.length>1){
			viewName = vs[0];
		}
		return viewName.trim();
	}

	private String format(String page,String siteKey){
		return page.replace("/"+sitePrefix+"/","/html/").replace(siteSubfix, STATIC_SUFFIX).replace("\""+httpProtocol + "://" + httpHost+"/html/"+siteKey+"/\"","\""+httpProtocol + "://" + httpHost+"/html/"+siteKey+"/index.html\"");
	}

}
