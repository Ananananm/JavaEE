package com.zz.coreJava2.chapter4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangbenchao
 * @date 2019-10-30 22:26
 * 文件描述：
 */
public class TestTransfer {
        public static void main(String[] args)  {
            System.out.println("-----服务端------");
            //1.指定端口，使用ServerSocket创建服务端
            ServerSocket server= null;
            Socket socket=null;
            BufferedReader br=null;
            BufferedWriter bw=null;
            BufferedReader in=null;
            try {
                server = new ServerSocket(8888);
                //2.阻塞式的等待连接accept
                socket=server.accept();
                //3.IO流进行操作
                br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                in=new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    String str1=br.readLine();
                    System.out.println("客户端说："+str1);
                    String str2="";
                    if(str1.equals("end")){
                        break;
                    }
                    str2=in.readLine();
                    bw.write(str2+"\n");
                    bw.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //4.释放资源
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


 class Client{
    public static void main(String[] args) {
        System.out.println("-----客户端------");
        //1.建立连接，使用socket创建客户端+服务的地址和端口

        Socket client=null;
        BufferedReader br=null;
        BufferedWriter bw=null;
        BufferedReader in=null;
        try {
            client = new Socket("localhost",8888);
            //3.IO流进行操作
            br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String str=in.readLine();
                bw.write(str+"\n");
                bw.flush();
                if(str.equals("end")){
                    break;
                }
                System.out.println("服务端说："+br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
