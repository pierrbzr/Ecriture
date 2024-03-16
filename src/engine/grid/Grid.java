package engine.grid;

public class Grid {
	private Cell[][] cells;

	private int lineCount;
	private int columnCount;

	public Grid(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		cells = new Cell[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				cells[lineIndex][columnIndex] = new Cell(lineIndex, columnIndex, false);
			}
		}
	}

	public Cell[][] getCells() {
		return cells;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public boolean estColorie(Cell cell) {
		return cell.getColorie();

	}

	public Cell getCell(int line, int column) {
		return cells[line][column];
	}

}