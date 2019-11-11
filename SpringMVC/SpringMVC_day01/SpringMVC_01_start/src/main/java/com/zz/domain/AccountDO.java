package com.zz.domain;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbenchao
 * @date 2019-11-02 19:34
 * 文件描述：
 */
public class AccountDO {
    private String username;
    private String password;
    private Double money;
    private UserDO userDO;

    private List<UserDO> list;

    private Map<String,UserDO> map;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

//    public UserDO getUserDO() {
//        return userDO;
//    }
//
//    public void setUserDO(UserDO userDO) {
//        this.userDO = userDO;
//    }


    public List<UserDO> getList() {
        return list;
    }

    public void setList(List<UserDO> list) {
        this.list = list;
    }

    public Map<String, UserDO> getMap() {
        return map;
    }

    public void setMap(Map<String, UserDO> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "AccountDO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
