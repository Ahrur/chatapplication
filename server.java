import java.io.*;
import java.net.*;

 class server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(1201);
            Socket s =ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "",msgout ="";

            while(!msgin.equals("end")){
                String msginen = new String();
                String msgouten = new String();

                msgin = din.readUTF();
                char c;

                for(int i=0; i<msgin.length(); i++){
                    c = msgin.charAt(i);
                    c = (char) ((int)c+1);
                    msginen += Character.toString(c);
                }
                System.out.println("Client: "+msginen);

                msgout = br.readLine();
                char e;
                for(int j=0; j<msgout.length(); j++){
                    e = msgout.charAt(j);
                    e = (char) ((int)e-1);
                    msgouten += Character.toString(e);
                }
                dout.writeUTF(msgouten);
                dout.flush();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

