package homework;
import java.io.*;
public class Student implements Serializable{
    String id,name,grade,clas,major;
    Student(String id,String name,String clas,String grade,String major){
        this.id=id;
        this.name=name;
        this.clas=clas;
        this.grade=grade;
        this.major=major;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setClas(String clas) {
        this.clas = clas;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getClas(){
        return clas;
    }
    public String getGrade(){
        return grade;
    }
    public String getMajor(){
        return major;
    }
    public String toString(){
        return "学号："+this.id+"名字:"+this.name+"班级:"+this.clas+"年级:"+this.grade+"专业:"+this.major+"\n";
    }

}
