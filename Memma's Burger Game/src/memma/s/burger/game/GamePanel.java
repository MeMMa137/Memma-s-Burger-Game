import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements ActionListener {

    private JButton startButton;
    private JLabel timerLabel;
    private Timer timer;
    private int timeLeft;
    private boolean gameRunning;

    public GamePanel() {
        setLayout(null);
        initializeComponents();
        initializeTimer();
    }

    private void initializeComponents() {
        startButton = new JButton("Start Game");
        startButton.setBounds(350, 250, 100, 40);
        startButton.addActionListener(e -> startGame());
        add(startButton);

        timerLabel = new JLabel("Time: 0");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setBounds(350, 100, 200, 40);
        add(timerLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameRunning) {
                    handleClick(e.getX(), e.getY());
                }
            }
        });
    }

    private void initializeTimer() {
        timer = new Timer(1000, this);
        timeLeft = 60;
    }

    private void startGame() {
        gameRunning = true;
        startButton.setEnabled(false);
        timeLeft = 60;
        timer.start();
    }

    private void handleClick(int x, int y) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timeLeft > 0) {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);
        } else {
            timer.stop();
            gameRunning = false;
            startButton.setEnabled(true);
        }
    }
}

