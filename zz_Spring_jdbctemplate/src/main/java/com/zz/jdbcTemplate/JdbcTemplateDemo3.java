package com.zz.jdbcTemplate;

import com.zz.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-28 14:06
 * 文件描述：
 *      jdbcTemplate的最基本的用法
 *
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
 //       jt.update("insert into account values(null,?,?)","lisi",20000);
        //更新
//        jt.update("update account set money=? where id=?",3000,8);
        //删除
//        jt.update("delete from account where id = ?" ,8);
        //查询所有
//        List<Account> list=jt.query("select * from account where money>?",new AccountRowMapper(),1000);
//        for (AccountImpl a :list){
//            System.out.println(a);
//        }

//        List<Account> list=jt.query("select * from account where money>?",new BeanPropertyRowMapper<AccountImpl>(Account.class),1000);
//        for (AccountImpl a :list){
//            System.out.println(a);
//        }
        //查询一行
//        List<Account> list=jt.query("select * from account where id=?",new BeanPropertyRowMapper<AccountImpl>(Account.class),1);
//        System.out.println(list.isEmpty()?"没有内容":list.get(0));
        //查询一行一列（不实用聚合函数group by）
        int i=jt.queryForObject("select count(*) from account where money >?",int.class,1000);
        System.out.println(i);


    }

}
class AccountRowMapper implements RowMapper{

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account =new Account();
        account.setId(resultSet.getInt(1));
        account.setName(resultSet.getString(2));
        account.setMoney(resultSet.getFloat(3));

        return account;
    }
}