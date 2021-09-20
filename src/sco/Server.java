package sco;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import  java.util.*;
//聊天室服务器端
public class Server {
    //声明服务器套接字
    ServerSocket serverSocket;
    //输入流列表集合
    ArrayList<BufferedReader> brs = new ArrayList<BufferedReader>();
    //输出流列表集合
    ArrayList<PrintWriter> pw = new ArrayList<PrintWriter>();
    //聊天信息链表集合
    LinkedList<String> msgList = new LinkedList<String>();

    public Server() {
        try {
            //创建服务器端套接字，在11111端口接听
            serverSocket = new ServerSocket(28888);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建接收客户端socket的线程实例
        new AcceptSocketThread().start();
        //创建客户端发送信息的线程实例
        new SendMsgToClient().start();
        System.out.println("服务器已启动....");
    }

    public class AcceptSocketThread extends Thread {
        public void run() {
            while (this.isAlive()) {
                try {
                    //接收客户端socket对象
                    Socket socket = serverSocket.accept();
                    //建立该客户端通信管道
                    if (socket != null) {
                        //获取socket对象的输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        //将输入流添加到输入流列表集合中
                        brs.add(br);
                        //开启一个线程接收该客户端的聊天信息
                        new GetMsgFromcont(br).start();
                        //获取socket对象的输出流，并添加到输入出流列表集合中
                        pw.add(new PrintWriter(socket.getOutputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //接收客户端的聊天信息的线程
    class GetMsgFromcont extends Thread {
        BufferedReader br;
        public GetMsgFromcont(BufferedReader br) {
            this.br = br;
        }
        public void run()
        {
            while (this.isAlive()) {
                try {
                    //从输入流中读取一行信息
                    String strMsg = br.readLine();
                    if (strMsg != null) {
                        // SimpleDateFormat日期格式化类，指定日期格式为
                        //“年-月-日 时：分：秒”
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //获取当前系统时间
                        String strTime = dateFormat.format(new Date());
                        //将时间和信息添加到信息联邦集合中
                        msgList.addFirst("<==" + strTime + "==>\n" + strMsg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //给所有客户发送聊天信息的线程
    class SendMsgToClient extends Thread {
        public void run() {
            while (this.isAlive()) {
                try{
                    //如果信息链表不为空
                    if (!msgList.isEmpty()){
                        //取信息链表集合中的最后一条，并移除
                        String msg = msgList.removeLast();
                        //对输出流列表集合遍历，循环发送信息给所有客户端
                        for(int i= 0;i<pw.size();i++){
                            pw.get(i).println(msg);
                            pw.get(i).flush();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        new Server();
    }
}