package engine.grid;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import config.SoftwareConfiguration;
import engine.database.Database;
import gui.GridStrategy;

public class Grid {
	public Cell[][] cells;

	private int lineCount;
	private int columnCount;
	public boolean[][] letterDrawInit;
	public String resultatDessin;
	public JLabel resultatLabel = new JLabel();

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

	public String getResult() {
		return resultatDessin;
	}

	public String setResult(String resultat) {
		return this.resultatDessin = resultat;
	}

	public JLabel defineLabelResult(String resultat) {
		setResult(resultat);
		resultatLabel.setText(getResult());

		return resultatLabel;
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

	public void DessinerSchema(boolean[][] letterDraw) {

		for (int i = 0; i < getLineCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {

				Cell cell = getCell(i, j);
				letterDraw[i][j] = cell.getColorie();

			}
		}

		if (!GridStrategy.estVideTab(letterDraw)) {
			System.out.println(); // Saut de ligne après chaque ligne

			for (int i = 0; i < getLineCount(); i++) {
				for (int j = 0; j < getColumnCount(); j++) {

					System.out.print(letterDraw[i][j] ? "X " : ". ");

				}
				System.out.println(); // Saut de ligne après chaque ligne
			}
		}

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
		/*
		 * if (!GridStrategy.estVideTab(letterDrawInit)) {
		 * 
		 * System.out.println(); // Saut de ligne après chaque ligne
		 * 
		 * for (int i = 0; i < nouvellesLignes; i++) {
		 * for (int j = 0; j < nouvellesColonnes; j++) {
		 * 
		 * System.out.print(grilleReduite[i][j] ? "X " : ". ");
		 * 
		 * }
		 * System.out.println(); // Saut de ligne après chaque ligne
		 * }
		 * 
		 * 
		 * }
		 */

		return grilleReduite;
	}

	public void ComparaisonLettre() {

		HashMap<Character, boolean[][]> letterDatabase = Database.getLetterDatabase();
		boolean[][] UtilDraw = ReducSchema(letterDrawInit);

		System.out.println("Dimensions UtilDraw : ");
		System.out.println(UtilDraw.length);
		System.out.println(UtilDraw[0].length);

		for (Map.Entry<Character, boolean[][]> entry : letterDatabase.entrySet()) {
			char letter = entry.getKey();
			boolean[][] pattern = entry.getValue();

			boolean[][] DatabaseDraw = ReducSchema(pattern);

			CompareDimensionsTab(UtilDraw, DatabaseDraw);

			System.out.println("Dimensions Lettre " + letter + " :");
			System.out.println(DatabaseDraw.length + " " + DatabaseDraw[0].length);

		}

	}

	public static void CompareDimensionsTab(boolean[][] tab1, boolean[][] tab2) {
		int tab1Ligne = tab1.length;
		int tab1Col = tab1[0].length;
		int tab2Ligne = tab2.length;
		int tab2Col = tab2[0].length;

		if (tab1Ligne > tab2Ligne && tab1Col > tab2Col) {
			adjustArrayDimensions(tab2, tab1Ligne, tab1Col);

		} else if (tab1Ligne > tab2Ligne && tab2Col > tab1Col) {
			adjustArrayDimensions(tab1, tab1Ligne, tab2Col);
			adjustArrayDimensions(tab2, tab1Ligne, tab2Col);

		} else if (tab2Ligne > tab1Ligne && tab1Col > tab2Col) {
			adjustArrayDimensions(tab1, tab2Ligne, tab1Col);
			adjustArrayDimensions(tab2, tab2Ligne, tab1Col);

		} else if (tab2Ligne > tab1Ligne && tab2Col > tab1Col) {
			adjustArrayDimensions(tab1, tab2Ligne, tab2Col);

		}

	}

	public static boolean[][] adjustArrayDimensions(boolean[][] array, int rows, int cols) {
		boolean[][] adjustedArray = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i < array.length && j < array[0].length) {
					adjustedArray[i][j] = array[i][j]; // Copier les valeurs du tableau d'origine
				} else {
					adjustedArray[i][j] = false; // Remplir les cases supplémentaires avec false
				}
			}
		}
		return adjustedArray;
	}

	public void FinalSendSchema() {

		if (!GridStrategy.estVideTab(letterDrawInit)) {

			DessinerSchema(letterDrawInit);

			ReducSchema(letterDrawInit);

			setResult("lettre du dab");
			// setResult(le vrai résultat normalement);
			defineLabelResult(getResult());
		}
	}

}
