import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ExecutorService executeIt = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3345)) {
            System.out.println("Server start");
            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new ServerRunnable(client));
            }
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
