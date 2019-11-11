package com.zz.controller;

import com.sun.deploy.net.HttpResponse;
import com.zz.domain.UserDO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangbenchao
 * @date 2019-11-11 09:46
 * 文件描述：
 */
@Controller
@RequestMapping("/user")
public class UserContorller {
    /**
     * 返回值为String的
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        //模拟从数据库中查询
        UserDO userDO = new UserDO();
        userDO.setName("张三");
        userDO.setPassword("123");
        userDO.setAge(18);

        model.addAttribute("user",userDO);
        return "success";
    }

    /**
     * 返回值类型是void类型
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行了...");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/test.jsp");

        //直接响应数据
        //response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println("你好");
        return;
    }


    /**
     * 返回值是ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("ModelAndView方法执行了...");
        //模拟从数据库中查询
        UserDO userDO = new UserDO();
        userDO.setName("李四");
        userDO.setPassword("456");
        userDO.setAge(18);
        //把userDO对象存储到mv对象中，也会相应的存到request作用域中
        mv.addObject("user",userDO);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用SpringMVC提供的forward关键字和redirect关键字
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/test.jsp";
    }

    /**
     * 使用Ajax发起异步请求
     * @return
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public UserDO testAjax(@RequestBody UserDO userDO){
        System.out.println("testAjax方法执行了...");
        System.out.println(userDO);
        //模拟数据库操作
        UserDO user = new UserDO();
        user.setName("zhangsan");
        user.setAge(44);
        // 将user对象返回给前端页面
        return user;
    }
}
