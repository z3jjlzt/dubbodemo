package com.iflytek.edu;

import com.alibaba.dubbo.config.annotation.Reference;
import com.iflytek.edu.config.CommonConfig;
import com.iflytek.edu.service.DubboService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 */
@Component
public class App {
    @Reference(version = "1.0.0")//相当于spring的autowire
            DubboService dubboService;

    public String say(String txt) {
        return dubboService.sayHi(txt);
    }


//    public static void main( String[] args ) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);
//        applicationContext.start();
//        DubboService dubboServide = (DubboService) applicationContext.getBean("dubboService");
//        System.out.println(dubboService.sayHi("i'm client"));
//    }
}
