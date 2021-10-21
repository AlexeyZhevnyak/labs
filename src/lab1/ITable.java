package lab1;

import java.io.Serializable;

public interface ITable extends Comparable<ITable>, Serializable {
    String getEntryView();
}
