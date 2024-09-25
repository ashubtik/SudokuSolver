package solver.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import solver.entities.BaseEntity;
import solver.entities.Cell;
import solver.entities.Coordinates;
import solver.entities.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class Utility {

    public static boolean isBetween1And9(int number) {
        return number > 0 && number < 10;
    }

    public static boolean isBetween0And9(int number) {
        return number >= 0 && number < 10;
    }

    public static boolean isUniqueEverywhere(Table table, Cell cell, int number) {
        Assert.assertTrue("Number is out of range 1-9", isBetween1And9(number));
        return isNumberUniqueForEntity(table.getRows(), cell, number) &&
                isNumberUniqueForEntity(table.getColumns(), cell, number) &&
                isNumberUniqueForEntity(table.getSquares(), cell, number);
    }

    private static <T extends BaseEntity> boolean isNumberUniqueForEntity(List<T> list, Cell cell, int number) {
        if (cell.getValue() != 0) {
            return false;
        }
        return list
                .stream()
                .filter(entity -> entity.getCells().contains(cell))
                .anyMatch(entity -> entity.isUnique(number));
    }

    public static void setPotentialValuesForTable(Table table) {
        getAllCellsByRowOrder(table)
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .forEach(cell -> setPotentialValuesForCell(table, cell));
    }

    private static void setPotentialValuesForCell(Table table, Cell cell) {
        cell.setPossibleValues(IntStream
                .range(1, 10)
                .filter(number -> isUniqueEverywhere(table, cell, number))
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static void setSingletonValues(Table table) {
        getAllCellsByRowOrder(table)
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .filter(cell -> cell.getPossibleValues().size() == 1)
                .forEach(cell -> {
                    var resultNumber = cell.getPossibleValues().get(0);
                    cell.setValue(resultNumber);
                    System.out.println("Setting singleton value " + resultNumber + " for cell " + cell.getCoordinates());
                    removeNumberFromPotentialValues(table, cell, resultNumber);
                });
    }

    public static void setSingleEntityNumberValues(Table table) {
        for (BaseEntity entity : getListOfEntities(table)) {
            for (Cell cell : entity.getCells()) {
                if (cell.getValue() == 0) {
                    for (Integer number : cell.getPossibleValues()) {
                        if (Collections.frequency(getPotentialValues(entity), number) == 1) {
                            cell.setValue(number);
                            System.out.println("Setting single entity value " + number + " for cell " + cell.getCoordinates());
                            removeNumberFromPotentialValues(table, cell, number);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void removeOverlappingPairs(Table table) {
        getListOfEntities(table).forEach(entity -> {
            var set = new HashSet<List<Integer>>();
            entity.getCells()
                    .stream()
                    .filter(cell -> cell.getValue() == 0)
                    .map(Cell::getPossibleValues)
                    .filter(possibleValues -> possibleValues.size() == 2)
                    .filter(possibleValues -> !set.add(possibleValues))
                    .forEach(possibleValues -> removeNumbersFromEntityPotentialValues(entity, possibleValues));
        });
    }

    public static void removeOverlappingCombinations(Table table) {
        var combinationsNumber = 3;
        getListOfEntities(table)
                .stream()
                .filter(entity -> entity.getCells()
                        .stream()
                        .filter(cell -> cell.getValue() == 0)
                        .count() > combinationsNumber)
                .forEach(entity -> {
                    var cellCombinations = getCellsCombinations(entity.getCells()
                            .stream()
                            .filter(cell -> cell.getValue() == 0)
                            .collect(Collectors.toCollection(ArrayList::new)), combinationsNumber);
                    for (Set<Cell> combination : cellCombinations) {
                        var potentialValuesSet = new HashSet<Integer>();
                        for (Cell cell : combination) {
                            potentialValuesSet.addAll(cell.getPossibleValues());
                        }
                        if (potentialValuesSet.size() == combinationsNumber) {
                            excludeCombinationFromOtherCells(entity, combination);
                            System.out.println("Removing combination " + potentialValuesSet + " from entity");
                        }
                    }
                });
    }

    private static void excludeCombinationFromOtherCells(BaseEntity entity, Set<Cell> combination) {
        var numbersToExclude = combination
                .stream()
                .flatMap(cell -> cell.getPossibleValues().stream())
                .collect(Collectors.toCollection(HashSet::new));
        var cellsToClear = entity.getCells()
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .collect(Collectors.toCollection(ArrayList::new));
        cellsToClear.removeAll(combination);
        cellsToClear.forEach(cellToClear -> {
            var possibleValues = cellToClear.getPossibleValues();
            possibleValues.removeAll(numbersToExclude);
            cellToClear.setPossibleValues(possibleValues);
        });
    }

    private static void subsetsOf(List<Cell> cells, int k, int index, Set<Cell> tempSet, List<Set<Cell>> finalSet) {
        if (tempSet.size() == k) {
            finalSet.add(new HashSet<>(tempSet));
            return;
        }
        if (index == cells.size())
            return;
        var cell = cells.get(index);
        tempSet.add(cell);
        subsetsOf(cells, k, index + 1, tempSet, finalSet);
        tempSet.remove(cell);
        subsetsOf(cells, k, index + 1, tempSet, finalSet);
    }

    private static List<Set<Cell>> getCellsCombinations(List<Cell> list, int k) {
        List<Set<Cell>> result = new ArrayList<>();
        subsetsOf(list, k, 0, new HashSet<Cell>(), result);
        return result;
    }

    private static void removeNumbersFromEntityPotentialValues(BaseEntity entity, List<Integer> overlappingValues) {
        entity.getCells()
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .forEach(cell -> {
                    var possibleValues = cell.getPossibleValues();
                    if (!possibleValues.equals(overlappingValues)) {
                        System.out.println("Removing overlapping values " + overlappingValues + " for cell " + cell.getCoordinates());
                        possibleValues.removeAll(overlappingValues);
                        cell.setPossibleValues(possibleValues);
                    }
                });
    }

    private static List<Integer> getPotentialValues(BaseEntity entity) {
        return entity.getCells()
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .flatMap(cell -> cell.getPossibleValues().stream())
                .toList();
    }

    public static void removeNumberFromPotentialValues(Table table, Cell cell, int number) {
        removeNumberFromEntity(table.getRows(), cell, number);
        removeNumberFromEntity(table.getColumns(), cell, number);
        removeNumberFromEntity(table.getSquares(), cell, number);
    }

    private static <T extends BaseEntity> void removeNumberFromEntity(List<T> entitiesList, Cell targetCell, int number) {
        entitiesList
                .stream()
                .filter(entity -> entity.getCells().contains(targetCell))
                .flatMap(entity -> entity.getCells().stream())
                .filter(cell -> cell.getValue() == 0)
                .filter(cell -> cell.getPossibleValues().contains(number))
                .forEach(cell -> cell.getPossibleValues().remove(Integer.valueOf(number)));
    }

    public static boolean areEmptyCellsFound(Table table) {
        return getAllCellsByRowOrder(table)
                .stream()
                .anyMatch(cell -> cell.getValue() == 0);
    }

    public static long getEmptyCellsNumber(Table table) {
        return getAllCellsByRowOrder(table)
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .count();
    }

    public static Cell getCell(Table table, Coordinates coordinates) {
        return table
                .getRows()
                .get(coordinates.y() - 1)
                .getCells()
                .get(coordinates.x() - 1);
    }

    public static List<Cell> getAllCellsByRowOrder(Table table) {
        return table
                .getRows()
                .stream()
                .flatMap(e -> e.getCells().stream())
                .toList();
    }

    public static List<BaseEntity> getListOfEntities(Table table) {
        return Stream.of(table.getColumns(), table.getRows(), table.getSquares())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> getPotentialValuesLists(Table table) {
        return getAllCellsByRowOrder(table)
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .map(Cell::getPossibleValues)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static long getPotentialValuesNumber(Table table) {
        return getAllCellsByRowOrder(table)
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .mapToLong(cell -> cell.getPossibleValues().size())
                .sum();
    }

    public static List<Integer> readExcelTable() {
        List<Integer> numberList = new ArrayList<>();
        try (var file = new FileInputStream("src/main/resources/SudokuBoard.xlsx")) {
            for (Row cells : new XSSFWorkbook(file).getSheetAt(0)) {
                var cellIterator = cells.cellIterator();
                while (cellIterator.hasNext()) {
                    numberList.add((int) cellIterator.next().getNumericCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numberList;
    }
}
