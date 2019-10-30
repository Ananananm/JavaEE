package com.zz.coreJava2.chapter4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangbenchao
 * @date 2019-10-30 20:47
 * 文件描述：
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try(Scanner in = new Scanner(inputStream,"UTF-8")){
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8"),true);

                    out.println("Hello! Entry BYR to exit.");

                    boolean done = false;
                    while(!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: "+line);
                        if(line.trim().equals("BYE")){
                            done=true;
                        }
                    }
                }
            }
        }
    }
}
