import java.awt.*;

public class Spaceship extends Sprite2D {

    // Constructor
    public Spaceship(Image i, int windowWidth) {
        super();
        myImage = i;
        x = 300;
        y = 300;
    }

    public void move() { x += xSpeed; }
}
