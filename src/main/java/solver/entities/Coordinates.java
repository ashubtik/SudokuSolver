package solver.entities;

import org.junit.Assert;

public record Coordinates(int x, int y) {
    public Coordinates {
        Assert.assertTrue("X coordinate should be greater than 0", x > 0);
        Assert.assertTrue("X coordinate should be lower than 10", x < 10);
        Assert.assertTrue("Y coordinate should be greater than 0", y > 0);
        Assert.assertTrue("Y coordinate is below 0", y < 10);
    }
}
