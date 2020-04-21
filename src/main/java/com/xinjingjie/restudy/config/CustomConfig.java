package com.xinjingjie.restudy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Configuration
public class CustomConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("this is executed");
        registry.addRedirectViewController("/nmsl","/hello");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("preHandle-------------");
                if (!("zxy").equals(request.getSession().getAttribute("username"))){
                    response.sendRedirect("index");
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

        registry.addInterceptor(interceptor).addPathPatterns("/hello");
    }
}
