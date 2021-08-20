import java.io.*;  
import java.net.*;
import java.util.Scanner;

public class ChatServer 
{  
    public static void main(String[] args)
    {  
        Scanner sc = new Scanner(System.in);
        try
        {  
            ServerSocket ss = new ServerSocket(6000);  
            System.out.println("Server up and running on port 6000");
            Socket s=ss.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
            String message = "";
            while(true)
            {
                String  str=dis.readUTF();  
                System.out.println("[SERVER]Message from client = "+str);
                System.out.print("[SERVER]Enter Reply = ");
                message = sc.nextLine();
                if(message.equals("q")) break;
                dout.writeUTF(message);  
            }
            ss.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  