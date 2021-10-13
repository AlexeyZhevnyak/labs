package lab1.threads;

import lab1.Buffer;
import lab1.Message;
import lab1.holders.EmployeeHolder;
import lab1.holders.PcHolder;
import lab1.holders.SubscriptionBuyHolder;
import lab1.tables.VisitLog;

import java.sql.Date;
import java.time.LocalDate;

public class RandomThread implements Runnable {
    private Buffer buffer;

    public RandomThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int n = 5 + (int) (Math.random() * 11);
        for (int i = 0; i < n; i++) {
            LocalDate now = LocalDate.now();
            now = now.minusWeeks((long) (Math.random() * 100));
            buffer.add(new Message("random", new VisitLog(i,
                    (int) (Math.random() * SubscriptionBuyHolder.map.size()),
                    (int) (Math.random() * PcHolder.map.size()),
                    (int) (Math.random() * EmployeeHolder.map.size()),
                    Date.valueOf(now))));
        }
        buffer.incStopCount();
    }
}
