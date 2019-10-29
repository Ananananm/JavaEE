package com.zz.dao.impl;

import com.zz.dao.IAccountDao;
import com.zz.domian.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:33
 * 文件描述：
 */
@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findByid(int id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }

        if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public int updateAccount(Account account) {
        int i=jdbcTemplate.update("update account set money=? where id=?",account.getMoney(),account.getId());
        return i;
    }
}
