package sco;
import lian.cla;
import java.util.*;
import java.sql.*;
import java.util.*;
public class usedata {
    public void checkage(){
        String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
        String user="root";
        String pwd="123456";
        System.out.println("请输入年龄，查询小于该岁数的学生");
        Scanner inte=new Scanner(System.in);
        String age1=inte.next();
        String sql1="select * from t_student where age<'"+age1+"'";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pwd);

        Statement st1=con.prepareStatement(sql1);
        ResultSet rs1=st1.executeQuery(sql1);
        System.out.println("小于该年龄的学生有：");
        int i=0;
        while(rs1.next()){
            i++;
            System.out.println("学号:"+rs1.getString("id")+" 姓名："+rs1.getString("name")+" 年龄："+rs1.getString("age"));
        }
        if(i==0){
            System.out.println("无小于该年龄的学生");
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