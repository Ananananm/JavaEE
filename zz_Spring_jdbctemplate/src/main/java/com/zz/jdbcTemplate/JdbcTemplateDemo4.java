package com.zz.jdbcTemplate;

import com.zz.dao.IAccountDao;
import com.zz.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhangbenchao
 * @date 2019-10-28 14:06
 * 文件描述：
 *      jdbcTemplate的最基本的用法
 *
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao=ac.getBean("accountDao2", IAccountDao.class);
        //3.执行操作
        Account account=accountDao.findById(1);
        System.out.println(account);

//        account=accountDao.findByName("bbb");
//        System.out.println(account);
//
//        account.setMoney(10000f);
//        accountDao.updateAccount(account);
    }

}
