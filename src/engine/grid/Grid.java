package engine.grid;

public class Grid {
	public Cell[][] cells;

	private int lineCount;
	private int columnCount;
	private boolean[][] letterDrawInit;

	public Grid(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		cells = new Cell[lineCount][columnCount];
		letterDrawInit = new boolean[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				cells[lineIndex][columnIndex] = new Cell(lineIndex, columnIndex, false);
			}
		}
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Cell getCell(int line, int column) {
		return cells[line][column];
	}

	public void RecupSchema() {
		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {
				Cell cell = getCell(i, j);
				letterDrawInit[i][j] = cell.getColorie();

			}
		}

		System.out.println(); // Saut de ligne après chaque ligne

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {

				System.out.print(letterDrawInit[i][j] ? "X " : ". "); // Affiche X si true, . si false

			}
			System.out.println(); // Saut de ligne après chaque ligne
		}
	}

	public void InitSchema() {

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {
				Cell cell = getCell(i, j);
				letterDrawInit[i][j] = cell.setColorie(false);

			}
		}

	}

}