package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
////        VisitLog[] logs = consoleInput();
//        VisitLog[] logs = randomInput();
////        VisitLog[] logs = fileInput();
//        Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
//                "Тип абонемента",
//                "Код ПК",
//                "ФИО сотрудника",
//                "Дата посещения");
//        System.out.println(title);
////        Arrays.sort(logs, Comparator.comparing(o -> o.getDate().toString()));
//        Arrays.sort(logs, Comparator.comparing(a -> SubscriptionBuyings.map.get(a.getIdSubscriptionBuy()).getSubscriptionType().getName()));
//        output(logs);
        Scanner scanner = new Scanner(new File("src/lab1/logs.xml"));
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
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

    static void output(VisitLog[] logs) {
        Arrays.stream(logs)
                .forEach(System.out::println);
    }


}
