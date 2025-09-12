package com.example.nonogramsolver.model;

public class Cell {
  public enum CellState {
    FILLED,
    EMPTY,
    UNCERTAIN
  }

  private CellState state;

  public Cell() {
    this.state = CellState.UNCERTAIN;
  }

  public CellState getState() {
    return this.state;
  }

  public char getCell() {
    switch (this.state) {
      case FILLED:
        return '■';
      case EMPTY:
        return 'x';
      default:
        return '.';
    }
  }

  public void setCell(String newStateStr) {
    if (newStateStr != null && "filled".equals(newStateStr.toLowerCase())) {
      this.state = CellState.FILLED;
    } else if (newStateStr != null && "empty".equals(newStateStr.toLowerCase())) {
      this.state = CellState.EMPTY;
    } else {
      this.state = CellState.UNCERTAIN;
    }
  }
}
