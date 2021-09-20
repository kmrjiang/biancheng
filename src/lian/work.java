package lian;

import 练习.Admin;

import java.sql.*;
import java.util.*;

public class work {
    Admin admin;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://172.24.148.79:3306/work? useSSL=true";
    String user = "root";
    String password = "123456";
    public boolean work(String id,String psw) throws SQLException, ClassNotFoundException {
            String sql2 = "select * from user where id=? and password=?";
            Connection conn = null;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, admin.getID());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Admin admin=new Admin();
            admin.setID(rs.getString("id"));
            admin.setPassword(rs.getString("password"));
            admin.setName(rs.getString("name"));
        }
            int ans = 0;
            if (rs.next()) {
                ans = 1;
            }
            rs.close();
            ps.close();
            conn.close();
            if (ans == 1) {
                return true;
            } else {
                return false;
            }
    }
//    int JudgeAdmin(){
//        try {
//            if(work(String id,String psw)) {
//                System.out.println("登录成功");
//                return 1;
//            }else
//                System.out.println("登陆失败");
//                 return 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("登陆失败");
//        return 0;
//    }
}
