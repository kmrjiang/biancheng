package sco;
import java.sql.*;
import java.util.*;
public class usedate2 {
    String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
    String user="root";
    String pwd="123456";
    //构造方法cheack()查看所有学生信息
    public void cheack(){
        String sql="select * from t_student";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pwd);
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                System.out.println("学号:"+rs.getString("id")+" 姓名："+rs.getString("name")+" 年龄："+rs.getString("age"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //添加学生信息
    public void AddStuend(){
        String sql1 = "insert into t_student values(?,?,?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pwd);
            PreparedStatement ps= con.prepareStatement(sql1);
            System.out.println("添加学号");
            Scanner inte1=new Scanner(System.in);
            String id= inte1.next();
            System.out.println("添加名字");
            Scanner inte2=new Scanner(System.in);
            String name= inte2.next();
            System.out.println("添加年龄");
            Scanner inte3=new Scanner(System.in);
            String age= inte3.next();
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3, String.valueOf(age));
            ps.executeLargeUpdate();
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //修改学生年龄
    public void changeage(){
        System.out.println("输入学号");
        Scanner inte1=new Scanner(System.in);
        String id= inte1.next();
        System.out.println("输入要修改的年龄");
        Scanner inte2=new Scanner(System.in);
        String age1= inte2.next();
        String sql = "update t_student set age=age1 where id='"+id+"'";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //删除学生信息
    public void dete(){
        System.out.println("输入要删除学生的学号");
        Scanner inte=new Scanner(System.in);
        String id= inte.next();
        String sql = "delete from t_student where id='"+id+"'";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pwd);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeLargeUpdate();
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
