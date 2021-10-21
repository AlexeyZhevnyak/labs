import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTxtRunner {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        int j = 0;


        while (j < 10) {
            j++;
            if (j % 2 == 0) {
                exec.execute(new ClientTxtRunnable("src/lab1/logs.txt"));

            } else
                exec.execute(new ClientTxtRunnable("src/lab1/logs.xml"));
        }

        exec.shutdown();
    }
}
