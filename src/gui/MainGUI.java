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

        JPanel controlPanel = new JPanel();
        // controlPanel.add(startButton);
        controlPanel.add(clearButton);
        controlPanel.add(new JLabel("Couleur:"));
        controlPanel.add(colorComboBox);
        controlPanel.add(validGridButton);

        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel centerPanel = new JPanel(new GridLayout(2, 5, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // centerPanel.setBackground(Color.RED);

        for (int i = 0; i < 10; i++) {

            JPanel subPanel = new JPanel(new BorderLayout());

            Grid grid = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
            drawingPanel = new DrawingPanel(grid);
            drawingPanel.setBackground(Color.GRAY);
            subPanel.add(drawingPanel, BorderLayout.CENTER);

            JButton addGridButton2 = new JButton("Ajouter une grille");
            addGridButton2.addActionListener(e -> drawingPanel.addGrid());

            JButton suppGridButton2 = new JButton("Supprimer Dessin");
            suppGridButton2.addActionListener(e -> drawingPanel.deleteGrid());
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));

            buttonsPanel.add(addGridButton2);
            buttonsPanel.add(suppGridButton2);

            subPanel.add(buttonsPanel, BorderLayout.SOUTH);
            subPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            subPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            centerPanel.add(subPanel);

        }

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        resultPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel name = new JLabel("Résulat : ");
        resultPanel.add(name);

        add(centerPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        drawingPanel.setPreferredSize(preferredSize);
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

        drawingPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                drawingPanel.setLastMousePosition(e.getX(), e.getY());
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

                        Graphics g = (Graphics) drawingPanel.getGraphics();
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

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                        SoftwareConfiguration.BLOCK_SIZE;
                int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                        SoftwareConfiguration.BLOCK_SIZE;

                if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                        cellY >= 0 && cellY < SoftwareConfiguration.LINE_COUNT) {

                    Graphics g = (Graphics) drawingPanel.getGraphics();
                    g.setColor(drawingPanel.getPenColor());
                    g.fillRect(
                            cellX * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_X,
                            cellY * SoftwareConfiguration.BLOCK_SIZE + SoftwareConfiguration.OFFSET_Y,
                            SoftwareConfiguration.BLOCK_SIZE,
                            SoftwareConfiguration.BLOCK_SIZE);
                }
            }
        });

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