import java.awt.*;

public class GameObject {
    // member data
    private int x,y;
    private Color c;

    // Constructor
    public GameObject(int winX, int winY) {
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        c = new Color(red, green, blue);

        x = (int)(Math.random()*winX);
        y = (int)(Math.random()*winY);

    }

    // Public Interface
    public void move() {
        if (Math.random() < 0.5) x += 1;
        if (Math.random() >= 0.5) x -= 1;
        if (Math.random() < 0.5) y += 1;
        if (Math.random() >= 0.5) y -= 1;
    }

    public void paint (Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, 50, 50);
    }
}
