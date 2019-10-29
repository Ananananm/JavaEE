package com.zz.mapper;

import com.zz.domain.User;

import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-29 20:37
 * 文件描述：
 */
public interface UserMapper {

    List<User> findAll();
}
