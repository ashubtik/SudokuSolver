package solver.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Table {
    private List<Row> rows;
    private List<Column> columns;
    private List<Square> squares;

    @Override
    public String toString() {
        return rows.toString();
    }
}
