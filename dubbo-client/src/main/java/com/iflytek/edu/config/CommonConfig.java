package com.iflytek.edu.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 基于java注解方式配置spring
 * Created by ztluo on 2017/8/16.
 */
@Configuration
@ComponentScan(basePackages = "com.iflytek.edu")
public class CommonConfig {

    /*consumer*/

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.iflytek.edu");
        return annotationBean;
    }

    @Bean
    public ApplicationConfig capplicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("hi_client");
        return config;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setAddress("multicast://224.5.6.7:1234");
        config.setUsername("aaa");
        config.setPassword("bbb");
        return config;
    }

    /*使用dubbo的annotation扫描替代手动注入*/
//    @Bean
//    public DubboService dubboService() {
//        ReferenceConfig<DubboService> config = new ReferenceConfig<>();
//        config.setApplication(capplicationConfig());
//        config.setRegistry(registryConfig());
//        config.setInterface(DubboService.class);
//        config.setVersion("1.0.0");
//        return config.get();
//    }

}
