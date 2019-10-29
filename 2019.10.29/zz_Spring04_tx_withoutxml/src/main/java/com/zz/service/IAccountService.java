package com.zz.service;

import com.zz.domain.Account;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:42
 * 文件描述：
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 转装
     * @param sourceName 转出账户名
     * @param targetName  转入账户名
     * @param money       转入金额
     */
    void transfer(String sourceName,String targetName,float money);
}
