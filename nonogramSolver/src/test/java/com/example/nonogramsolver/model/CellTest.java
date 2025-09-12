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
    }

    @Test
    void testGetCellForUncertainState() {
        assertEquals('.', cell.getCell());
    }

    @Test
    void testSetCellToFilled() {
        cell.setCell("filled");
        assertEquals(Cell.CellState.FILLED, cell.getState());
        assertEquals('■', cell.getCell());
    }

    @Test
    void testSetCellToEmpty() {
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
        
        cell.setCell("eMpTy");
        assertEquals(Cell.CellState.EMPTY, cell.getState());
    }

    @ParameterizedTest
    @ValueSource(strings = {"uncertain", "invalid", "", "random", "null"})
    void testSetCellToUncertainForInvalidInputs(String input) {
        cell.setCell(input);
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
        assertEquals('.', cell.getCell());
    }

    @Test
    void testSetCellWithNullInput() {
        assertDoesNotThrow(() -> cell.setCell(null));
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
    }

    @Test
    void testStateTransitions() {
        cell.setCell("filled");
        assertEquals(Cell.CellState.FILLED, cell.getState());
        
        cell.setCell("empty");
        assertEquals(Cell.CellState.EMPTY, cell.getState());
        
        cell.setCell("uncertain");
        assertEquals(Cell.CellState.UNCERTAIN, cell.getState());
        
        cell.setCell("filled");
        assertEquals(Cell.CellState.FILLED, cell.getState());
    }

    @Test
    void testGetCellForAllStates() {
        cell.setCell("filled");
        assertEquals('■', cell.getCell());
        
        cell.setCell("empty");
        assertEquals('x', cell.getCell());
        
        cell.setCell("uncertain");
        assertEquals('.', cell.getCell());
    }
}