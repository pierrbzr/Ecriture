
package gui;

import config.SoftwareConfiguration;
import engine.database.Database;
import engine.grid.Grid;

import java.awt.*;

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

    public static int testDatabase(boolean[][] tableau1, boolean[][] tableau2) {

        if ((tableau1.length == tableau2.length) && (tableau1[0].length == tableau2[0].length)) {
            int lines = tableau1.length;
            int columns = tableau1[0].length;
            int caseVraie = 0;
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {

                    if (tableau1[i][j] == tableau2[i][j]) {
                        caseVraie += 1;
                    }
                }
            }
            return caseVraie;

        } else {
            return 0;
        }

    }

    public static boolean estVideTab(boolean[][] tableau1) {
        boolean[][] tableauVide = Database.getLetterDatabase().get('0');

        return (testDatabase(tableau1, tableauVide) == 100);
    }

}
