package com.zz.domain;

/**
 * @author zhangbenchao
 * @date 2019-10-29 20:46
 * 文件描述：
 */
public class Score {
    private int id;
    private int original_score;
    private int userid;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", original_score=" + original_score +
                ", userid=" + userid +
                '}';
    }
}
