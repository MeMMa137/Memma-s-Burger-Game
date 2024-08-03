import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Burger {

    private String type;
    private Rectangle bounds;
    private boolean visible;

    public Burger(String type, int x, int y, int width, int height) {
        this.type = type;
        this.bounds = new Rectangle(x, y, width, height);
        this.visible = true;
    }

    public String getType() {
        return type;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void draw(Graphics g) {
        if (visible) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.ORANGE);
            g2d.fill(bounds);
            g2d.setColor(Color.BLACK);
            g2d.draw(bounds);
        }
    }
}
