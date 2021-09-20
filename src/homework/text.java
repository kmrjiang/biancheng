package homework;
import java.io.*;
public class text {
    public static void main(String args[]) {
        try(ObjectOutputStream obs=new ObjectOutputStream(new FileOutputStream("E://zuoye//stu.txt"))) {
            Student stu1=new Student("1","小王","软二","2020","计算机");
            Student stu2=new Student("2","小明","软二","2020","计算机");
            Student stu3=new Student("3","小红","软二","2020","计算机");
            Student stu4=new Student("4","小芬","软二","2020","计算机");
            obs.writeObject(stu1);
            obs.writeObject(stu2);
            obs.writeObject(stu3);
            obs.writeObject(stu4);
            obs.flush();
            System.out.println("记录完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E://zuoye//stu.txt"))) {
            Student st1=(Student)ois.readObject();
            Student st2=(Student)ois.readObject();;
            Student st3=(Student)ois.readObject();;
            Student st4=(Student)ois.readObject();;
           System.out.println("读取成功");
            System.out.println(st1);
            System.out.println(st2);
            System.out.println(st3);
            System.out.println(st4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
