package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import config.SoftwareConfiguration;
import engine.grid.Grid;

public class MainGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private DrawingPanel drawingPanel;
    private DrawingPanel drawingPanel0;
    private DrawingPanel drawingPanel1;
    private DrawingPanel drawingPanel2;
    private DrawingPanel drawingPanel3;
    private DrawingPanel drawingPanel4;
    private DrawingPanel drawingPanel5;
    private DrawingPanel drawingPanel6;
    private DrawingPanel drawingPanel7;
    private DrawingPanel drawingPanel8;
    private DrawingPanel drawingPanel9;

    private final static Dimension preferredSize = new Dimension(SoftwareConfiguration.WINDOW_WIDTH,
            SoftwareConfiguration.WINDOW_HEIGHT);
    private final static Dimension preferredSize2 = new Dimension(SoftwareConfiguration.WINDOW_WIDTH, 700);
    private final static Dimension preferredSize3 = new Dimension(1600, 50);

    public MainGUI(String title) {
        super(title);
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JButton startButton = new JButton("Afficher Grilles");
        // startButton.addActionListener(e -> drawingPanel.startDrawing());

        JButton clearButton = new JButton("Tout Effacer");
        clearButton.addActionListener(e -> drawingPanel.addGrid());

        JComboBox<String> colorComboBox = new JComboBox<>(new String[] { "Rouge", "Noir", "Bleu" });
        colorComboBox.addActionListener(e -> drawingPanel.setPenColor(colorComboBox.getSelectedItem().toString()));

        JButton validGridButton = new JButton("Validé !");
        // validGridButton.addActionListener(e -> GridStrategy.verificationLettre());
        validGridButton.addActionListener(e -> GridStrategy.testDatabase());

        JPanel centerPanel = new JPanel(new GridLayout(2, 5, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int j = 0; j < SoftwareConfiguration.GRID_COUNT; j++) {
            final int i = j; // i est effectivement final

            Grid grid0 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid1 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid2 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid3 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid4 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid5 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid6 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid7 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid8 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            Grid grid9 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);

            JPanel[] subPanels = new JPanel[SoftwareConfiguration.GRID_COUNT];

            JPanel[] buttonsPanels = new JPanel[SoftwareConfiguration.GRID_COUNT];

            Grid[] grilles = { grid0, grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8, grid9 };

            DrawingPanel[] drawingPanels = { drawingPanel0, drawingPanel1, drawingPanel2, drawingPanel3,
                    drawingPanel4, drawingPanel5, drawingPanel6, drawingPanel7, drawingPanel8, drawingPanel9 };

            subPanels[i] = new JPanel(new BorderLayout());

            drawingPanels[i] = new DrawingPanel(grilles[i]);
            drawingPanels[i].setBackground(Color.GRAY);

            JButton addGridButton2 = new JButton("Ajouter une grille n°" + i);
            addGridButton2.setMargin(new Insets(2, 7, 2, 7)); // Espacement intérieur : haut, gauche, bas, droite
            addGridButton2.addActionListener(e -> drawingPanels[i].addGrid());

            JButton suppGridButton2 = new JButton("Supprimer Dessin n°" + i);
            suppGridButton2.addActionListener(e -> drawingPanels[i].deleteGrid());
            suppGridButton2.setMargin(new Insets(2, 7, 2, 7)); // Espacement intérieur : haut, gauche, bas, droite

            subPanels[i].add(drawingPanels[i], BorderLayout.CENTER);

            buttonsPanels[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
            buttonsPanels[i].add(addGridButton2);
            buttonsPanels[i].add(suppGridButton2);

            subPanels[i].add(buttonsPanels[i], BorderLayout.SOUTH);
            subPanels[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            subPanels[i].setBorder(BorderFactory.createLineBorder(Color.black));

            buttonsPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            centerPanel.add(subPanels[i]);

            drawingPanels[i].setPreferredSize(preferredSize);

            drawingPanels[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    drawingPanels[i].setLastMousePosition(e.getX(), e.getY());
                }

                public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();

                    if (SwingUtilities.isLeftMouseButton(e)) {
                        int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                                SoftwareConfiguration.BLOCK_SIZE;
                        int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                                SoftwareConfiguration.BLOCK_SIZE;

                        if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                                cellY >= 0 && cellY < SoftwareConfiguration.LINE_COUNT) {

                            Graphics g = (Graphics) drawingPanels[i].getGraphics();
                            g.setColor(Color.RED);
                            g.fillRect(
                                    cellX * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_X,
                                    cellY * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_Y,
                                    SoftwareConfiguration.BLOCK_SIZE,
                                    SoftwareConfiguration.BLOCK_SIZE);
                        }
                    }
                }
            });

            drawingPanels[i].addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();

                    int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                            SoftwareConfiguration.BLOCK_SIZE;
                    int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                            SoftwareConfiguration.BLOCK_SIZE;

                    if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                            cellY >= 0 && cellY < SoftwareConfiguration.LINE_COUNT) {

                        Graphics g = (Graphics) drawingPanels[i].getGraphics();
                        g.setColor(drawingPanels[i].getPenColor());
                        g.fillRect(
                                cellX * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_X,
                                cellY * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_Y,
                                SoftwareConfiguration.BLOCK_SIZE,
                                SoftwareConfiguration.BLOCK_SIZE);
                    }
                }
            });

        }

        JPanel resultPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 5, 5));
        resultPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel res = new JLabel("Résulat : ");
        resultPanel.add(res);

        JPanel controlPanel = new JPanel();
        // controlPanel.add(startButton);
        controlPanel.add(clearButton);
        controlPanel.add(new JLabel("Couleur:"));
        controlPanel.add(colorComboBox);
        controlPanel.add(validGridButton);

        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        add(centerPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // drawingPanel.setPreferredSize(preferredSize);
        centerPanel.setPreferredSize(preferredSize2);
        resultPanel.setPreferredSize(preferredSize3);

        /*
         * 
         * 
         * Fonctions qui marchent
         * 
         * 
         * 
         */

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /*
     * private void start() {
     * 
     * }
     */

}