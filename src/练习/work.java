package 练习;
import java.util.*;
public class work {
    public static void main(String args[]) {
        List<Students> list=new LinkedList<Students>();
        list.add(new Students("张三",188));
        list.add(new Students("李四",178));
        list.add(new Students("王五",198));
        Iterator<Students> iter=list.iterator();
        System.out.println("排列前，链表中的数据");
        while(iter.hasNext()) {
            Students stu=iter.next();
            System.out.println(stu.name+"身高:"+stu.height);
        }
        Collections.sort(list);
        System.out.println("排列后，链表中的数据");
        iter=list.iterator();
        while(iter.hasNext()){
            Students stu=iter.next();
            System.out.println(stu.name+"身高:"+stu.height);
        }
        Students zhaoLin=new Students("zhao xiao",178);
        int index=Collections.binarySearch(list,zhaoLin,null);
        if(index>=0) {
            System.out.println(zhaoLin.name+"和链表中"+list.get(index).name+"身高相同");
        }
    }
}