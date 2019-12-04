//package com.nhfc99.template.component.shiro;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import ch.qos.logback.classic.Logger;
//
//@Configuration
//@ComponentScan
//public class ShiroConfiguration {
//	private Logger logger = (Logger) LoggerFactory.getLogger(ShiroConfiguration.class);
//
//	/**
//	 * LifecycleBeanPostProcessor 是管理shiro生命周期的，不直接跟权限注解关联。
//	 * 所以加上DefaultAdvisorAutoProxyCreator 这个bean就可以了。
//	 *
//	 * @return
//	 */
//	@Bean
//	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
//		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//		advisorAutoProxyCreator.setProxyTargetClass(true);
//		return advisorAutoProxyCreator;
//	}
//
//	@Bean
//	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
//		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
//		return authorizationAttributeSourceAdvisor;
//	}
//
//	/**
//	 * 注入自定义的 Realm
//	 *
//	 * @return MyRealm
//	 */
//	@Bean
//	public ShiroRealm myAuthRealm() {
//		ShiroRealm myRealm = new ShiroRealm();
//		logger.info("====myRealm注册完成=====");
//		return myRealm;
//	}
//
//	/**
//	 * 注入安全管理器
//	 *
//	 * @return SecurityManager
//	 */
//	@Bean(name = "securityManager")
//	public DefaultWebSecurityManager securityManager() {
//		// 将自定义 Realm 加进来
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
//		logger.info("====securityManager注册完成====");
//		return securityManager;
//	}
//
//	/**
//	 * 配置 Shiro 过滤器：
//	 *
//	 * @param securityManager
//	 * @return
//	 */
//	@Bean(name = "shiroFilter")
//	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//
//		// 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
//		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
//		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
//		filterChainDefinitionManager.put("/login/logout", "logout");
//		// authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
//		filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
//		filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
//		filterChainDefinitionManager.put("/login/**", "anon");
//		filterChainDefinitionManager.put("/index", "anon");
//		filterChainDefinitionManager.put("/ajaxLogin", "anon");
//		filterChainDefinitionManager.put("/static/**", "anon");
//		filterChainDefinitionManager.put("/**", "authc,roles[user]");// 其他资源全部拦截
////		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//
//		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//		shiroFilterFactoryBean.setLoginUrl("/login/login");
//		// 登录成功后要跳转的链接
////		shiroFilterFactoryBean.setSuccessUrl("/login/success");
//		// 未授权界面
//		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//
//		return shiroFilterFactoryBean;
//	}
//}