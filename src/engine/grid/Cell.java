package engine.grid;

public class Cell {
	private int line;
	private int column;
	private boolean colorie;

	public Cell(int line, int column, boolean couleur) {
		this.line = line;
		this.column = column;
		this.colorie = couleur;
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

	public boolean setColorie(boolean couleur) {
		return this.colorie = couleur;
	}

	public String toString() {
		return "Cell [line=" + line + ", column=" + column + ", colorie= " + colorie + "]";
	}

}