package com.zz.coreJava2.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhangbenchao
 * @date 2019-10-30 20:41
 * 文件描述：
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if(args.length>0){
            String host=args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a:addresses){
                System.out.println(a);
            }
        }else{
            InetAddress localHostAddress  = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
