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
import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-28 10:13
 * 文件描述：
 */
@WebServlet(urlPatterns = "/traffic")
public class Modify extends HttpServlet {
    List<UserDO> userDoList = null;

    @Override
    public void init() throws ServletException {
        UserMapper userMapper = new UserMapper();
        userDoList = userMapper.findAll();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDO userDO = (UserDO) session.getAttribute("loginUser");
        int i = updateScore(req, resp, userDO);
        if (i > 0) {
            req.setAttribute("msg", "操作成功");
            UserMapper userMapper = new UserMapper();
            int socre = userMapper.findAll(userDO).getScore();
            String scoreMsg = "您当前拥有" + socre + "分！";
            req.setAttribute("scoreMsg", scoreMsg);
            req.getRequestDispatcher("traffic.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "操作失败");
        }


    }


    public int updateScore(HttpServletRequest req, HttpServletResponse resp, UserDO userDO) {
        UserMapper userMapper = new UserMapper();

        int score = Integer.parseInt(req.getParameter("score"));

        userDO.setScore(userDO.getScore() - score);
        return userMapper.updateScore(userDO);
    }

}
