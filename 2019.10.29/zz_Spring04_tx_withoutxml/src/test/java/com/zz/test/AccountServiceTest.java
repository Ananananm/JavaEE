package com.zz.test;

import com.zz.service.IAccountService;
import config.SpringConfiguartion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangbenchao
 * @date 2019-10-29 16:43
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguartion.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){

        as.transfer("aaa","bbb",100f);
    }
}
