package com.example.nonogramsolver.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(6, 6);
    }

    @Test
    void testConstructorWithDifferentSizes() {
        Board smallBoard = new Board(1, 1);
        assertEquals(1, smallBoard.getGrid().length);
        assertEquals(1, smallBoard.getGrid()[0].length);

        Board nonSquareBoard = new Board(3, 7);
        assertEquals(3, nonSquareBoard.getGrid().length);
        assertEquals(7, nonSquareBoard.getGrid()[0].length);
    }

    @Test
    void testSetAndGetCell() {
        board.setCell(3, 3, "filled");
        assertEquals(Cell.CellState.FILLED, board.getCellState(3, 3));
        assertEquals('■', board.getCell(3, 3));
    }

    @Test
    void testGetGridString() {
        String expected = "......\n......\n......\n......\n......\n......\n";
        assertEquals(expected, board.getGridString());
    }

    @Test
    void testGetGridStringWithMixedStates() {
        board.setCell(0, 0, "filled");
        board.setCell(0, 1, "empty");

        String gridString = board.getGridString();
        assertTrue(gridString.startsWith("■x...."));
    }

    @Test
    void testBoardStateAfterMultipleOperations() {
        board.setCell(0, 0, "filled");
        board.setCell(1, 1, "empty");
        board.setCell(2, 2, "filled");

        assertEquals(Cell.CellState.FILLED, board.getCellState(0, 0));
        assertEquals(Cell.CellState.EMPTY, board.getCellState(1, 1));
        assertEquals(Cell.CellState.FILLED, board.getCellState(2, 2));
        assertEquals(Cell.CellState.UNCERTAIN, board.getCellState(3, 3));
    }
}
