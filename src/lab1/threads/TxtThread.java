package lab1.threads;

import lab1.Buffer;
import lab1.InputException;
import lab1.Message;
import lab1.tables.VisitLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtThread implements Runnable {
    private final Buffer buffer;
    private final String filePath;

    public TxtThread(Buffer buffer, String filePath) {
        this.buffer = buffer;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int n = 0;
            while (scanner.hasNext()) {
                scanner.nextLine();
                n++;
            }
            scanner.close();

            List<VisitLog> logs = new ArrayList<>();
            scanner = new Scanner(new File(filePath));
            for (int i = 0; i < n; i++) {
                String[] lines = scanner.nextLine().split(";");
//                buffer.add(new Message("txt", new VisitLog(
//                        i,
//                        Integer.parseInt(lines[0]),
//                        Integer.parseInt(lines[1]),
//                        Integer.parseInt(lines[2]),
//                        Date.valueOf(lines[3])
//                )));
                System.out.println(new Message("txt", new VisitLog(
                        i,
                        Integer.parseInt(lines[0]),
                        Integer.parseInt(lines[1]),
                        Integer.parseInt(lines[2]),
                        Date.valueOf(lines[3])
                )));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
        buffer.incStopCount();
    }
}
