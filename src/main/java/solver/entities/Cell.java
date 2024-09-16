package solver.entities;

import lombok.Data;
import org.junit.Assert;

import java.util.List;
import java.util.Objects;

import static solver.utils.Utility.isBetween0And9;

@Data
public class Cell {
    private final Coordinates coordinates;
    private int value;
    private List<Integer> possibleValues;

    public Cell(Coordinates coordinates, int value) {
        Assert.assertTrue("Cell value should be within range 1-9", isBetween0And9(value));
        this.coordinates = coordinates;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell cell)) return false;
        return Objects.equals(coordinates, cell.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
