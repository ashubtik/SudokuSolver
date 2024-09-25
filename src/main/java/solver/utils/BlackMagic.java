package solver.utils;

import org.junit.Assert;
import solver.entities.Cell;
import solver.entities.Table;

import static solver.utils.Utility.*;

public class BlackMagic {
    private static int counter;

    public static void prohibitedTrick(Table table, int option) {
        Assert.assertTrue("Option should be 0 or 1", isZeroOrOne(option));
        for (Cell cell : getAllCellsByRowOrder(table)) {
            var possibleValues = cell.getPossibleValues();
            if (cell.getValue() == 0 && possibleValues.size() == 2) {
                System.out.println("Setting a value " + possibleValues.get(option) + " to cell " + cell.getCoordinates());
                cell.setValue(possibleValues.get(1));
                removeNumberFromPotentialValues(table, cell, possibleValues.get(option));
                break;
            }
        }
        resolveBoard(table);
    }

    private static boolean isZeroOrOne(int option) {
        return option == 0 || option == 1;
    }

    public static void resolveBoard(Table table) {
        while (areEmptyCellsFound(table)) {
            counter++;
            var emptyCellsNumberBefore = getEmptyCellsNumber(table);
            var potentialValuesNumberBefore = getPotentialValuesNumber(table);
            System.out.println("Empty cells before " + counter + " iteration - " + emptyCellsNumberBefore);
            System.out.println("Potential values before " + counter + " iteration - " + potentialValuesNumberBefore);

            removeOverlappingPairs(table);
            removeOverlappingCombinations(table);
            setSingletonValues(table);
            setSingleEntityNumberValues(table);

            System.out.println(getPotentialValuesLists(table));
            System.out.println(table);

            var emptyCellsNumberAfter = getEmptyCellsNumber(table);
            var potentialValuesNumberAfter = getPotentialValuesNumber(table);
            System.out.println("Empty cell after " + counter + " iteration - " + emptyCellsNumberAfter);
            System.out.println("Potential values after " + counter + " iteration - " + potentialValuesNumberAfter);
            System.out.println("==========================================");

            if (potentialValuesNumberBefore == potentialValuesNumberAfter
                    && emptyCellsNumberBefore == emptyCellsNumberAfter) {
                break;
            }
        }
    }
}
