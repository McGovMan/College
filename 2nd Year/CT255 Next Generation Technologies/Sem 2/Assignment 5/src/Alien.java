

import java.awt.*;

public class Alien extends Sprite2D {
    private Image myImage2;
    private int framesDrawn = 0;

    // Constructor
    public Alien(Image i1, Image i2, int winWidth) {
        super(i1, winWidth);
        myImage2 = i2;
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

    @Override
    public void paint (Graphics g) {
        if (isAlive) {
            framesDrawn++;
            if (framesDrawn % 50 < 25) g.drawImage(myImage1, (int) x, (int) y, null);
            else g.drawImage(myImage2, (int) x, (int) y, null);
        }
    }
}

