package com.zz.dao.impl;

import com.zz.dao.IAccountDao;
import com.zz.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-28 15:12
 * 文件描述：
 */
public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {

    public Account findById(int id) {
        List<Account> accounts=getJdbcTemplate().query("select * from account where id =?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts=getJdbcTemplate().query("select * from account where name =?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public int updateAccount(Account account) {
        int i=getJdbcTemplate().update("update account set money=? where id=?",account.getMoney(),account.getId());
        return i;

    }
}
