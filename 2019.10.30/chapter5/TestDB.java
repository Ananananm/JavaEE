package com.zz.coreJava2.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * @author zhangbenchao
 * @date 2019-10-30 14:02
 * 文件描述：
 */
public class TestDB {
    public static void main(String[] args) throws IOException {
        try{
            runTest();
        }catch (SQLException ex){
            for (Throwable t :ex){
                t.printStackTrace();
            }
        }
    }

    public static void runTest() throws IOException, SQLException {
        try(Connection conn = getConnection();
            Statement stat  = conn.createStatement()){

            stat.executeUpdate("create table Greetings (Message char(20))");
            stat.executeUpdate("insert into Greetings values ('Hello,World!') ");
            try(ResultSet result = stat.executeQuery("select * from Greetings")){
                if(result.next()){
                    System.out.println(result.getString(1));
                }
            }
                stat.executeUpdate("drop table Greetings");
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null){
            System.setProperty("jdbc.drivers",drivers);
        }
        String url = props.getProperty("jdbc.url");
        String username= props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url,username,password);
    }
}
