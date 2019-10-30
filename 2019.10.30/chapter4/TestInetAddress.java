package com.zz.coreJava2.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhangbenchao
 * @date 2019-10-30 22:18
 * 文件描述：
 */
public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象(本地主机)
        InetAddress address=InetAddress.getLocalHost();
        //返回主机名
        System.out.println(address.getHostName());
        //返回主机的ip地址
        System.out.println(address.getHostAddress());

        //根据域名得到InetAddress对象
        InetAddress addr1 = InetAddress.getByName("www.baidu.com");
        //返回百度的主机名（域名）
        System.out.println(addr1.getHostName());
        // 返回百度服务器的IP:180.101.49.11
        System.out.println(addr1.getHostAddress());

        //根据IP得到InetAddress对象
        InetAddress addr2 = InetAddress.getByName("61.155.221.227");
        /*
         * 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。
         */
        System.out.println(addr2.getHostName());
        // 返回淘宝服务器的IP：61.155.221.227
        System.out.println(addr2.getHostAddress());
    }
}
