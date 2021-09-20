package 练习;
import java.util.*;
public class hotel {
    public static void main(String args[]) {
        LinkedList room = new LinkedList();
        room.add("你");
        room.add("好");
        int number = room.size();
        for (int i = 0; i < number; i++) {
            String temp = (String) room.get(i);
            System.out.println("第" + i + "节点中的数据" + temp);
        }
        Iterator iter = room.iterator();
        while (iter.hasNext()) {
            String te = (String) iter.next();
            System.out.println(te);
        }
    }
}
