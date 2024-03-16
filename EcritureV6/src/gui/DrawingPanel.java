package gui;

import engine.grid.Grid;
import config.SoftwareConfiguration;
import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int lastX, lastY;
    private Color penColor = Color.RED;
    private GridStrategy gridStrategy;

    public DrawingPanel(Grid grid) {
        this.gridStrategy = new GridStrategy(grid, SoftwareConfiguration.BLOCK_SIZE, SoftwareConfiguration.OFFSET_X,
                SoftwareConfiguration.OFFSET_Y);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    public void addGrid() {
        drawGrid();
    }

    private void drawGrid() {
        Graphics g = getGraphics();
        gridStrategy.paint(g);
    }

    public void suppGrid() {
        deleteGrid();
    }

    public void deleteGrid() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public Color getPenColor() {
        return penColor;
    }

    public void setPenColor(String color) {
        switch (color) {
            case "Rouge":
                penColor = Color.RED;
                break;
            case "Noir":
                penColor = Color.BLACK;
                break;
            case "Bleu":
                penColor = Color.BLUE;
                break;
        }
    }

    public void sendGrid() {
        drawGrid();
        // sendGrid();
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastMousePosition(int x, int y) {
        lastX = x;
        lastY = y;
    }
}