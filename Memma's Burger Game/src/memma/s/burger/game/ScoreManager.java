import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class ScoreManager {

    private int score;
    private int highScore;

    public ScoreManager() {
        score = 0;
        highScore = 0;
    }

    public void increaseScore(int amount) {
        score += amount;
        if (score > highScore) {
            highScore = score;
        }
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("High Score: " + highScore, 10, 60);
    }
}
