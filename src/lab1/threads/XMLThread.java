package lab1.threads;

import lab1.Buffer;
import lab1.InputException;
import lab1.Message;
import lab1.tables.VisitLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLThread implements Runnable {

    private Buffer buffer;
    private String filePath;

    public XMLThread(Buffer buffer, String filePath) {
        this.buffer = buffer;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine())
                content.append(scanner.nextLine()).append('\n');

            String regex = "(?<=<.{1,10}>)(.*)(?=</.*>)";
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(content);

            int count = (int) matcher.results()
                    .count();
            int i = 0;
            matcher.reset();
            while (matcher.find()) {
                int idBuy = Integer.parseInt(matcher.group());
                matcher.find();
                int idPC = Integer.parseInt(matcher.group());
                matcher.find();
                int idEmployee = Integer.parseInt(matcher.group());
                matcher.find();
                final String group = matcher.group();
                Date date = Date.valueOf(group);

//                buffer.add(new Message("xml", new VisitLog(i++,
//                        idBuy,
//                        idPC,
//                        idEmployee,
//                        date
//                )));
                System.out.println(new Message("xml", new VisitLog(i++,
                        idBuy,
                        idPC,
                        idEmployee,
                        date
                )));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.incStopCount();
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
    }
}
