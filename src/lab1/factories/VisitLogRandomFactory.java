package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.holders.EmployeeHolder;
import lab1.holders.PcHolder;
import lab1.holders.SubscriptionBuyHolder;
import lab1.tables.VisitLog;

import java.sql.Date;
import java.time.LocalDate;

public class VisitLogRandomFactory implements AbstractVisitLogFactory {
    @Override
    public VisitLog[] input() {
        int n = 5 + (int) (Math.random() * 11);
        VisitLog[] logs = new VisitLog[n];
        for (int i = 0; i < n; i++) {
            LocalDate now = LocalDate.now();
            now = now.minusWeeks((long) (Math.random() * 100));

            logs[i] = new VisitLog(i,
                    (int) (Math.random() * SubscriptionBuyHolder.map.size()),
                    (int) (Math.random() * PcHolder.map.size()),
                    (int) (Math.random() * EmployeeHolder.map.size()),
                    Date.valueOf(now));
        }
        return logs;
    }
}
