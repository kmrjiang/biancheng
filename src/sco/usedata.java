package sco;
import lian.cla;

import java.sql.*;
import java.util.*;
public class usedata {
    public void checkage(int age){
        int age1=age;
        String sql1="select * from t_student where age<'"+age1+"'";
        String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
        String user="root";
        String pwd="123456";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pwd);
        System.out.println("请输入年龄，查询小于该岁数的学生");
        Statement st1=con.prepareStatement(sql1);
        ResultSet rs1=st1.executeQuery(sql1);
        while(rs1.next()){
            System.out.println("学号:"+rs1.getString("id")+" 姓名："+rs1.getString("name")+" 年龄："+rs1.getString("age"));
        }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public usedata(){
        String sql="select * from t_student";
        String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
        String user="root";
        String pwd="123456";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pwd);
            Statement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println("学号:"+rs.getString("id")+" 姓名："+rs.getString("name")+" 年龄："+rs.getString("age"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}