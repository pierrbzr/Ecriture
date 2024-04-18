package engine.grid;

import config.SoftwareConfiguration;
import gui.GridStrategy;

public class Grid {
	public Cell[][] cells;

	private int lineCount;
	private int columnCount;
	public boolean[][] letterDrawInit;

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

	// Cette fonction initialise chaque données du tableaux à "false" lorsque la
	// grille est réinitialisée

	public void InitSchema() {

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {
				Cell cell = getCell(i, j);
				letterDrawInit[i][j] = cell.setColorie(false);

			}
		}

	}

	// Cette fonction récupère les cases coloriées de la grille et transfère les
	// données dans le tableau adapté à la grille

	public boolean[][] RecupSchema() {

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {

				Cell cell = getCell(i, j);
				letterDrawInit[i][j] = cell.getColorie();

			}
		}

		if (!GridStrategy.estVideTab(letterDrawInit)) {
			System.out.println(); // Saut de ligne après chaque ligne

			for (int i = 0; i < getLineCount(); i++) {
				for (int j = 0; j < getColumnCount(); j++) {

					System.out.print(letterDrawInit[i][j] ? "X " : ". ");

				}
				System.out.println(); // Saut de ligne après chaque ligne
			}
		}
		return letterDrawInit;

	}

	public boolean[][] ReducSchema(boolean[][] letterDraw) {

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {

				Cell cell = getCell(i, j);
				letterDraw[i][j] = cell.getColorie();
			}
		}

		int nouvellesLignes = SoftwareConfiguration.LINE_COUNT;
		int nouvellesColonnes = SoftwareConfiguration.COLUMN_COUNT;

		boolean[] lignesVide = new boolean[getLineCount()];
		boolean[] colonnesVide = new boolean[getColumnCount()];

		boolean lignesVideDebut = true;
		for (int i = 0; lignesVideDebut && i < SoftwareConfiguration.LINE_COUNT; i++) {
			for (int j = 0; j < SoftwareConfiguration.COLUMN_COUNT; j++) {
				if (letterDraw[i][j]) {
					lignesVideDebut = false;
					nouvellesLignes -= i;
					break;
				}
			}
			lignesVide[i] = lignesVideDebut;

		}

		boolean lignesVideFin = true;
		for (int i = (SoftwareConfiguration.LINE_COUNT - 1); lignesVideFin && i > 0; i--) {
			for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); j > 0; j--) {
				if (letterDraw[i][j]) {
					lignesVideFin = false;
					nouvellesLignes -= SoftwareConfiguration.LINE_COUNT - 1 - i;

					break;
				}

			}
			lignesVide[i] = lignesVideFin;

		}

		boolean colonnesVideDebut = true;
		for (int j = 0; colonnesVideDebut && j < SoftwareConfiguration.COLUMN_COUNT; j++) {
			for (int i = 0; i < SoftwareConfiguration.LINE_COUNT; i++) {
				if (letterDraw[i][j]) {
					colonnesVideDebut = false;
					nouvellesColonnes -= j;
					break;
				}
			}
			colonnesVide[j] = colonnesVideDebut;

		}

		boolean colonesVideFin = true;
		for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); colonesVideFin && j > 0; j--) {
			for (int i = (SoftwareConfiguration.LINE_COUNT - 1); (i > 0); i--) {
				if (letterDraw[i][j]) {
					colonesVideFin = false;
					nouvellesColonnes -= SoftwareConfiguration.COLUMN_COUNT - 1 - j;
					break;
				}

			}
			colonnesVide[j] = colonesVideFin;

		}

		// Créer la grille réduite
		boolean[][] grilleReduite = new boolean[nouvellesLignes][nouvellesColonnes];
		for (int i = 0; i < SoftwareConfiguration.LINE_COUNT; i++) {

		}
		// Copier les valeurs de la grille d'origine vers la grille réduite
		int ligneCourante = 0;
		for (int i = 0; i < SoftwareConfiguration.LINE_COUNT; i++) {

			if (!lignesVide[i]) {

				int colonneCourante = 0;
				for (int j = 0; j < SoftwareConfiguration.COLUMN_COUNT; j++) {

					if (!colonnesVide[j]) {

						grilleReduite[ligneCourante][colonneCourante] = letterDraw[i][j];
						colonneCourante++;
					}
				}
				ligneCourante++;
			}
		}

		// Affichage Grille Réduite

		if (!GridStrategy.estVideTab(letterDrawInit)) {

			System.out.println(); // Saut de ligne après chaque ligne

			for (int i = 0; i < nouvellesLignes; i++) {
				for (int j = 0; j < nouvellesColonnes; j++) {

					System.out.print(grilleReduite[i][j] ? "X " : ". ");

				}
				System.out.println(); // Saut de ligne après chaque ligne
			}

		}
		return grilleReduite;

	}

}
