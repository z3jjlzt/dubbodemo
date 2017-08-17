package com.iflytek.edu;

import com.iflytek.edu.config.CommonConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);
        applicationContext.start();
        System.out.println("按任意键退出！！");
        System.in.read();

    }
}
