package controller;

import domain.dos.ScoreDo;
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
        int originalScore = userDO.getScore();
        int i = updateScore(req, resp, userDO);
        if (i > 0) {
            req.setAttribute("msg", "操作成功");
            UserMapper userMapper = new UserMapper();
            int socre = userMapper.findAll(userDO).getScore();
            String scoreMsg = "您原来拥有"+originalScore+"分，当前拥有" + socre +"分，扣掉："+req.getParameter("score")+"分！";
            req.setAttribute("scoreMsg", scoreMsg);
            req.getRequestDispatcher("survey.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "操作失败");
        }


    }

    /**
     * 更新分数
     * @param req
     * @param resp
     * @param userDO
     * @return
     */
    public int updateScore(HttpServletRequest req, HttpServletResponse resp, UserDO userDO) {
        UserMapper userMapper = new UserMapper();
        ScoreDo scoreDo = new ScoreDo();
        scoreDo.setOriginalScore(userDO.getScore());

        int violateScore = Integer.parseInt(req.getParameter("score"));

        userDO.setScore(userDO.getScore() - violateScore);

        scoreDo.setViolateScore(violateScore);
        scoreDo.setCurrentScore(userDO.getScore());
        scoreDo.setUserId(userDO.getId());
        int i=userMapper.updateUserScore(userDO);
        if(i>0){
            userMapper.insertScore(scoreDo);
        }
        return i;
    }

}
