package com.zz.dao;

import com.zz.domian.Account;

/**
 * @author zhangbenchao
 * @date 2019-10-28 16:30
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
