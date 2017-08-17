package com.iflytek.edu.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.iflytek.edu.service.DubboService;
import com.iflytek.edu.service.impl.DubboServiceImpl;
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

    /*dubbo扫描*/
    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.iflytek.edu.service");
        return annotationBean;
    }

    @Bean
    public DubboService dubboService() {
        DubboServiceImpl dubboService = new DubboServiceImpl();
        return dubboService;
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("hi_app");
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

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }

    @Bean
    public ServiceConfig<DubboService> serviceConfig(DubboService dubboService) {
        ServiceConfig<DubboService> config = new ServiceConfig<>();
        config.setApplication(applicationConfig());
        config.setRegistry(registryConfig());
        config.setProtocol(protocolConfig());
        config.setInterface(DubboService.class);
        config.setRef(dubboService);
        config.setVersion("1.0.0");
//        config.export();
        return config;
    }

}
