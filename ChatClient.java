import java.io.*;  
import java.net.*;
import java.util.Scanner;  
public class ChatClient {  
    public static void main(String[] args) 
    {  
        System.out.println("To end chat press 'q'");
        Scanner sc = new Scanner(System.in);
        try
        {      
            Socket s =new Socket("localhost",6000);  
            DataInputStream dis=new DataInputStream(s.getInputStream()); 
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            String message = "";
            while(true)
            {
                System.out.print("[Client]Enter message : ");
                message = sc.nextLine();
                if(message.equals("q")) break;
                dout.writeUTF(message);  
                String  str=dis.readUTF();  
                System.out.println("[Client]Message from server = "+str); 

            }  
            dout.close();  
            s.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  