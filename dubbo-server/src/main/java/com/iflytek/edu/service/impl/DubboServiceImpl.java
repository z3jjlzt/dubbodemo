package com.iflytek.edu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.iflytek.edu.service.DubboService;
import org.springframework.stereotype.Component;

/**
 * Created by ztluo on 2017/8/16.
 */
@Component
@Service(version = "1.0.0")//使用dubbo扫描器进行扫描，相当于.export()
public class DubboServiceImpl implements DubboService {

    public String sayHi(String client_name) {

        return "hi, " + client_name;
    }
}
