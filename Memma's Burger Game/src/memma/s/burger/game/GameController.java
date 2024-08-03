import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {

    private List<Burger> burgers;
    private Random random;
    private int burgerWidth = 100;
    private int burgerHeight = 50;
    private int panelWidth = 800;
    private int panelHeight = 600;

    public GameController() {
        burgers = new ArrayList<>();
        random = new Random();
    }

    public void startGame() {
        burgers.clear();
        generateBurgers();
    }

    public void generateBurgers() {
        int numberOfBurgers = 10; // Numero di panini da generare
        for (int i = 0; i < numberOfBurgers; i++) {
            int x = random.nextInt(panelWidth - burgerWidth);
            int y = random.nextInt(panelHeight - burgerHeight);
            burgers.add(new Burger("Burger " + i, x, y, burgerWidth, burgerHeight));
        }
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void checkBurgerClick(Point clickPoint) {
        for (Burger burger : burgers) {
            if (burger.isVisible() && burger.getBounds().contains(clickPoint)) {
                burger.setVisible(false);
            }
        }
    }
}