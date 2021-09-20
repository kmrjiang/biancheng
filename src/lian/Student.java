package lian;

import java.sql.*;

public class Student {
        Connection con = null;
        Statement sql;
        ResultSet rs=null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://172.24.148.79:3306/work? useSSL=true";
        String user = "root";
        String password = "123456";
        Admin admin;
        public void checkcalss(){
            ResultSet rs=null;
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
                    System.out.println(cla1.getClassnumber()+" "+cla1.getName()+" "+cla1.getGrade());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void chooseclass(){
        System.out.println("输入课程号选课");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql ="select * from class";
            PreparedStatement ps = con.prepareStatement(sql);
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
