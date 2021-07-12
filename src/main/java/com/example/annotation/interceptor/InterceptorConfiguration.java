package com.example.annotation.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器的属性配置
 *
 * @Author hsj
 */
@Configuration//标识这是一个配置类
public class InterceptorConfiguration implements WebMvcConfigurer {

    /**
     * 重写addCorsMappings()解决跨域问题
     * 配置：允许http请求进行跨域访问
     *
     * @param registry
     * @Author 有梦想的肥宅
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//指哪些接口URL需要增加跨域设置
                .allowedOrigins("*")//指的是前端哪些域名被允许跨域
                .allowCredentials(true)//需要带cookie等凭证时，设置为true，就会把cookie的相关信息带上
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")//指的是允许哪些方法
                .maxAge(3600);//cookie的失效时间，单位为秒（s），若设置为-1，则关闭浏览器就失效
    }

    /**
     * 重写addInterceptors()实现拦截器
     * 配置：要拦截的路径以及不拦截的路径
     *
     * @param registry
     * @Author 有梦想的肥宅
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
//        注册Interceptor拦截器(Interceptor这个类是我们自己写的拦截器类)
        InterceptorRegistration registration = registry.addInterceptor(new Interceptor());
        //addPathPatterns()方法添加需要拦截的路径
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        //excludePathPatterns()方法添加不拦截的路径
        registration.excludePathPatterns(                         //添加不拦截路径
                "/demo/loginPage",            //登录页面的地址【不拦截】
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css"              //css静态资源
        );
    }
}
