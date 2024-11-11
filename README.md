# SudokuSolver

Java program that solves Sudoku board even on 'extreme' difficulty level.
Tested on https://sudoku.com/

### How it works?

To resolve the board you firstly need to fill in the Excel sheet with valid Sudoku puzzle. You can find Excel sheet here
\src\main\resources\SudokuBoard.xlsx. The program parses Excel sheet with Sudoku board puzzle and by using 'Human'
approaches and solving strategies such as 'Candidate Lists', 'Remove Overlapping Regions', 'X-Wing' and 'Swordfish'
resolves the board in a few iterations.
As a result, the program rewrites the original Excel file with all the found values and also writes the resolved board
to the console.

The program is based on Object-oriented programming (OOP) principles and uses encapsulation, inheritance, polymorphism,
and abstraction for better effectiveness and visibility.
There are several Entity objects with inheritance hierarchy that define Sudoku components like 'Table', 'Cell', 'Row',
etc.