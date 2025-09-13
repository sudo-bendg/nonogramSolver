package com.example.nonogramsolver.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
        assertEquals('.', cell.getCell());
    }

    @Test
    void testSetCellStates() {
        cell.setCell("filled");
        assertEquals(Cell.CellState.FILLED, cell.getState());
        assertEquals('■', cell.getCell());

        cell.setCell("empty");
        assertEquals(Cell.CellState.EMPTY, cell.getState());
        assertEquals('x', cell.getCell());
    }

    @Test
    void testSetCellCaseInsensitive() {
        cell.setCell("FILLED");
        assertEquals(Cell.CellState.FILLED, cell.getState());

        cell.setCell("Empty");
        assertEquals(Cell.CellState.EMPTY, cell.getState());
    }

    @ParameterizedTest
    @ValueSource(strings = {"uncertain", "invalid", "", "random"})
    void testSetCellInvalidInputs(String input) {
        cell.setCell(input);
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
        assertEquals('.', cell.getCell());
    }

    @Test
    void testSetCellWithNullInput() {
        cell.setCell(null);
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
    }
}
