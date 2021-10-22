import lab1.tables.VisitLog;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.concurrent.Semaphore;

public class ClientRunnable implements Runnable {
    private Socket socket;
    private final String filePath;
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public ClientRunnable(String filePath) {
        this.filePath = filePath;
        try {

            socket = new Socket("localhost", 3345);
            System.out.println("Client connected to socket");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            File file = new File(filePath);
            oos.writeObject(file);
            ArrayList<VisitLog> visitLogs = (ArrayList<VisitLog>) ois.readObject();
            SEMAPHORE.acquire();
            Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
                    "Тип абонемента",
                    "Инвентарный номер ПК",
                    "ФИО сотрудника",
                    "Дата посещения");
            System.out.println(title);
            visitLogs.forEach(System.out::println);
            System.out.println("---------------------------");
            SEMAPHORE.release();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
