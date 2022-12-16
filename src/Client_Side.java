import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_Side {
    public static void main(String[] args) {

        try {
            Socket clientConnection = new Socket("localhost",10000);

           String str = "From Client";
            SendMessage send = new SendMessage(clientConnection,str);
            Thread thread = new Thread(send);
            thread.start();

            Thread t = new Thread(new ReceiveMessage(clientConnection));
            t.start();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
