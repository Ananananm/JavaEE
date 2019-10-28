package com.zz.dao;

import com.zz.domain.Account;

import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-28 15:09
 * 文件描述：
 */
public interface IAccountDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findById(int id);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新
     * @param account
     * @return
     */
    int updateAccount(Account account);

}
