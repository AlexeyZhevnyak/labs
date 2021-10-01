package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.IncorrectIdException;
import lab1.InputException;
import lab1.holders.SubscriptionBuyHolder;
import lab1.tables.VisitLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VisitLogFileFactory implements AbstractVisitLogFactory {
    private final String filePath;

    public VisitLogFileFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public VisitLog[] input() {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int n = 0;
            while (scanner.hasNext()) {
                scanner.nextLine();
                n++;
            }
            scanner.close();

            VisitLog[] logs = new VisitLog[n];
            scanner = new Scanner(new File(filePath));
            for (int i = 0; i < n; i++) {
                try {
                    String[] lines = scanner.nextLine().split(";");
                    logs[i] = new VisitLog(
                            i,
                            Integer.parseInt(lines[0]),
                            Integer.parseInt(lines[1]),
                            Integer.parseInt(lines[2]),
                            Date.valueOf(lines[3])
                    );
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            logs = Arrays.stream(logs)
                    .filter(Objects::nonNull)
                    .toArray(VisitLog[]::new);
            return logs;
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
    }
}
