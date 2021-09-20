package sco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
//聊天室客户端
public class cont1 extends JFrame {
    Socket socket;
    PrintWriter pWriter;
    BufferedReader br;
    JPanel panel;
    JScrollPane sPane;
    JTextArea txtContent;
    JLabel lblName,lblSend;
    JTextField txtName,txtSend;
    JButton btnSend;

    public cont1(){
        super("QST聊天室");
        txtContent=new JTextArea();
        //设置文本域为只读
        txtContent.setEditable(false);
        sPane=new JScrollPane(txtContent);

        lblName=new JLabel("昵称：");
        txtName=new JTextField(5);
        lblSend=new JLabel("发言：");
        txtSend=new JTextField(20);
        btnSend=new JButton("发送");

        panel=new JPanel();
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSend);
        panel.add(txtSend);
        panel.add(btnSend);
        this.add(panel,BorderLayout.SOUTH);

        this.add(sPane);
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            //创建一个套接字
            socket=new Socket("172.24.148.79",28888);
            //创建一个往套接字中写数据的管道，即输出流，给服务器发送信息
            pWriter =new PrintWriter(socket.getOutputStream());
            //创建一个套接字读取数据的管道，即输入流，读取返回的信息
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }

        //注册监听
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的文本
                String strname=txtName.getText();
                String strMsg=txtSend.getText();
                if(!strMsg.equals("")){
                    //通过输出流将数据发送
                    pWriter.println(strname+"说："+strMsg);
                    pWriter.flush();
                    //清空文本框
                    txtSend.setText("");
                }
            }
        });
        //启动线程
        new GetMsgFromServer().start();
    }

    //接收服务器信息的线程
    class GetMsgFromServer extends Thread{
        public void run(){
            while(this.isAlive()){
                try{
                    String strMsg= br.readLine();
                    if(strMsg!=null){
                        //在文本域中显示聊天信息
                        txtContent.append(strMsg+"\n");
                    }
                    Thread.sleep(50);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        //创建聊天室客户端窗口实例化
        new cont().setVisible(true);
    }
}
