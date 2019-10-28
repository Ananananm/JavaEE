package util.dbconn;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zhangbenchao
 * @date 2019-10-27 18:50
 * 文件描述：
 */
public class DbUtils {
    private static Connection conn=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;

    /**
     * 获取数据库的连接
     * @return
     */
    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zbcdb", "root", "12341234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 用于查询的方法
     *
     * @param sql
     * @param obj
     * @return
     */
    public static ResultSet executeQuery(String sql, Object... obj) {
        try {
            conn=getConnection();
            ps = conn.prepareStatement(sql);
            if (obj.length>0) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    /**
     * 用于增，删，改的方法
     *
     * @param sql
     * @param obj
     * @return
     */
    public static int executeUpdate(String sql, Object... obj) {
        int index=0;
        try {
            conn=getConnection();
            ps = conn.prepareStatement(sql);
            if(obj.length>0) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            index=ps.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    /**
     * 关闭所有资源
     */
    public static void closeAll(){

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
