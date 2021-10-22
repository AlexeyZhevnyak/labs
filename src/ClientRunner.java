import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientRunner {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        int i = 0;
        while (i < 10) {
            i++;
            if (i % 2 == 0) {
                exec.execute(new ClientRunnable("src/lab1/logs.txt"));
            } else
                exec.execute(new ClientRunnable("src/lab1/logs.xml"));
        }
        exec.shutdown();
    }
}
