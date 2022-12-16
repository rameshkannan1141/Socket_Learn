import com.sun.source.doctree.EndElementTree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;



public class Server_Side {


    public static void main(String[] args) {

        try{
            ServerSocket ss = new ServerSocket(10000);

            Socket connection = ss.accept();
            System.out.println("Client connected successfully........");

//            SendMessageTo_Client send = new SendMessageTo_Client(connection);
            String str = "From Server";
            Thread thread = new Thread(new SendMessage(connection,str));
            thread.start();

            Thread t = new Thread(new ReceiveMessage(connection));
            t.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


