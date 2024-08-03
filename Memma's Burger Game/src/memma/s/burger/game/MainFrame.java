import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private GameController gameController;
    private ScoreManager scoreManager;
    private GameTimer gameTimer;
    private GameDisplay gameDisplay;
    private GamePanel gamePanel;
    private GameSettings gameSettings;
    private SettingsManager settingsManager;
    private GameOverScreen gameOverScreen;

    public MainFrame() {
        setTitle("Fast Food Frenzy");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initializeComponents();
        configureSettings();
        setupLayout();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                settingsManager.setDifficultyLevel(gameSettings.getDifficultyLevel());
                settingsManager.setInitialTime(gameSettings.getInitialTime());
                settingsManager.setPointsPerBurger(gameSettings.getPointsPerBurger());
            }
        });
    }

    private void initializeComponents() {
        settingsManager = new SettingsManager();
        gameSettings = new GameSettings();
        gameController = new GameController();
        scoreManager = new ScoreManager();
        gameTimer = new GameTimer(gameSettings.getInitialTime(), new GameTimer.TimerListener() {
            @Override
            public void onTimeUpdate(int timeLeft) {
                gameDisplay.repaint();
            }

            @Override
            public void onTimeUp() {
                showGameOverScreen();
            }
        });
        gameDisplay = new GameDisplay(gameController, scoreManager, gameTimer);
        gamePanel = new GamePanel(gameController, scoreManager, gameTimer, gameSettings);
        gameOverScreen = new GameOverScreen(scoreManager, gamePanel);
    }

    private void configureSettings() {
        gameSettings.setDifficultyLevel(settingsManager.getDifficultyLevel());
        gameSettings.setInitialTime(settingsManager.getInitialTime());
        gameSettings.setPointsPerBurger(settingsManager.getPointsPerBurger());
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(gameDisplay, BorderLayout.CENTER);
        add(gamePanel, BorderLayout.SOUTH);
    }

    private void showGameOverScreen() {
        gameOverScreen.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
