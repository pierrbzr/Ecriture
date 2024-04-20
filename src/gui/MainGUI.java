
package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import config.SoftwareConfiguration;
import engine.grid.Grid;

public class MainGUI extends JFrame {

        private static final long serialVersionUID = 1L;

        private final static Dimension preferredSize = new Dimension(SoftwareConfiguration.WINDOW_WIDTH,
                        SoftwareConfiguration.WINDOW_HEIGHT);
        private final static Dimension preferredSize2 = new Dimension(SoftwareConfiguration.WINDOW_WIDTH, 700);
        private final static Dimension preferredSize3 = new Dimension(1600, 50);

        // Création et Initialisation des Zones de Dessins

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

        private DrawingPanel[] drawingPanels = { drawingPanel0, drawingPanel1, drawingPanel2, drawingPanel3,
                        drawingPanel4, drawingPanel5, drawingPanel6, drawingPanel7, drawingPanel8, drawingPanel9 };

        // Création et Initialisation des Grilles de Dessins

        private Grid grid0 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid1 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid2 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid3 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid4 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid5 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid6 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid7 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid8 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);
        private Grid grid9 = new Grid(SoftwareConfiguration.LINE_COUNT, SoftwareConfiguration.COLUMN_COUNT);

        private Grid[] grilles = { grid0, grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8, grid9 };

        private JLabel[] drawingLabel = { grid0.resultatLabel, grid1.resultatLabel, grid2.resultatLabel,
                        grid3.resultatLabel,
                        grid4.resultatLabel, grid5.resultatLabel, grid6.resultatLabel, grid7.resultatLabel,
                        grid8.resultatLabel,
                        grid9.resultatLabel };

        JLabel[] reverseddrawinglabel = reverse(drawingLabel);

        static JLabel[] reverse(JLabel[] array) {
                JLabel[] newArray = new JLabel[array.length];

                for (int i = 0; i < array.length; i++) {
                        newArray[array.length - 1 - i] = array[i];
                }

                return newArray;
        }

        // Déclaration Variable intermediaire

        boolean couleurCell;

        // Création et Initialisation des Boutons

        private JButton[] suppGridButtons = new JButton[SoftwareConfiguration.GRID_COUNT];

        private JPanel[] subPanels = new JPanel[SoftwareConfiguration.GRID_COUNT];

        private JPanel[] buttonsPanels = new JPanel[SoftwareConfiguration.GRID_COUNT];

        // Fonction de réinitialisation de l'ensemble des grilles

        private void resetGrid() {
                for (int j = 0; j < SoftwareConfiguration.GRID_COUNT; j++) {
                        drawingPanels[j].cleanGrid(drawingPanels[j]);
                        grilles[j].InitSchema();
                }
        }

        private void addAllGrid() {
                for (int j = 0; j < SoftwareConfiguration.GRID_COUNT; j++) {
                        drawingPanels[j].addGrid(drawingPanels[j]);
                        grilles[j].InitSchema();
                        drawingPanels[j].setAffiche(true);

                }
        }

        // Déclaration Fonction Principale
        public MainGUI(String title) {
                super(title);
                init();
        }

        // Initialisation Fonction Principale
        private void init() {

                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Création de la zone de contrôle
                JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 7));

                // Création des boutons de la zone de contrôle
                JButton addButton = new JButton("Ajouter Grilles");
                addButton.addActionListener(e -> addAllGrid());
                addButton.setMargin(new Insets(3, 10, 3, 10));

                JButton clearButton = new JButton("Tout Effacer");
                clearButton.addActionListener(e -> resetGrid());
                clearButton.setMargin(new Insets(3, 10, 3, 10));

                JComboBox<String> colorComboBox = new JComboBox<>(new String[] { "Rouge", "Noir", "Bleu" });

                JButton validGridButton = new JButton("Validé !");
                validGridButton.setMargin(new Insets(3, 10, 3, 10));

                // Ajouts des boutons à la zone de contrôle
                controlPanel.add(addButton);
                controlPanel.add(clearButton);
                controlPanel.add(new JLabel("Couleur:"));
                controlPanel.add(colorComboBox);
                controlPanel.add(validGridButton);

                controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                controlPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                // centerPanel correspond à la zone principale , l'endroit où sont afficher
                // toute les zones de dessins
                JPanel centerPanel = new JPanel(new GridLayout(2, 5, 10, 10));
                centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Déclaration de la zone de Résultat
                JPanel resultPanel = new JPanel(
                                new FlowLayout(FlowLayout.CENTER, 5,
                                                5));
                resultPanel.setBorder(BorderFactory.createLineBorder(Color.black));

                // Déclaratiion des zones de textes accueillant le résultat
                JLabel res = new JLabel("Résulat : ");
                JLabel RESULTAT = new JLabel("_ _ _ _ _ _ _ _ _ _");

                // Ajouts des zones de texte dans la zone adéquate
                resultPanel.add(res);
                resultPanel.add(RESULTAT);

                // Boucle d'initialisation de chaque zone
                for (int j = 0; j < SoftwareConfiguration.GRID_COUNT; j++) {
                        final int i = j;

                        suppGridButtons[i] = new JButton("Nettoyer grille n° " + i);

                        suppGridButtons[i].addActionListener(e -> {
                                // Suppresion de la grille
                                drawingPanels[i].cleanGrid(drawingPanels[i]);
                                grilles[i].InitSchema();

                        });

                        // Panel correspondant aux espaces attribués pour les zones de dessin
                        subPanels[i] = new JPanel(new BorderLayout());

                        // Déclaration des zones de dessins
                        drawingPanels[i] = new DrawingPanel(grilles[i]);
                        drawingPanels[i].setBackground(Color.GRAY);

                        // Ajouts de la zone de dessin dans l'espace attribué
                        subPanels[i].add(drawingPanels[i], BorderLayout.CENTER);

                        // Création des boutons d'affichage et de suppresion des grilles
                        buttonsPanels[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                        buttonsPanels[i].add(suppGridButtons[i]);

                        // Placement des boutons sous la zone de dessin
                        subPanels[i].add(buttonsPanels[i], BorderLayout.SOUTH);

                        // Création de Bordures pour encadrer les parties de l'IHM
                        subPanels[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        subPanels[i].setBorder(BorderFactory.createLineBorder(Color.black));
                        buttonsPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                        // Ajouts des zones de dessins avec boutons
                        centerPanel.add(subPanels[i]);

                        drawingPanels[i].setPreferredSize(preferredSize);

                        // Outil de selection des couleurs
                        colorComboBox
                                        .addActionListener(e -> drawingPanels[i]
                                                        .setPenColor(colorComboBox.getSelectedItem().toString()));

                        // Fonction permettant à l'utilisateur de dessiner avec la souris
                        drawingPanels[i].addMouseListener(new MouseAdapter() {
                                public void mousePressed(MouseEvent e) {

                                        drawingPanels[i].setLastMousePosition(e.getX(), e.getY());

                                }

                                public void mouseClicked(MouseEvent e) {
                                        // Verification que la grille est affichée pour dessiner
                                        if (drawingPanels[i].getAffiche()) {

                                                // Récupéreration de la position de la souris
                                                int x = e.getX();
                                                int y = e.getY();

                                                // Dessin lors d'un clique gauche
                                                if (SwingUtilities.isLeftMouseButton(e)) {
                                                        int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;
                                                        int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;

                                                        if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                                                                        cellY >= 0
                                                                        && cellY < SoftwareConfiguration.LINE_COUNT) {

                                                                Graphics g = (Graphics) drawingPanels[i]
                                                                                .getGraphics();
                                                                g.setColor(Color.RED);
                                                                g.fillRect(
                                                                                cellX * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_X,
                                                                                cellY * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_Y,
                                                                                SoftwareConfiguration.BLOCK_SIZE,
                                                                                SoftwareConfiguration.BLOCK_SIZE);

                                                                grilles[i].cells[cellY][cellX].setColorie(true);

                                                        }
                                                }

                                                // Correction du dessin lors d'un clique droit
                                                if (SwingUtilities.isRightMouseButton(e)) {
                                                        int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;
                                                        int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;

                                                        if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                                                                        cellY >= 0
                                                                        && cellY < SoftwareConfiguration.LINE_COUNT) {
                                                                Graphics g = (Graphics) drawingPanels[i]
                                                                                .getGraphics();
                                                                g.setColor(Color.WHITE);
                                                                g.fillRect(
                                                                                cellX * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_X,
                                                                                cellY * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_Y,
                                                                                SoftwareConfiguration.BLOCK_SIZE,
                                                                                SoftwareConfiguration.BLOCK_SIZE);

                                                                grilles[i].cells[cellY][cellX].setColorie(false);

                                                        }
                                                }
                                                // Affichage constant du quadrillage
                                                drawingPanels[i].drawLines();
                                        }
                                }
                        });

                        // Fonction permettant à l'utilisateur de dessiner en restant appuyer sur la
                        // souris

                        drawingPanels[i].addMouseMotionListener(new MouseAdapter() {

                                public void mouseDragged(MouseEvent e) {
                                        // Verification que la grille est affichée pour dessiner

                                        if (drawingPanels[i].getAffiche()) {

                                                int x = e.getX();
                                                int y = e.getY();

                                                if (SwingUtilities.isLeftMouseButton(e)) {

                                                        int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;
                                                        int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;

                                                        if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                                                                        cellY >= 0
                                                                        && cellY < SoftwareConfiguration.LINE_COUNT) {
                                                                Graphics g = (Graphics) drawingPanels[i].getGraphics();
                                                                g.setColor(drawingPanels[i].getPenColor());
                                                                g.fillRect(
                                                                                cellX * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_X,
                                                                                cellY * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_Y,
                                                                                SoftwareConfiguration.BLOCK_SIZE,
                                                                                SoftwareConfiguration.BLOCK_SIZE);

                                                                grilles[i].cells[cellY][cellX].setColorie(true);

                                                        }
                                                } else if (SwingUtilities.isRightMouseButton(e)) {

                                                        int cellX = (x - SoftwareConfiguration.OFFSET_X) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;
                                                        int cellY = (y - SoftwareConfiguration.OFFSET_Y) /
                                                                        SoftwareConfiguration.BLOCK_SIZE;

                                                        if (cellX >= 0 && cellX < SoftwareConfiguration.COLUMN_COUNT &&
                                                                        cellY >= 0
                                                                        && cellY < SoftwareConfiguration.LINE_COUNT) {
                                                                Graphics g = (Graphics) drawingPanels[i].getGraphics();
                                                                g.setColor(Color.WHITE);
                                                                g.fillRect(
                                                                                cellX * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_X,
                                                                                cellY * SoftwareConfiguration.BLOCK_SIZE
                                                                                                + SoftwareConfiguration.OFFSET_Y,
                                                                                SoftwareConfiguration.BLOCK_SIZE,
                                                                                SoftwareConfiguration.BLOCK_SIZE);

                                                                grilles[i].cells[cellY][cellX].setColorie(false);
                                                        }
                                                }
                                                // Affichage constant du quadrillage
                                                drawingPanels[i].drawLines();
                                        }
                                }
                        });

                        validGridButton.addActionListener(e -> RESULTAT.setText(" "));
                        validGridButton.addActionListener(e -> resultPanel.add(reverseddrawinglabel[i]));

                        // validGridButton.addActionListener(e -> grilles[i].FinalSendSchema());

                }
                validGridButton.addActionListener(e -> grilles[0].ComparaisonLettre());

                // Placement des différentes zone dans la fenêtre
                add(centerPanel, BorderLayout.NORTH);
                add(resultPanel, BorderLayout.CENTER);
                add(controlPanel, BorderLayout.SOUTH);

                // Ajustement de la taille des zones
                centerPanel.setPreferredSize(preferredSize2);
                resultPanel.setPreferredSize(preferredSize3);

                pack();
                setLocationRelativeTo(null);
                setVisible(true);
                setResizable(false);

        }

}
