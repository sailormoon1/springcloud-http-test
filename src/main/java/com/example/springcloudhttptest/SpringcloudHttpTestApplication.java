package com.example.springcloudhttptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudHttpTestApplication implements  CommandLineRunner{
    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHttpTestApplication.class, args);



    }

    @Override
    public void run(String... args) throws Exception {
//        String[] beans = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//        for (String bean : beans)
//        {
//            System.out.println(bean + " of Type :: " + applicationContext.getBean(bean).getClass());
//        }
//
//
//        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
//        // 获取url与类和方法的对应信息
//        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
//        for (RequestMappingInfo info : map.keySet()) {
//            // 获取url的Set集合，一个方法可能对应多个url
//            Set<String> patterns = info.getPatternsCondition().getPatterns();
//            for (String url : patterns) {
//                // 把结果存入静态变量中程序运行一次次方法之后就不用再次请求次方法
//                System.out.println(url);
//            }
//        }
    }
}
