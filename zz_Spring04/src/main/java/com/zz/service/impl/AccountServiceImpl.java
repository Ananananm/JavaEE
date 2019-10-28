package com.zz.service.impl;

import com.zz.service.IAccountService;
import com.zz.dao.IAccountDao;
import com.zz.domian.Account;

/**
 * @author zhangbenchao
 * @date 2019-10-28 16:42
 * 文件描述：
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao ;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(int id) {
        return accountDao.findByid(id);
    }

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
