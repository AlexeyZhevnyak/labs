package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.tables.VisitLog;

import java.sql.Date;
import java.util.Scanner;

public class VisitLogConsoleFactory implements AbstractVisitLogFactory {

    @Override
    public VisitLog[] input() {
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
}
