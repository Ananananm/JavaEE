package controller;

import domain.dos.UserDO;
import mapper.UserMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zbc
 * @version 1.0
 * @date 2019-10-27 11:21
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init方法被执行了！");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req,resp);
    }

    /**
     * 登陆业务处理
     * @param req
     * @param resp
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        UserMapper userMapper = new UserMapper();
        UserDO userDO = new UserDO();
        userDO.setName(userName);
        userDO.setPassowrd(password);
        UserDO loginUser = userMapper.findAll(userDO);

        if(loginUser!=null){
            String msg="下午好！"+loginUser.getNickName()+"。\t\t行车不规范，亲人两行泪！！！";
            req.setAttribute("msg",msg);
            HttpSession session=req.getSession();
            session.setAttribute("loginUser",loginUser);
            String scoreMsg="您当前拥有"+loginUser.getScore()+"分！";
            req.setAttribute("scoreMsg",scoreMsg);
            req.getRequestDispatcher("traffic.jsp").forward(req,resp);
        }else{
            String msg="用户名密码错误，请重新登陆";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }


}
