package 练习;

public  class Students implements Comparable{
    int height=0;
    String name;
    public Students(String n,int h){
        name=n;
        height=h;
    }
    public int compareTo(Object b) {
        Students st=(Students)b;
        return (this.height-st.height);

    }

}
