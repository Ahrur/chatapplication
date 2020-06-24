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
                String msgouten = new String();
                String msginen = new String();
                char c;
                for(int i=0; i<msgout.length(); i++){
                    c = msgout.charAt(i);
                    c = (char) ((int)c - 1);
                    msgouten += Character.toString(c);
                }
                dout.writeUTF(msgouten);

                msgin = din.readUTF();
                char e;
                for(int j=0; j<msgin.length(); j++){
                    e = msgin.charAt(j);
                    e = (char) ((int)e + 1);
                    msginen += Character.toString(e);
                }
                System.out.println("Server: "+msginen);
            }

        }catch (Exception e){
            // do some exception handling
        }
    }
}
