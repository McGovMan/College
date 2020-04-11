import java.awt.*;

public abstract class Sprite2D {
    // member data
    protected double x,y;
    protected double xSpeed = 0;
    protected Image myImage;
    int winWidth;

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void setPosition(double xx, double yy) {
        x = xx;
        y = yy;
    }

    public void paint (Graphics g) {
        g.setColor(Color.WHITE);
        g.drawImage(myImage, (int)x, (int)y, null);
    }
}