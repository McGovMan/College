import java.awt.*;

public class Alien extends Sprite2D {

    // Constructor
    public Alien(Image i, int windowWidth) {
        super();
        myImage = i;
        winWidth = windowWidth;
        xSpeed = 1;
    }

    public boolean move() {
        if (x >= winWidth - 50 || x <= 0) {
            return false;
        } else {
            x += xSpeed;
            return true;
        }
    }

    public void reverseDirection() {
        xSpeed *= -1;
        x += xSpeed;
        y += 50;
    }
}
