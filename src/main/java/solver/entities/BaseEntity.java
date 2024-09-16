package solver.entities;

import lombok.Getter;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Getter
public class BaseEntity {
    protected List<Cell> cells;

    public BaseEntity(List<Cell> cells) {
        assertEquals("Object should contain 9 cells but actually - " + cells.size(), 9, cells.size());
        this.cells = cells;
    }

    public boolean isUnique(int digit) {
        return cells
                .stream()
                .map(Cell::getValue)
                .filter(number -> number != 0)
                .noneMatch(number -> number == digit);
    }
}
