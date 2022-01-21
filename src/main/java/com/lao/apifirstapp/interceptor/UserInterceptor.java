package com.lao.apifirstapp.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;

public class UserInterceptor implements HandlerInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // Handling the HttpServlet before processing its payload.

        LOGGER.info("Pre Handle Request");
        String auth =  request.getAuthType();
        Enumeration<String> authHeaders = request.getHeaderNames();

       while(authHeaders.hasMoreElements()){
           if(Objects.equals(authHeaders.nextElement(), "authorization")){
               System.out.println(authHeaders.nextElement() + " auth");
           }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("Post Handle Request");
        String auth =  request.getAuthType();
        System.out.println(auth);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("Post Handle Request");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
