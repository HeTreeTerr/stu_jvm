package com.hss.socket;

import java.io.*;
import java.net.Socket;

/**
 * java socket 编程
 * 使用TCP提供了两台计算机之间的通信机制。客户端程序创建一个套接字，
 * 并尝试连接服务器的套接字。当连接建立时，服务器会创建一个Socket对
 * 象。客户端和服务器现在可以通过对Socket对象的写入和读取来进行通信。
 *
 * 客户端（演示代码）
 */
public class SocketClientDemo {

    private final static String SERVICE_IP = "127.0.0.1";

    private final static Integer SERVICE_PORT = 6666;

    public static void main(String[] args) {
        try {

            System.out.println("\n===============分割线===========");
            Socket socket = new Socket(SERVICE_IP, SERVICE_PORT);
            System.out.println("远程service地址：" + socket.getRemoteSocketAddress());
            //发送消息
            OutputStream outToServer = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(" PING from" + socket.getLocalSocketAddress());
            //接受确认
            InputStream inFromServer = socket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应：" + in.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
