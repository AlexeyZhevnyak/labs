package lab1.factories;

import lab1.AbstractVisitLogFactory;
import lab1.InputException;
import lab1.tables.VisitLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VisitLogFileFactory implements AbstractVisitLogFactory {
    private final String filePath;

    public VisitLogFileFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VisitLog> input() {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int n = 0;
            while (scanner.hasNext()) {
                scanner.nextLine();
                n++;
            }
            scanner.close();

            List<VisitLog> logs = new ArrayList<>();
            scanner = new Scanner(new File(filePath));
            for (int i = 0; i < n; i++) {
                try {
                    String[] lines = scanner.nextLine().split(";");
                    logs.add(new VisitLog(
                            i,
                            Integer.parseInt(lines[0]),
                            Integer.parseInt(lines[1]),
                            Integer.parseInt(lines[2]),
                            Date.valueOf(lines[3])
                    ));
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            logs.removeIf(Objects::nonNull);
//            logs = Arrays.stream(logs)
//                    .filter(Objects::nonNull)
//                    .toArray(VisitLog[]::new);
            return logs;
        } catch (FileNotFoundException e) {
            throw new InputException(e);
        }
    }
}
