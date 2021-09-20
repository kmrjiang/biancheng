package homework;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class bu {
    public static void main(String args[]){
        Student stu1=new Student("1","小王","软二","2020","计算机");
        Student stu2=new Student("2","小明","软二","2020","计算机");
        Student stu3=new Student("3","小红","软二","2020","计算机");
        Student stu4=new Student("4","小芬","软二","2020","计算机");
        File f=new File("E://zuoye//stu.txt");
        try( FileChannel outChannel=new FileOutputStream("E://zuoye//stu.txt").getChannel();
             FileChannel inChannel=new FileInputStream(f).getChannel();) {
            ByteBuffer buff=ByteBuffer.allocate(1000);
            buff.put(stu1.toString().getBytes());
            buff.put(stu2.toString().getBytes());
            buff.put(stu3.toString().getBytes());
            buff.put(stu4.toString().getBytes());
            buff.flip();
            outChannel.write(buff);
            //
            MappedByteBuffer buffer= inChannel.map(FileChannel.MapMode.READ_ONLY,0,f.length());
            buffer.clear();
            Charset charset= Charset.forName("UTF-8");
            CharsetDecoder decoder=charset.newDecoder();
            CharBuffer charbuff=decoder.decode(buffer);
            System.out.println(charbuff);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
