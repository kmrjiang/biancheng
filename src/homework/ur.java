package homework;
import java.io.*;
import java.net.*;
public class ur {
    public static void main(String args[]){
        try {
            URL web=new URL("https://www.gcu.edu.cn/");
            URLConnection urlcon=web.openConnection();
            urlcon.setRequestProperty("Charest","UTF-8");
            File f=new File("E:\\zuoye\\1.html");
            BufferedReader br=new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
            String inputLine;
            while ((inputLine =br.readLine() )!= null){
                System.out.println(inputLine);
                bw.write(inputLine);
                bw.flush();
            }
            br.close();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
