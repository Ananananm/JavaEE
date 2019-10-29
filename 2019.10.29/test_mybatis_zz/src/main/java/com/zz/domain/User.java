package com.zz.domain;

import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-29 20:38
 * 文件描述：
 */
public class User {

    private int id;
    private String name;

    List<Score> scores;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}
