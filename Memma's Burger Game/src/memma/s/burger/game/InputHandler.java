import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputHandler extends MouseAdapter {

    private GameController gameController;
    private ScoreManager scoreManager;

    public InputHandler(GameController gameController, ScoreManager scoreManager) {
        this.gameController = gameController;
        this.scoreManager = scoreManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleMouseClick(e.getPoint());
    }

    private void handleMouseClick(Point point) {
        for (Burger burger : gameController.getBurgers()) {
            if (burger.isVisible() && burger.getBounds().contains(point)) {
                burger.setVisible(false);
                scoreManager.increaseScore(gameController.getPointsPerBurger());
                break;
            }
        }
    }
}
