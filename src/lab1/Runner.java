package lab1;

import lab1.factories.VisitLogConsoleFactory;
import lab1.factories.VisitLogFileFactory;
import lab1.factories.VisitLogRandomFactory;
import lab1.tables.VisitLog;

import java.util.Arrays;
import java.util.Formatter;

//"src/lab1/logs.xml"
//"src/lab1/logs.txt"
public class Runner {
    public static void main(String[] args) {
        AbstractVisitLogFactory visitLogFactory = new VisitLogRandomFactory();
        VisitLog[] logs = visitLogFactory.input();
        Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
                "Тип абонемента",
                "Инвентарный номер ПК",
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

    static void output(VisitLog[] logs) {
        Arrays.stream(logs)
                .forEach(System.out::println);
    }
}