package com.zz.controller;

import com.zz.domain.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * @author zhangbenchao
 * @date 2019-11-05 16:07
 * 文件描述：
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"userDO"})
public class AnnoContorller {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name){
        System.out.println(name);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String username){
        System.out.println(username);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/testRequestHeader/{id}")
    public String testRequestHeader(@RequestHeader("Accept") String header){
        System.out.println(header);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("aaa") UserDO userDo){
        System.out.println(userDo);
        System.out.println("testModelAttribute执行了。。。");
        return "success";
    }
//    @ModelAttribute
//    public UserDO testShowUser(String username){
//        UserDO userDO = new UserDO();
//        userDO.setUname(username);
//        userDO.setAge(12);
//        System.out.println("testShowUser执行了。。。");
//        return userDO;
//    }

    @ModelAttribute
    public void testShowUser(String username, Map<String,UserDO> map){
        UserDO userDO = new UserDO();
        userDO.setUname(username);
        userDO.setAge(12);
        map.put("aaa",userDO);
        System.out.println("testShowUser执行了。。。");
    }
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        UserDO userDO = new UserDO();
        userDO.setUname("zhangsan");

        model.addAttribute("java","Core Java");
        model.addAttribute("userDO",userDO);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){

        UserDO userDO = (UserDO)modelMap.get("userDO");
        System.out.println(userDO);
        System.out.println("执行了。。。");
        return "success";
    }

    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status){

        status.setComplete();
        System.out.println("deleteSessionAttributes执行了。。。");
        return "success";
    }
}
