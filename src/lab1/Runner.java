package lab1;

import lab1.threads.RandomThread;
import lab1.threads.TxtThread;
import lab1.threads.XMLThread;

import java.util.Formatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//"src/lab1/logs.xml"
//"src/lab1/logs.txt"
public class Runner {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Runnable randomThread = new RandomThread(buffer);
        Runnable txtThread = new TxtThread(buffer, "src/lab1/logs.txt");
        Runnable xmlThread = new XMLThread(buffer, "src/lab1/logs.xml");

        Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
                "Тип абонемента",
                "Инвентарный номер ПК",
                "ФИО сотрудника",
                "Дата посещения");
        System.out.println(title);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(randomThread);
        executorService.execute(txtThread);
        executorService.execute(xmlThread);
//        buffer.print();
        executorService.shutdown();
    }

}