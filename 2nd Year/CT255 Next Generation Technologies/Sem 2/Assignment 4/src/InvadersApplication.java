import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    // Member data
    private static String workingDirectory;
    private static final Dimension WindowSize = new Dimension(800,600);
    private static final int NUMALIENS = 30;
    private Alien[] AliensArray = new Alien[NUMALIENS];
    private Spaceship PlayerShip;
    private BufferStrategy strategy;
    private Boolean isGraphicsInstantiated = false;

    // constructor
    public InvadersApplication() {
        // Create and setup the window
        this.setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window, centered on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        addKeyListener(this);
        setVisible(true);

        createBufferStrategy(2);
        strategy = getBufferStrategy();

        // Adding Images
        ImageIcon alienIcon = new ImageIcon(workingDirectory + "/alien.png");
        ImageIcon playerIcon = new ImageIcon(workingDirectory + "/player.png");
        Image alienImage = alienIcon.getImage();
        Image playerImage = playerIcon.getImage();

        // Creating Game Objects & Setting their position
        // Adding move into creating for loop as object is initialized, would be pointless to have second loop and increase time needed to paint.
        int xx = 50, yy = 50;
        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i] = new Alien(alienImage, WindowSize.width);
            AliensArray[i].setPosition(xx, yy);
            if (xx > 300) {
                xx = 50;
                yy += 40;
            } else {
                xx += 75;
            }
        }

        PlayerShip = new Spaceship(playerImage, WindowSize.width);
        PlayerShip.setPosition(250, 500);

        isGraphicsInstantiated = true;

        Thread t = new Thread(this);
        t.start();
    }

    // Thread's entry point
    public void run() {
        int i, y, z;
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (i = 0; i < NUMALIENS; i++) {
                if(!AliensArray[i].move()) {
                    y = i;
                    for (i = 0; i < NUMALIENS; i++) {
                        if (i <= y) {
                            AliensArray[i].reverseDirection();
                            AliensArray[i].move();
                            AliensArray[i].move();
                        } else {
                            AliensArray[i].reverseDirection();
                            AliensArray[i].move();
                        }
                    }
                }
            }
            PlayerShip.move();
            this.repaint();
        }
    }

    // Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            PlayerShip.setXSpeed(-4);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(4);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(0);
        }
    }

    public void keyTyped(KeyEvent e) { }

    // Applications paint method
    public void paint (Graphics g) {
        if (isGraphicsInstantiated) {
            g = strategy.getDrawGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WindowSize.width, WindowSize.height);
            for (int i = 0; i < NUMALIENS; i++) AliensArray[i].paint(g);
            PlayerShip.paint(g);
            strategy.show();
        }
    }

    // Applications entry point
    public static void main (String[] args) {
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication w = new InvadersApplication();
    }
}