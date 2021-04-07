package com.example;

import com.example.config.UserBroadcastThread;
import com.example.filter.TestFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.Filter;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.mapper")
@EnableTransactionManagement
@ServletComponentScan
@EnableAsync
public class DemoApplication {

    @Autowired
    private UserBroadcastThread userBroadcastThread;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public void readUserBroadcast(){
//        new Thread(userBroadcastThread).start();
//    }

    @Bean
    public Filter filter2(){
        return new TestFilter();
    }

    @Bean
    public FilterRegistrationBean setFilter2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter2());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);   //order的数值越小，在所有的filter中优先级越高
        return filterRegistrationBean;
    }
}
