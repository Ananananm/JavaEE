package com.zz;

import com.zz.domain.User;
import com.zz.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-29 20:43
 * 文件描述：
 */
public class test {

    @Test
    public void testFindAll() throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂创建SqlSession
        SqlSession session =factory.openSession();
        //4.使用SqlSession创建dao接口的代理对象
        UserMapper userDao =session.getMapper(UserMapper.class);
        //5.使用代理对象的方法
        List<User> users = userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        inputStream.close();
    }
}
