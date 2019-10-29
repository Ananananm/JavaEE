package mapper;

import domain.dos.ScoreDo;
import domain.dos.UserDO;
import util.dbconn.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-27 19:20
 * 文件描述：
 */
public class UserMapper {

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<UserDO> findAll() {
        List<UserDO> userDoList = new ArrayList<>();
        String sql = "select * from login_user ";
        ResultSet rs = DbUtils.executeQuery(sql);
        UserDO u=null;
        try {
            while (rs.next()) {
                u=new UserDO();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPassowrd(rs.getString(3));
                u.setNickName(rs.getString(4));
                u.setScore(rs.getInt(5));
                userDoList.add(u);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeAll();
        }

        return userDoList;
    }

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    public UserDO findAll(UserDO user) {
        String sql = "select * from login_user where name=? and password=?";
        ResultSet rs = DbUtils.executeQuery(sql, user.getName(), user.getPassowrd());
        UserDO u=null;
        try {
            while (rs.next()) {
                u=new UserDO();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPassowrd(rs.getString(3));
                u.setNickName(rs.getString(4));
                u.setScore(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeAll();
        }

        return u;
    }

    /**
     * 更新用户表中的分数
     * @param user
     * @return
     */
    public int updateUserScore(UserDO user){
        String sql = "update login_user set score =? where name=? and password=?";
        return DbUtils.executeUpdate(sql,user.getScore(),user.getName(),user.getPassowrd());
    }

    /**
     * 向分数记录表中插入数据
     * @param scoreDo
     * @return
     */
    public int insertScore(ScoreDo scoreDo){
        String sql = "insert into user_score(original_score,violate_score,current_score,user_id) VALUE(?,?,?,?)";
        return DbUtils.executeUpdate(sql,scoreDo.getOriginalScore(),scoreDo.getViolateScore(),scoreDo.getCurrentScore()
                ,scoreDo.getUserId());

    }

}
