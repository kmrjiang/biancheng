package lian;

import java.sql.*;
import java.util.*;
public class Teacher {
    Admin admin;
    ResultSet rs=null;
    Connection con = null;
    Statement sql;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://172.24.148.79:3306/work? useSSL=true";
    String user = "root";
    String password = "123456";
    public void checkcalss(){
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, user, password);
                    String sql2 ="select * from class";
                    PreparedStatement ps = con.prepareStatement(sql2);
                    ps=con.prepareStatement(sql2);
                    rs=ps.executeQuery();
                    while(rs.next()){
                    cla cla1=new cla();
                        cla1.setClassnumber(rs.getString("classnumber"));
                        cla1.setName(rs.getString("name"));
                        cla1.setGrade(rs.getString("grade"));
                        System.out.println("课程号"+cla1.getClassnumber()+"课程"+cla1.getName()+" 年级"+cla1.getGrade());
                    }
                } catch (Exception e) {
                        e.printStackTrace();
                }
    }
    public void setcalss(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("设置课程号");
            Scanner inte1=new Scanner(System.in);
            String classnumber= inte1.next();
            System.out.println("设置课程名");
            Scanner inte2=new Scanner(System.in);
            String name= inte2.next();
            System.out.println("设置年级");
            Scanner inte3=new Scanner(System.in);
            String grade= inte3.next();
            System.out.println("设置专业");
            Scanner inte4=new Scanner(System.in);
            String major= inte4.next();
            System.out.println("设置学分");
            Scanner inte5=new Scanner(System.in);
            String credit= inte5.next();
            String sql3 = "insert into calss values('classnumber','name','grade','major','credit')";
            PreparedStatement ps = con.prepareStatement(sql3);
            rs = ps.executeQuery();
            System.out.println("设置成功");
        }catch (Exception e) {
            System.out.println("设置失败");
            e.printStackTrace();
        }
    }
    public void datecalss(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            Scanner inte=new Scanner(System.in);
            String classid= inte.next();
            String sql4 = "delete from calss where classnumber='classid' ";
            PreparedStatement ps = con.prepareStatement(sql4);
            rs = ps.executeQuery();
            System.out.println("删除成功");
        }catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
    }
    public void cheack(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql5 = "select * from choose";
            PreparedStatement ps = con.prepareStatement(sql5);
            ps=con.prepareStatement(sql5);
            rs=ps.executeQuery();
            System.out.println("输入查询的课程号");
            Scanner inte=new Scanner(System.in);
            String classid= inte.next();
            int num=0;
            while(rs.next()){
                String name ,grade;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
