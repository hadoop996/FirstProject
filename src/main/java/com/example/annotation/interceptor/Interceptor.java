package com.example.annotation.interceptor;

import com.example.annotation.controller.InterceptorController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 * @Author 有梦想的肥宅
 */
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor preHandler method is running !");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor postHandler method is running !");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor afterCompletion method is running !");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor afterConcurrentHandlingStarted method is running !");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * @Author 有梦想的肥宅
     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        System.out.println("执行了Interceptor的preHandle方法");
//        Class<InterceptorController> InterceptorController = InterceptorController.class;
//        Method[] declaredMethods = InterceptorController.getDeclaredMethods();
//        if(declaredMethods != null){
//            for(Method method : declaredMethods){
//                System.out.println(method);
//            }
//        }
//        return true;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
//        //如果设置为true时，请求将会继续执行后面的操作
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("Interceptor postHandler method is running !");
//        super.postHandle(request, response, handler, modelAndView);
//    }

}
