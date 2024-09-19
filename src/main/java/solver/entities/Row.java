package solver.entities;

import java.util.List;

public class Row extends BaseEntity {

    public Row(List<Cell> cells) {
        super(cells);
    }

    @Override
    public String toString() {
        return "\n" + cells.get(0).getValue() + " " + cells.get(1).getValue() + " " + cells.get(2).getValue() + " | "
                + cells.get(3).getValue() + " " + cells.get(4).getValue() + " " + cells.get(5).getValue() + " | "
                + cells.get(6).getValue() + " " + cells.get(7).getValue() + " " + cells.get(8).getValue();
    }
}
