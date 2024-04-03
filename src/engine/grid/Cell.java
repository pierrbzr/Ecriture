package engine.grid;

public class Cell {
	private int line;
	private int column;
	static boolean colorie;

	public Cell(int line, int column, boolean couleur) {
		this.line = line;
		this.column = column;
		colorie = couleur;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public boolean getColorie() {
		return colorie;
	}

	public String toString() {
		return "Cell [line=" + line + ", column=" + column + ", colorie= " + colorie + "]";
	}

}