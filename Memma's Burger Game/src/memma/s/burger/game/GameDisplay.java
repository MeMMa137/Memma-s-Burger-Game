public class GameDisplay extends JPanel {

    private GameController gameController;
    private ScoreManager scoreManager;
    private GameTimer gameTimer;

    public GameDisplay(GameController gameController, ScoreManager scoreManager, GameTimer gameTimer) {
        this.gameController = gameController;
        this.scoreManager = scoreManager;
        this.gameTimer = gameTimer;
        setBackground(Color.WHITE);
        InputHandler inputHandler = new InputHandler(gameController, scoreManager);
        addMouseListener(inputHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGameElements(g2d);
        drawScore(g2d);
        drawTimer(g2d);
    }

    private void drawGameElements(Graphics2D g2d) {
        for (Burger burger : gameController.getBurgers()) {
            burger.draw(g2d);
        }
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(g2d.getFont().deriveFont(20f));
        g2d.drawString("Score: " + scoreManager.getScore(), 10, 30);
    }

    private void drawTimer(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(g2d.getFont().deriveFont(20f));
        g2d.drawString("Time: " + gameTimer.getTimeLeft(), getWidth() - 150, 30);
    }
}
