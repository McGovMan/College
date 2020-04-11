

import java.awt.*;

public class PlayerBullet extends Sprite2D {

    // Constructor
    public PlayerBullet(Image i, int winWidth) {
        super(i, winWidth);
    }

    public void move() {
        y += ySpeed;
    }
}

