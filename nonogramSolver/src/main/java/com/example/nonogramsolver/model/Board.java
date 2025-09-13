package com.example.nonogramsolver.model;

public class Board {
  private int xSize;
  private int ySize;
  private Cell[][] grid;

  public Board(int xSize, int ySize) {
    this.xSize = xSize;
    this.ySize = ySize;
    this.grid = new Cell[xSize][ySize];
    
    for (int i = 0; i < xSize; i++) {
      for (int j = 0; j < ySize; j++) {
        this.grid[i][j] = new Cell();
      }
    }
  }

  public void setCell(int x, int y, String value) {
    this.grid[x][y].setCell(value);
  }

  public char getCell(int x, int y) {
    return this.grid[x][y].getCell();
  }

  public Cell.CellState getCellState(int x, int y) {
    return this.grid[x][y].getState();
  }

  public String getGridString() {
    String returnString = "";

    for (Cell[] row : this.grid) {
      for (Cell cell : row) {
        returnString += cell.getCell();
      }
      returnString += "\n";
    }

    return returnString;
  }
}
