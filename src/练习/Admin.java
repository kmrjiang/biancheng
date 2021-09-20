package 练习;

public class Admin {
    private String id;
    private String name;
    private String password;
    public void setPassword(String password) {
        this.password = password;
    }
    public void setID(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
}
