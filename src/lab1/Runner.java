package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
//        VisitLog[] logs = consoleInput();
        VisitLog[] logs = randomInput();
//        VisitLog[] logs = fileInput("src/logs.txt");
//        VisitLog[] logs = xmlInput("src/logs.xml");
        Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
                "Тип абонемента",
                "Код ПК",
                "ФИО сотрудника",
                "Дата посещения");
        System.out.println(title);

        Arrays.sort(logs, (a, b) -> {
            int t1 = a.getIdSubscriptionBuy() - b.getIdSubscriptionBuy();
            if (t1 == 0) {

                int t2 = a.getIdPc() - b.getIdPc();
                if (t2 == 0)
                    return a.getIdEmployee() - b.getIdEmployee();

                return t2;
            }
            return t1;
        });
        output(logs);
    }

    static VisitLog[] consoleInput() {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность: ");
        n = scanner.nextInt();
        VisitLog[] logs = new VisitLog[n];
        for (int i = 0; i < n; i++) {

            System.out.println("Введите код покупки абонемента: ");
            int idBuy = scanner.nextInt();

            System.out.println("Введите код ПК: ");
            int idPc = scanner.nextInt();

            System.out.println("Введите код сотрудника: ");
            int idEmployee = scanner.nextInt();

            System.out.println("Введите дату посещения: ");

            Date visitDate = Date.valueOf(scanner.next());
            logs[i] = new VisitLog(i, idBuy, idPc, idEmployee, visitDate);
        }
        return logs;
    }

    static VisitLog[] randomInput() {
        int n = (int) (Math.random() * 11);
        VisitLog[] logs = new VisitLog[n];
        for (int i = 0; i < n; i++) {
            Date.valueOf(LocalDate.now());
            LocalDate now = LocalDate.now();
            now = now.minusWeeks((long) (Math.random() * 100));


            logs[i] = new VisitLog(i,
                    (int) (Math.random() * SubscriptionBuyings.map.size()),
                    (int) (Math.random() * PCs.map.size()),
                    (int) (Math.random() * Employees.map.size()),
                    Date.valueOf(now));
        }
        return logs;
    }


    static VisitLog[] fileInput() throws FileNotFoundException {
        int n = 0;
        Scanner scanner = new Scanner(new File("src/lab1/logs.txt"));
        while (scanner.hasNext()) {
            scanner.nextLine();
            n++;
        }
        scanner.close();

        VisitLog[] logs = new VisitLog[n];
        scanner = new Scanner(new File("src/lab1/logs.txt"));
        for (int i = 0; i < n; i++) {
            String[] lines = scanner.nextLine().split(";");
            logs[i] = new VisitLog(
                    i,
                    Integer.parseInt(lines[0]),
                    Integer.parseInt(lines[1]),
                    Integer.parseInt(lines[2]),
                    Date.valueOf(lines[3])
            );
        }
        return logs;
    }

    static VisitLog[] xmlInput(String filePath) throws FileNotFoundException {
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
    }

    static void output(VisitLog[] logs) {
        Arrays.stream(logs)
                .forEach(System.out::println);
    }


}
