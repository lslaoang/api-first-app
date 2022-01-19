package com.lao.apifirstapp.configuration;

import com.lao.apifirstapp.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
       registry.addInterceptor(new UserInterceptor()).addPathPatterns("/users/**");
    }
}
