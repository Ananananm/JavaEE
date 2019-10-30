package com.zz.coreJava2.chapter4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangbenchao
 * @date 2019-10-30 21:10
 * 文件描述：
 */
public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket s =new ServerSocket(8189)){
            int i=1;

            while(true){
                Socket incoming = s.accept();
                System.out.println("Spawing "+i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t =new Thread(r);
                t.start();
                i++;
            }
        }
    }
}
class ThreadedEchoHandler implements Runnable{
    private Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket){
        incoming = incomingSocket;
    }

    @Override
    public void run() {
        try(InputStream inStream =incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream()){

            Scanner in = new Scanner(inStream,"UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream,"UTF-8"),true);
            out.println("Hello! Enter BYE to exit.");

            boolean done = false;
            while(!done && in.hasNextLine()){
                String line = in.nextLine();
                out.println("Echo: "+line);
                if(line.trim().equals("BYE")){
                    done=true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}