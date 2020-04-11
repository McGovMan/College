import java.awt.*;

public class Sprite2D {
    // member data
    private double x,y = 200;
    private double xSpeed = 0;
    private Image myImage;

    // Constructor
    public Sprite2D(Image i) {
        myImage = i;
    }

    // Public Interface
    public void moveEnemy() {

    }

    public void setPosition(double xx, double yy) {
        x = xx;
        y = yy;
    }

    public void movePlayer() { x += xSpeed * 2; }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void paint (Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(myImage, (int)x, (int)y, 69, 50, null);
    }
}