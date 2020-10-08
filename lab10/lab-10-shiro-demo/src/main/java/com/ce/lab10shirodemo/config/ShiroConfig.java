package com.ce.lab10shirodemo.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author c__e
 * @date Created in 2020/10/8 20:48
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        // 创建 SimpleAccountRealm 对象
        SimpleAccountRealm realm = new SimpleAccountRealm();
        // 添加两个用户。参数分别是 username、password、roles 。
        realm.addAccount("admin", "admin", "ADMIN");
        realm.addAccount("normal", "normal", "NORMAL");
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 创建 DefaultWebSecurityManager 对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置其使用的 Realm
        securityManager.setRealm(this.realm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        // <1> 创建 ShiroFilterFactoryBean 对象，用于创建 ShiroFilter 过滤器
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        // <2> 设置 SecurityManager
        filterFactoryBean.setSecurityManager(this.securityManager());

        // <3> 设置 URL 们
        // 登录 URL
        filterFactoryBean.setLoginUrl("/login");
        // 登录成功 URL
        filterFactoryBean.setSuccessUrl("/login_success");
        // 无权限 URL
        filterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // <4> 设置 URL 的权限配置
        filterFactoryBean.setFilterChainDefinitionMap(this.filterChainDefinitionMap());

        return filterFactoryBean;
    }

    private Map<String, String> filterChainDefinitionMap() {
        // 注意要使用有序的 LinkedHashMap ，顺序匹配
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 允许匿名访问,即无需登录
        filterMap.put("/test/echo", "anon");
        // 需要 ADMIN 角色
        filterMap.put("/test/admin", "roles[ADMIN]");
        // 需要 NORMAL 角色
        filterMap.put("/test/normal", "roles[NORMAL]");
        // 退出
        filterMap.put("/logout", "logout");
        // 默认剩余的 URL ，需要经过认证
        filterMap.put("/**", "authc");
        return filterMap;
    }
}
