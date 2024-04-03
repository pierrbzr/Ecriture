package engine.grid;

public class Grid {
	public Cell[][] cells;

	private int lineCount;
	private int columnCount;
	private boolean[][] letterDraw0 = { { false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false, false } };

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

	public boolean setColorie(Cell cell, boolean couleur) {
		return Cell.colorie = couleur;
	}

	public Cell getCell(int line, int column) {
		return cells[line][column];
	}

	public void RecupSchema() {
		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				letterDraw0[lineIndex][columnIndex] = estColorie(cells[lineIndex][columnIndex]);

				System.out
						.println("case [" + lineIndex + ";" + columnIndex + "]" + letterDraw0[lineIndex][columnIndex]);
			}
		}

		// System.out.println(letterDraw0[0][0]);
	}

}