package com.zz.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author zhangbenchao
 * @date 2019-10-28 14:06
 * 文件描述：
 *      jdbcTemplate的最基本的用法
 *
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        jt.execute("insert into account values(null,'ddd',2222)");

//        //1.配置数据源
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/ssm");
//        ds.setUsername("root");
//        ds.setPassword("12341234");
//        //2.创建JdbcTemplate对象
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        //3.给JdbcTemplate对象设置数据源
//        jdbcTemplate.setDataSource(ds);
//        //4.执行操作
//        jdbcTemplate.execute("insert into account values(null,'ccc',1000)");

    }

}
