package com.hss.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * java socket 编程
 * 服务端（演示代码）
 */
public class SocketServiceDemo {

    private ServerSocket serverSocket;

    public SocketServiceDemo(int potr) throws IOException {
        serverSocket = new ServerSocket(potr);
        serverSocket.setSoTimeout(10 * 1000);
    }

    public void start() {
        while (true){
            try {
                System.out.println("server-port:" + serverSocket.getLocalPort() + " 等待远程连接...");
                //接收消息
                Socket socket = serverSocket.accept();
                System.out.println("\n===============分割线===========");
                System.out.println("远程client地址：" + socket.getRemoteSocketAddress());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("server接受消息：" + inputStream.readUTF());
                //回馈消息
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("server-address:" + socket.getLocalSocketAddress() + " PONG");
                //关闭此次通讯
                socket.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                continue;
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        try {
            SocketServiceDemo serviceDemo = new SocketServiceDemo(6666);
            serviceDemo.start();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
