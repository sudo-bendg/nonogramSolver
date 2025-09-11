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
    if (newStateStr.toLowerCase() == "filled") {
      this.state = CellState.FILLED;
    } else if (newStateStr.toLowerCase() == "empty") {
      this.state = CellState.EMPTY;
    } else {
      this.state = CellState.UNCERTAIN;
    }
  }
}
