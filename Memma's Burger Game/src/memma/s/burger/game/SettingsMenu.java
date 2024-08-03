import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends JFrame {

    private GameSettings gameSettings;

    public SettingsMenu(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        setTitle("Settings Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel difficultyLabel = new JLabel("Difficulty:");
        difficultyLabel.setBounds(10, 20, 80, 25);
        panel.add(difficultyLabel);

        JComboBox<String> difficultyComboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        difficultyComboBox.setBounds(100, 20, 165, 25);
        difficultyComboBox.setSelectedIndex(gameSettings.getDifficultyLevel() - 1);
        panel.add(difficultyComboBox);

        JLabel timeLabel = new JLabel("Initial Time:");
        timeLabel.setBounds(10, 50, 80, 25);
        panel.add(timeLabel);

        JTextField timeText = new JTextField(Integer.toString(gameSettings.getInitialTime()));
        timeText.setBounds(100, 50, 165, 25);
        panel.add(timeText);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 80, 80, 25);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.setDifficultyLevel(difficultyComboBox.getSelectedIndex() + 1);
                gameSettings.setInitialTime(Integer.parseInt(timeText.getText()));
                dispose();
            }
        });
    }
}

