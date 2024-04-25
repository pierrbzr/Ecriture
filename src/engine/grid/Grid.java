package engine.grid;

import java.util.*;

import javax.swing.JLabel;

import config.SoftwareConfiguration;
import engine.database.Database;
import gui.GridStrategy;

public class Grid {
	public Cell[][] cells;

	private int lineCount;
	private int columnCount;
	public boolean[][] letterDrawInit;
	public Character resultatDessin;
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

	public Character getResult() {
		return resultatDessin;
	}

	public Character setResult(Character letter) {
		return this.resultatDessin = letter;
	}

	public JLabel initJLabel(Character letter) {
		resultatLabel.setText("" + letter);
		return resultatLabel;

	}

	public JLabel resetJLabel() {
		resultatLabel.setText("");
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

		if (!GridStrategy.estVideTab(letterDraw)) {
			System.out.println(); // Saut de ligne après chaque ligne

			for (boolean[] row : letterDraw) {
				for (boolean pixel : row) {
					System.out.print(pixel ? "X " : ". ");
				}
				System.out.println(); // Saut de ligne après chaque ligne
			}
		}

	}

	public void printPattern(boolean[][] pattern) {

		System.out.println(); // Saut de ligne après chaque ligne

		for (boolean[] row : pattern) {
			for (boolean pixel : row) {
				System.out.print(pixel ? "X " : ". ");
			}
			System.out.println(); // Nouvelle ligne pour chaque ligne du tableau
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

		boolean[] lignesVide = new boolean[SoftwareConfiguration.LINE_COUNT];
		boolean[] colonnesVide = new boolean[SoftwareConfiguration.COLUMN_COUNT];

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
		for (int i = (SoftwareConfiguration.LINE_COUNT - 1); lignesVideFin && i >= 0; i--) {
			for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); j >= 0; j--) {
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
		for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); colonesVideFin && j >= 0; j--) {
			for (int i = SoftwareConfiguration.LINE_COUNT - 1; i >= 0; i--) {
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
		/*
		 * // Affichage Grille Réduite
		 * if (!GridStrategy.estVideTab(letterDraw)) {
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
		 * }
		 */
		return grilleReduite;
	}

	public boolean[][] ReducDatabase(boolean[][] letterDraw) {

		int nouvellesLignes = SoftwareConfiguration.LINE_COUNT;
		int nouvellesColonnes = SoftwareConfiguration.COLUMN_COUNT;

		boolean[] lignesVide = new boolean[SoftwareConfiguration.LINE_COUNT];
		boolean[] colonnesVide = new boolean[SoftwareConfiguration.COLUMN_COUNT];

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
		for (int i = (SoftwareConfiguration.LINE_COUNT - 1); lignesVideFin && i >= 0; i--) {
			for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); j >= 0; j--) {
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
		for (int j = (SoftwareConfiguration.COLUMN_COUNT - 1); colonesVideFin && j >= 0; j--) {
			for (int i = SoftwareConfiguration.LINE_COUNT - 1; i >= 0; i--) {
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

		/*
		 * // Affichage Grille Réduite
		 * if (!GridStrategy.estVideTab(letterDraw)) {
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
		 * }
		 */

		return grilleReduite;
	}

	public HashMap<Character, Integer> ComparaisonLettreMaj() {
		HashMap<Character, boolean[][]> letterDatabase = Database.getLetterDatabase();
		HashMap<Character, Integer> verifLetterCap = new HashMap<>();

		for (Character letter = 'A'; letter <= 'Z'; letter++) {

			boolean[][] pattern = letterDatabase.get(letter);
			boolean[][] UtilDraw = adjustArrayDimensions(ReducSchema(letterDrawInit), SoftwareConfiguration.LINE_COUNT,
					SoftwareConfiguration.COLUMN_COUNT);
			boolean[][] DatabaseDraw = adjustArrayDimensions(ReducDatabase(pattern), SoftwareConfiguration.LINE_COUNT,
					SoftwareConfiguration.COLUMN_COUNT);

			verifLetterCap.put(letter, GridStrategy.testDatabase(UtilDraw, DatabaseDraw));

		}
		// System.out.println(verifLetterCap);
		return verifLetterCap;
	}

	public HashMap<Character, Integer> ComparaisonLettreMin() {
		HashMap<Character, boolean[][]> letterDatabase = Database.getLetterDatabase();
		HashMap<Character, Integer> verifLetterMin = new HashMap<>();

		for (Character letter = 'a'; letter <= 'z'; letter++) {

			boolean[][] pattern = letterDatabase.get(letter);
			boolean[][] UtilDraw = adjustArrayDimensions(ReducSchema(letterDrawInit), SoftwareConfiguration.LINE_COUNT,
					SoftwareConfiguration.COLUMN_COUNT);
			boolean[][] DatabaseDraw = adjustArrayDimensions(ReducDatabase(pattern), SoftwareConfiguration.LINE_COUNT,
					SoftwareConfiguration.COLUMN_COUNT);

			verifLetterMin.put(letter, GridStrategy.testDatabase(UtilDraw, DatabaseDraw));

		}
		// System.out.println(verifLetterMin);
		return verifLetterMin;

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

	public Map<Character, Integer> affichageLettre(HashMap<Character, Integer> tableauMaj,
			HashMap<Character, Integer> tableauMin, boolean[][] letterDraw) {
		if (!GridStrategy.estVideTab(letterDraw)) {
			HashMap<Character, Integer> triHashmap = new HashMap<>();

			for (HashMap.Entry<Character, Integer> entry : tableauMaj.entrySet()) {
				Character key = entry.getKey();
				Integer value = entry.getValue();
				if (value >= 85) {
					triHashmap.put(key, value);
				}
			}

			for (HashMap.Entry<Character, Integer> entry : tableauMin.entrySet()) {
				Character key = entry.getKey();
				Integer value = entry.getValue();
				if (value >= 85) {
					triHashmap.put(key, value);
				}
			}
			List<Map.Entry<Character, Integer>> list = new ArrayList<>(triHashmap.entrySet());
			list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

			Map<Character, Integer> finalHashmap = new LinkedHashMap<>();
			for (Map.Entry<Character, Integer> entry : list) {
				finalHashmap.put(entry.getKey(), entry.getValue());
			}
			System.out.println(finalHashmap);
			return finalHashmap;

		} else {
			Map<Character, Integer> finalHashmap = new LinkedHashMap<>();
			return finalHashmap;

		}

	}

	public void FinalSendSchema() {

		Map<Character, Integer> finalHashmap = affichageLettre(ComparaisonLettreMaj(),
				ComparaisonLettreMin(), letterDrawInit);

		for (HashMap.Entry<Character, Integer> entry : finalHashmap.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			if (value == 100) {
				initJLabel(key);
			} else if (!finalHashmap.isEmpty()) {
				initJLabel(getFirstKey(finalHashmap));
			} else if (!finalHashmap.isEmpty()) {
				initJLabel(null);
			}
		}
	}

	public static <K, V> K getFirstKey(Map<K, V> map) {
		for (K key : map.keySet()) {
			return key;
		}
		return null;
	}

}
