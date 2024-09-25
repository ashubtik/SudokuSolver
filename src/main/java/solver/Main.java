package solver;

import solver.entities.*;

import java.util.List;

import static solver.utils.Functions.*;

public class Main {
    public static void main(String[] args) {
        var numbersList = readExcelTable();

        var cell1 = new Cell(new Coordinates(1, 1), numbersList.get(0));
        var cell2 = new Cell(new Coordinates(1, 2), numbersList.get(1));
        var cell3 = new Cell(new Coordinates(1, 3), numbersList.get(2));
        var cell4 = new Cell(new Coordinates(1, 4), numbersList.get(3));
        var cell5 = new Cell(new Coordinates(1, 5), numbersList.get(4));
        var cell6 = new Cell(new Coordinates(1, 6), numbersList.get(5));
        var cell7 = new Cell(new Coordinates(1, 7), numbersList.get(6));
        var cell8 = new Cell(new Coordinates(1, 8), numbersList.get(7));
        var cell9 = new Cell(new Coordinates(1, 9), numbersList.get(8));
        var cell10 = new Cell(new Coordinates(2, 1), numbersList.get(9));
        var cell11 = new Cell(new Coordinates(2, 2), numbersList.get(10));
        var cell12 = new Cell(new Coordinates(2, 3), numbersList.get(11));
        var cell13 = new Cell(new Coordinates(2, 4), numbersList.get(12));
        var cell14 = new Cell(new Coordinates(2, 5), numbersList.get(13));
        var cell15 = new Cell(new Coordinates(2, 6), numbersList.get(14));
        var cell16 = new Cell(new Coordinates(2, 7), numbersList.get(15));
        var cell17 = new Cell(new Coordinates(2, 8), numbersList.get(16));
        var cell18 = new Cell(new Coordinates(2, 9), numbersList.get(17));
        var cell19 = new Cell(new Coordinates(3, 1), numbersList.get(18));
        var cell20 = new Cell(new Coordinates(3, 2), numbersList.get(19));
        var cell21 = new Cell(new Coordinates(3, 3), numbersList.get(20));
        var cell22 = new Cell(new Coordinates(3, 4), numbersList.get(21));
        var cell23 = new Cell(new Coordinates(3, 5), numbersList.get(22));
        var cell24 = new Cell(new Coordinates(3, 6), numbersList.get(23));
        var cell25 = new Cell(new Coordinates(3, 7), numbersList.get(24));
        var cell26 = new Cell(new Coordinates(3, 8), numbersList.get(25));
        var cell27 = new Cell(new Coordinates(3, 9), numbersList.get(26));
        var cell28 = new Cell(new Coordinates(4, 1), numbersList.get(27));
        var cell29 = new Cell(new Coordinates(4, 2), numbersList.get(28));
        var cell30 = new Cell(new Coordinates(4, 3), numbersList.get(29));
        var cell31 = new Cell(new Coordinates(4, 4), numbersList.get(30));
        var cell32 = new Cell(new Coordinates(4, 5), numbersList.get(31));
        var cell33 = new Cell(new Coordinates(4, 6), numbersList.get(32));
        var cell34 = new Cell(new Coordinates(4, 7), numbersList.get(33));
        var cell35 = new Cell(new Coordinates(4, 8), numbersList.get(34));
        var cell36 = new Cell(new Coordinates(4, 9), numbersList.get(35));
        var cell37 = new Cell(new Coordinates(5, 1), numbersList.get(36));
        var cell38 = new Cell(new Coordinates(5, 2), numbersList.get(37));
        var cell39 = new Cell(new Coordinates(5, 3), numbersList.get(38));
        var cell40 = new Cell(new Coordinates(5, 4), numbersList.get(39));
        var cell41 = new Cell(new Coordinates(5, 5), numbersList.get(40));
        var cell42 = new Cell(new Coordinates(5, 6), numbersList.get(41));
        var cell43 = new Cell(new Coordinates(5, 7), numbersList.get(42));
        var cell44 = new Cell(new Coordinates(5, 8), numbersList.get(43));
        var cell45 = new Cell(new Coordinates(5, 9), numbersList.get(44));
        var cell46 = new Cell(new Coordinates(6, 1), numbersList.get(45));
        var cell47 = new Cell(new Coordinates(6, 2), numbersList.get(46));
        var cell48 = new Cell(new Coordinates(6, 3), numbersList.get(47));
        var cell49 = new Cell(new Coordinates(6, 4), numbersList.get(48));
        var cell50 = new Cell(new Coordinates(6, 5), numbersList.get(49));
        var cell51 = new Cell(new Coordinates(6, 6), numbersList.get(50));
        var cell52 = new Cell(new Coordinates(6, 7), numbersList.get(51));
        var cell53 = new Cell(new Coordinates(6, 8), numbersList.get(52));
        var cell54 = new Cell(new Coordinates(6, 9), numbersList.get(53));
        var cell55 = new Cell(new Coordinates(7, 1), numbersList.get(54));
        var cell56 = new Cell(new Coordinates(7, 2), numbersList.get(55));
        var cell57 = new Cell(new Coordinates(7, 3), numbersList.get(56));
        var cell58 = new Cell(new Coordinates(7, 4), numbersList.get(57));
        var cell59 = new Cell(new Coordinates(7, 5), numbersList.get(58));
        var cell60 = new Cell(new Coordinates(7, 6), numbersList.get(59));
        var cell61 = new Cell(new Coordinates(7, 7), numbersList.get(60));
        var cell62 = new Cell(new Coordinates(7, 8), numbersList.get(61));
        var cell63 = new Cell(new Coordinates(7, 9), numbersList.get(62));
        var cell64 = new Cell(new Coordinates(8, 1), numbersList.get(63));
        var cell65 = new Cell(new Coordinates(8, 2), numbersList.get(64));
        var cell66 = new Cell(new Coordinates(8, 3), numbersList.get(65));
        var cell67 = new Cell(new Coordinates(8, 4), numbersList.get(66));
        var cell68 = new Cell(new Coordinates(8, 5), numbersList.get(67));
        var cell69 = new Cell(new Coordinates(8, 6), numbersList.get(68));
        var cell70 = new Cell(new Coordinates(8, 7), numbersList.get(69));
        var cell71 = new Cell(new Coordinates(8, 8), numbersList.get(70));
        var cell72 = new Cell(new Coordinates(8, 9), numbersList.get(71));
        var cell73 = new Cell(new Coordinates(9, 1), numbersList.get(72));
        var cell74 = new Cell(new Coordinates(9, 2), numbersList.get(73));
        var cell75 = new Cell(new Coordinates(9, 3), numbersList.get(74));
        var cell76 = new Cell(new Coordinates(9, 4), numbersList.get(75));
        var cell77 = new Cell(new Coordinates(9, 5), numbersList.get(76));
        var cell78 = new Cell(new Coordinates(9, 6), numbersList.get(77));
        var cell79 = new Cell(new Coordinates(9, 7), numbersList.get(78));
        var cell80 = new Cell(new Coordinates(9, 8), numbersList.get(79));
        var cell81 = new Cell(new Coordinates(9, 9), numbersList.get(80));

        var row1 = new Row(List.of(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9));
        var row2 = new Row(List.of(cell10, cell11, cell12, cell13, cell14, cell15, cell16, cell17, cell18));
        var row3 = new Row(List.of(cell19, cell20, cell21, cell22, cell23, cell24, cell25, cell26, cell27));
        var row4 = new Row(List.of(cell28, cell29, cell30, cell31, cell32, cell33, cell34, cell35, cell36));
        var row5 = new Row(List.of(cell37, cell38, cell39, cell40, cell41, cell42, cell43, cell44, cell45));
        var row6 = new Row(List.of(cell46, cell47, cell48, cell49, cell50, cell51, cell52, cell53, cell54));
        var row7 = new Row(List.of(cell55, cell56, cell57, cell58, cell59, cell60, cell61, cell62, cell63));
        var row8 = new Row(List.of(cell64, cell65, cell66, cell67, cell68, cell69, cell70, cell71, cell72));
        var row9 = new Row(List.of(cell73, cell74, cell75, cell76, cell77, cell78, cell79, cell80, cell81));

        var column1 = new Column(List.of(cell1, cell10, cell19, cell28, cell37, cell46, cell55, cell64, cell73));
        var column2 = new Column(List.of(cell2, cell11, cell20, cell29, cell38, cell47, cell56, cell65, cell74));
        var column3 = new Column(List.of(cell3, cell12, cell21, cell30, cell39, cell48, cell57, cell66, cell75));
        var column4 = new Column(List.of(cell4, cell13, cell22, cell31, cell40, cell49, cell58, cell67, cell76));
        var column5 = new Column(List.of(cell5, cell14, cell23, cell32, cell41, cell50, cell59, cell68, cell77));
        var column6 = new Column(List.of(cell6, cell15, cell24, cell33, cell42, cell51, cell60, cell69, cell78));
        var column7 = new Column(List.of(cell7, cell16, cell25, cell34, cell43, cell52, cell61, cell70, cell79));
        var column8 = new Column(List.of(cell8, cell17, cell26, cell35, cell44, cell53, cell62, cell71, cell80));
        var column9 = new Column(List.of(cell9, cell18, cell27, cell36, cell45, cell54, cell63, cell72, cell81));

        var square1 = new Square(List.of(cell1, cell2, cell3, cell10, cell11, cell12, cell19, cell20, cell21));
        var square2 = new Square(List.of(cell28, cell29, cell30, cell37, cell38, cell39, cell46, cell47, cell48));
        var square3 = new Square(List.of(cell55, cell56, cell57, cell64, cell65, cell66, cell73, cell74, cell75));
        var square4 = new Square(List.of(cell4, cell5, cell6, cell13, cell14, cell15, cell22, cell23, cell24));
        var square5 = new Square(List.of(cell31, cell32, cell33, cell40, cell41, cell42, cell49, cell50, cell51));
        var square6 = new Square(List.of(cell58, cell59, cell60, cell67, cell68, cell69, cell76, cell77, cell78));
        var square7 = new Square(List.of(cell7, cell8, cell9, cell16, cell17, cell18, cell25, cell26, cell27));
        var square8 = new Square(List.of(cell34, cell35, cell36, cell43, cell44, cell45, cell52, cell53, cell54));
        var square9 = new Square(List.of(cell61, cell62, cell63, cell70, cell71, cell72, cell79, cell80, cell81));

        var table = new Table(List.of(row1, row2, row3, row4, row5, row6, row7, row8, row9),
                List.of(column1, column2, column3, column4, column5, column6, column7, column8, column9),
                List.of(square1, square2, square3, square4, square5, square6, square7, square8, square9));

        setPotentialValuesForTable(table);
        resolveBoard(table);

        if (getEmptyCellsNumber(table) == 0) {
            System.out.println("SUCCESS - SUDOKU BOARD IS RESOLVED!");
        } else {
            System.out.println("SUDOKU BOARD CAN NOT BE RESOLVED FAIRLY - BLACK MAGIC NEEDED...");
            prohibitedTrick(table, 1);
        }

        if (getEmptyCellsNumber(table) == 0) {
            System.out.println("SUCCESS - SUDOKU BOARD IS RESOLVED WITH BLACK MAGIC!");
        } else {
            System.out.println("FAIL! - TRY ANOTHER OPTION");
        }
        System.out.println(table);
    }
}