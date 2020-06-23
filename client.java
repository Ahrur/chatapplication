import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("127.0.0.1",1201);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin = "", msgout="";

            while (!msgin.equals("end")){
                msgout = br.readLine();
                char[] msgouten = msgout.toCharArray();
                for(char c : msgouten){
                    c+=5;
                }
                dout.writeUTF(msgout);

                msgin = din.readUTF();
                char[] msginen = msgout.toCharArray();
                for(char c : msginen){
                    c-=5;
                }
                System.out.println(msgin);
            }

        }catch (Exception e){

        }
    }
}
