package com.zz.domain;

/**
 * @author zhangbenchao
 * @date 2019-11-02 19:44
 * 文件描述：
 */
public class UserDO {
    private String uname;
    private Integer age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserDO{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }
}
