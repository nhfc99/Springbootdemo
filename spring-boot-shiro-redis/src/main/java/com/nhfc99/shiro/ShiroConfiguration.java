package com.nhfc99.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Logger;

@Configuration
@ComponentScan
public class ShiroConfiguration {
	private Logger logger = (Logger) LoggerFactory.getLogger(ShiroConfiguration.class);

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.password}")
	private String password;

	/**
	 * LifecycleBeanPostProcessor 是管理shiro生命周期的，不直接跟权限注解关联。
	 * 所以加上DefaultAdvisorAutoProxyCreator 这个bean就可以了。
	 * 
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 注入自定义的 Realm
	 * 
	 * @return MyRealm
	 */
	@Bean
	public ShiroRealm myAuthRealm() {
//	public ShiroRealm myAuthRealm(CredentialsMatcher credentialsMatcher) {
		ShiroRealm myRealm = new ShiroRealm();
		logger.info("====myRealm注册完成=====");
		// 将自定义的令牌set到了Realm
//		myRealm.setCredentialsMatcher(credentialsMatcher);
		return myRealm;
	}

	/**
	 * 注入安全管理器
	 * 
	 * @return SecurityManager
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		// 将自定义 Realm 加进来
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm(hashedCredentialsMatcher()));
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
		logger.info("====securityManager注册完成====");
		// 配置自定义会话redis
		securityManager.setSessionManager(sessionManager());
		// 配置自定义缓存redis
		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}

	/**
	 * 配置 Shiro 过滤器：
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		// 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionManager.put("/login/logout", "logout");
		// authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
		filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
		filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
		filterChainDefinitionManager.put("/login/**", "anon");
		filterChainDefinitionManager.put("/index", "anon");
		filterChainDefinitionManager.put("/ajaxLogin", "anon");
		filterChainDefinitionManager.put("/static/**", "anon");
		filterChainDefinitionManager.put("/**", "authc,roles[user]");// 其他资源全部拦截
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login/login");
		// 登录成功后要跳转的链接
//		shiroFilterFactoryBean.setSuccessUrl("/login/success");
		// 未授权界面
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");

		return shiroFilterFactoryBean;
	}

	// session管理
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new MySessionListener());
		sessionManager.setSessionListeners(listeners);
		// 设置session超时时间为1小时(单位毫秒)
		// sessionManager.setGlobalSessionTimeout(3600000);
		sessionManager.setGlobalSessionTimeout(-1);// 永不超时
		// 设置redisSessionDao
		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}

	// 配置cacheManager
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}

	// 配置redisManager
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setTimeout(timeout);
		redisManager.setPassword(password);
		redisManager.setExpire(3600);// 配置缓存过期时间(秒)
		return redisManager;
	}

	// 配置redisSessionDAO
	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}

	// 密码匹配凭证管理器
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// 采用SHA-512方式加密
		hashedCredentialsMatcher.setHashAlgorithmName("SHA-512");
		// 设置加密次数
		hashedCredentialsMatcher.setHashIterations(1024);
		// true加密用的hex编码，false用的base64编码
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false);
		return hashedCredentialsMatcher;
	}
}
