package com.zz.controller;

import com.zz.domain.AccountDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangbenchao
 * @date 2019-11-02 19:22
 * 文件描述：
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("testParam")
    public String testParam(String username){
        System.out.println(username);

        return "success";
    }

    @RequestMapping("saveAccount")
    public String saveAccount(AccountDO account){
        System.out.println(account);

        return "success";
    }

}
