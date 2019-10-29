package com.zz.dao;

import com.zz.domain.Account;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:39
 * 文件描述：
 */
public interface IAccountDao {
    /**
     *  根据id查询账户
     * @param id
     * @return
     */
    Account findByid(int id);

    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新账户
     * @param account
     * @return
     */
    int updateAccount(Account account);
}
