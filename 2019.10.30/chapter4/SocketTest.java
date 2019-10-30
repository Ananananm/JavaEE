package com.zz.coreJava2.chapter4;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangbenchao
 * @date 2019-10-30 20:35
 * 文件描述：
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try(Socket s = new Socket("time-a.nist.gov",13);
            Scanner in = new Scanner(s.getInputStream(),"UTF-8")){
            while(in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
