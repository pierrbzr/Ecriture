package gui;

import javax.swing.*;
import java.awt.*;

import config.SoftwareConfiguration;

public class ResultPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final static Dimension preferredSize3 = new Dimension(1600, 50);

    JLabel[] resGrids = { MainGUI.grid0.resultatLabel, MainGUI.grid1.resultatLabel, MainGUI.grid2.resultatLabel,
            MainGUI.grid3.resultatLabel, MainGUI.grid4.resultatLabel, MainGUI.grid5.resultatLabel,
            MainGUI.grid6.resultatLabel, MainGUI.grid7.resultatLabel, MainGUI.grid8.resultatLabel,
            MainGUI.grid9.resultatLabel };

    public void resetJLabel() {
        for (int i = 0; i < SoftwareConfiguration.GRID_COUNT; i++) {
            resGrids[i].setText("_");
        }
    }

    public ResultPanel() {

        setPreferredSize(preferredSize3);
        new FlowLayout(FlowLayout.CENTER, 5, 5);
        setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel res = new JLabel("Résulat : ");
        add(res);

        for (int i = 0; i < SoftwareConfiguration.GRID_COUNT; i++) {
            add(resGrids[i]);
        }
    }

    JLabel[] reversedResLabels = reverse(resGrids);

    static JLabel[] reverse(JLabel[] array) {
        JLabel[] newArray = new JLabel[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }

        return newArray;
    }

    
}