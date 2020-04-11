

import java.awt.*;

public abstract class Sprite2D {
    // member data
    protected double x, y, xSpeed = 0, ySpeed = 0;
    protected Image myImage1;
    protected Boolean isAlive = true;
    protected int winWidth;

    public Sprite2D(Image myImage1, int winWidth) {
        this.myImage1 = myImage1;
        this.winWidth = winWidth;
    }

    public void setIsAlive(Boolean state) {
        isAlive = state;
    }

    public double getXPos() { return x; }

    public double getYPos() { return y; }

    public void setWinWidth(int winWidth) {
        this.winWidth = winWidth;
    }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void setYSpeed(double dy) {
        ySpeed = dy;
    }

    public void setPosition(double xx, double yy) {
        x = xx;
        y = yy;
    }

    public void paint (Graphics g) {
        if (isAlive) {
            g.setColor(Color.WHITE);
            g.drawImage(myImage1, (int) x, (int) y, null);
        }
    }
}

