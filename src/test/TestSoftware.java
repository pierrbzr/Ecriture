package test;

import javax.swing.SwingUtilities;
import gui.MainGUI;

public class TestSoftware {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI("Ecriture"));
    }
}
