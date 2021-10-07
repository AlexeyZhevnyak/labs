package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.tables.VisitLog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitLogConsoleFactory implements AbstractVisitLogFactory {

    @Override
    public List<VisitLog> input() {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность: ");
        n = scanner.nextInt();
        List<VisitLog> logs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Введите код покупки абонемента: ");
            int idBuy = scanner.nextInt();
            System.out.println("Введите код ПК: ");
            int idPc = scanner.nextInt();

            System.out.println("Введите код сотрудника: ");
            int idEmployee = scanner.nextInt();

            System.out.println("Введите дату посещения: ");

            Date visitDate = Date.valueOf(scanner.next());
            logs.add(new VisitLog(i, idBuy, idPc, idEmployee, visitDate));
        }
        return logs;
    }
}
