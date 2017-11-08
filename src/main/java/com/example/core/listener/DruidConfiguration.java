package com.example.core.listener;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 开启durid 监控功能 /druid/index.html
 * Created by yefei on 2017/7/27.
 */
@Configurable
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServle()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        servletRegistrationBean.addInitParameter("deny","192.168.1.1");
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","12345678");
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean statFilter()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");//添加过滤规则
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,/druid/*");//忽略过滤格式
        return  filterRegistrationBean;
    }
}
