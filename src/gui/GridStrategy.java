package gui;

import config.SoftwareConfiguration;
import engine.database.Database;
import engine.grid.Grid;

import java.awt.*;
import java.util.HashMap;

public class GridStrategy {

    private Grid grid;
    private int cellSize;
    private int xOffset;
    private int yOffset;

    public GridStrategy(Grid grid, int cellSize, int xDecalage, int yDecalage) {
        this.grid = grid;
        this.cellSize = SoftwareConfiguration.BLOCK_SIZE;
        this.xOffset = SoftwareConfiguration.OFFSET_X;
        this.yOffset = SoftwareConfiguration.OFFSET_Y;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < grid.getLineCount(); i++) {
            for (int j = 0; j < grid.getColumnCount(); j++) {
                int x = j * cellSize + xOffset;
                int y = i * cellSize + yOffset;

                g.setColor(Color.WHITE);

                g.fillRect(x, y, cellSize, cellSize);

            }
        }
    }

    public void paintLines(Graphics g) {
        for (int i = 0; i < grid.getLineCount(); i++) {
            for (int j = 0; j < grid.getColumnCount(); j++) {
                int x = j * cellSize + xOffset;
                int y = i * cellSize + yOffset;

                g.setColor(Color.BLACK);

                g.drawLine(x, y, x + cellSize, y);
                g.drawLine(x, y + cellSize, x + cellSize, y + cellSize);

                g.drawLine(x, y, x, y + cellSize);
                g.drawLine(x + cellSize, y, x + cellSize, y + cellSize);

            }
        }
    }

    public static void testDatabase() {
        HashMap<Character, boolean[][]> test1 = Database.getLetterDatabase();
        HashMap<Character, boolean[][]> test2 = Database.getLetterDatabase();
        boolean[][] tableauNaze = test1.get('a');
        boolean[][] tableauStyle = test2.get('a');

        int caseVraie = 0;
        int caseFausse = 0;
        int caseTotal = 0;

        for (int i = 0; i < SoftwareConfiguration.LINE_COUNT; i++) {
            for (int j = 0; j < SoftwareConfiguration.COLUMN_COUNT; j++) {
                System.out.println(tableauStyle[i][j]);
                System.out.println(tableauNaze[i][j]);
                if (tableauNaze[i][j] == tableauStyle[i][j]) {
                    caseVraie += 1;
                } else {
                    caseFausse += 1;
                }
                caseTotal = caseFausse + caseVraie;
                System.out.println(caseVraie + " cases correspondantes et " + caseFausse
                        + "cases non correspondantes et il y a " + caseTotal + " cases en tout");
            }
        }

    }
}