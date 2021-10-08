package lab1.holders;

import lab1.IDHolder;
import lab1.tables.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeeHolder {
    private static int id = 0;
    private static final List<Integer> integers = IDHolder.set.stream().toList();

    public static Map<Integer, Employee> map = new HashMap<>() {{
        put(integers.get(id), new Employee(integers.get(id++), "Сухарев Андрей Сергеевич", "Администратор"));
        put(integers.get(id), new Employee(integers.get(id++), "Сурин Георгий Александрович", "Кассир"));
        put(integers.get(id), new Employee(integers.get(id++), "Топольцев Руслан Иванович", "Администратор"));
        put(integers.get(id), new Employee(integers.get(id++), "Иванов Иван Иванович", "Кассир"));
    }};
}
