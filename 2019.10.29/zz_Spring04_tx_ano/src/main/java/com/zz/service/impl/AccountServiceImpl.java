package com.zz.service.impl;

import com.zz.service.IAccountService;
import com.zz.dao.IAccountDao;
import com.zz.domian.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:42
 * 文件描述：
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//配置只读型事务
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao ;


    public Account findAccountById(int id) {
        return accountDao.findByid(id);
    }

    //配置读写型事务
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
    public void transfer(String sourceName, String targetName, float money) {
        //1.查询转出账户
        Account source=accountDao.findByName(sourceName);
        //2.查询转入账户
        Account target=accountDao.findByName(targetName);
        //3.转账
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        //4.更新
        accountDao.updateAccount(source);
        //int i=1/0;
        accountDao.updateAccount(target);
    }
}
