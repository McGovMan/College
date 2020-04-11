import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.*;

public class paintTiles extends JFrame {

    private static final Dimension WindowSize = new Dimension(600,600);

    public paintTiles() {
        // Create and setup the window
        this.setTitle("Pretty Tiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window, centered on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    }

    public static void main (String[] args) {
        paintTiles w = new paintTiles();
        System.out.print(WindowSize.width);
        System.out.print(WindowSize.height);
    }

    public void paint (Graphics a) {
        int x = 20, y = 40;

        while (x < WindowSize.width - 70 && y <= WindowSize.height - 70) {
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
            a.setColor(new Color(r, g, b));
            a.fillRect(x, y, 50, 50);
            x += 70;

            if (x > WindowSize.width - 70) {
                y += 70;
                x = 20;
            }
        }
    }
}
