package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.InputException;
import lab1.tables.VisitLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitLogXMLFactory implements AbstractVisitLogFactory {
    private final String filePath;

    public VisitLogXMLFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public VisitLog[] input() {
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
            VisitLog[] logs = new VisitLog[count / 4];
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
                logs[i] = new VisitLog(i++,
                        idBuy,
                        idPC,
                        idEmployee,
                        date
                );
            }
            return logs;
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
    }
}
