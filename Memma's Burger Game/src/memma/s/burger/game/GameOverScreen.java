import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JFrame {

    private ScoreManager scoreManager;
    private GamePanel gamePanel;

    public GameOverScreen(ScoreManager scoreManager, GamePanel gamePanel) {
        this.scoreManager = scoreManager;
        this.gamePanel = gamePanel;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Game Over");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel scoreLabel = new JLabel("Final Score: " + scoreManager.getScore(), SwingConstants.CENTER);
        scoreLabel.setBounds(50, 50, 300, 40);
        panel.add(scoreLabel);

        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(50, 120, 120, 40);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        panel.add(restartButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 120, 120, 40);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);
    }

    private void restartGame() {
        scoreManager.resetScore();
        gamePanel.restartGame(); 
        this.setVisible(false);
        this.dispose();
    }
}

