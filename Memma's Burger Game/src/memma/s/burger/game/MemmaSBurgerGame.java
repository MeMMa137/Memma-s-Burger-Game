package memma.s.burger.game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Fast Food Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(new GamePanel()); // Assicurati che GamePanel esista e sia configurato correttamente
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}
