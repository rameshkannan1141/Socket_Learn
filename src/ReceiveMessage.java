import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveMessage implements Runnable{

    private Socket pS;

    public ReceiveMessage(Socket s){
        pS = s;
    }
    public void run() {
        try {
            InputStream IS = pS.getInputStream();
            Scanner sc = new Scanner(IS);
//            PrintWriter PW = new PrintWriter(pS.getOutputStream(),true);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());

//                SendMessageTo_Client send = new SendMessageTo_Client(pS);
//                Thread thread = new Thread(send);
//                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}