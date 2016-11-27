package com.june;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.june.common.util.SpringContextUtil;
import com.june.impl.TestServiceImpl;


/**
 * 声明Controller
 * 配置组件扫描：扫描的组件必须是与该类同级目录或者是其下一级目录
 * 声明SpringBootApplication
 * @SpringBootApplication 其实包含了@ComponentScan,@EnableAutoConfiguration,@Controller三层含义
 * @author wcq
 *
 */
//@Controller
//@ComponentScan
@SpringBootApplication
//@ServletComponentScan
public class SampleController {

	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
    	ConfigurableApplicationContext context=SpringApplication.run(SampleController.class, args);
    	SpringContextUtil.setApplicationContext(context);
        TestServiceImpl testService=SpringContextUtil.getBean(TestServiceImpl.class);
//        PageHelper.startPage(1,2);
        
        testService.getUsers();
    }
}
