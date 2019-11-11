package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangbenchao
 * @date 2019-10-30 19:56
 * 文件描述：
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(path = "/hello",method = RequestMethod.GET,params = {"username=zhangsan","password=1"})
    public String helloHandler(){
        System.out.println("Hello world");// 指定方法对应的URL
        return "success";// 指定跳转的视图的地址,被ViewResolver解析为 /WEB-INF/pages/success.jsp
    }
}
