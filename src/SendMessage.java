import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage implements Runnable{
    static Scanner sc = new Scanner(System.in);
    private Socket pS;
    String str;

    public SendMessage(Socket s ,String str){
        pS = s;
        this.str = str;
    }

    @Override
    public void run() {
        try {

            OutputStream OS =pS.getOutputStream();
            PrintWriter PW = new PrintWriter(OS,true);

            while (true){
                PW.println( str +" : "+ sc.nextLine() );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
