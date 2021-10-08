package lab1;

import lab1.factories.VisitLogRandomFactory;
import lab1.tables.VisitLog;

import java.util.*;

//"src/lab1/logs.xml"
//"src/lab1/logs.txt"
public class Runner {
    public static void main(String[] args) {
        AbstractVisitLogFactory visitLogFactory = new VisitLogRandomFactory();
        List<VisitLog> logs = visitLogFactory.input();
        Formatter title = new Formatter().format("%20s  %20s  %20s  %40s  %20s", "Код посещения",
                "Тип абонемента",
                "Инвентарный номер ПК",
                "ФИО сотрудника",
                "Дата посещения");
        System.out.println(title);
        logs.sort((a, b) -> {
            int t1 = a.getIdSubscriptionBuy() - b.getIdSubscriptionBuy();
            if (t1 == 0) {

                int t2 = a.getIdEmployee() - b.getIdEmployee();
                if (t2 == 0)
                    return a.getIdPc() - b.getIdPc();

                return t2;
            }
            return t1;
        });
//        Collections.sort(logs);
        output(logs);
    }

    static void output(List<VisitLog> logs) {
        Iterator<VisitLog> iterator = logs.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}