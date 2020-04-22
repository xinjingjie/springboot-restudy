package com.xinjingjie.restudy.config;

import com.xinjingjie.restudy.filter.MyFilter;
import com.xinjingjie.restudy.listener.MyListener;
import com.xinjingjie.restudy.servlet.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CustomConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(getClass());

//路径映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("this is executed");
        registry.addRedirectViewController("/nmsl","/hello");

    }
//注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("preHandle-------------");
                if (!("zxy").equals( request.getParameter("u"))){
                    response.sendRedirect("login");
                    logger.info("重定向了");

                }
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                logger.info("postHandle-------------");

            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                logger.info("afterCompletion-------------");

            }
        };

        registry.addInterceptor(interceptor).addPathPatterns("/user");
    }

    //以编程方式配置嵌入式servlet容器
    //注解方式bean名字默认是方法名，可以使用@bean("beanName")来指定bean名字
    @Bean
    public WebServerFactoryCustomizer MyTomcatWebServerFactoryCustomizer(){

        return new WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory>() {
            @Override
            public void customize(ConfigurableTomcatWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }

    //Servlet
    @Bean
    public ServletRegistrationBean MyFirstServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/servlet");
    }

    //注册Filter过滤器
    @Bean
    public FilterRegistrationBean MyFirstFilter(){
//        return new FilterRegistrationBean(new MyFilter(),new ServletRegistrationBean(new MyServlet(),"/servlet"));
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(new MyFilter());
        myFilterFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return myFilterFilterRegistrationBean;
    }


    //注册Listener监听器
    @Bean
    public ServletListenerRegistrationBean MyFirstListener(){
        return new ServletListenerRegistrationBean<MyListener>(new MyListener());
    }
}
