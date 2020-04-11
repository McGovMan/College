import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    // Member data
    private static String workingDirectory;
    private static final Dimension WindowSize = new Dimension(600,600);
    private static final int NUMALIENS = 30;
    private Sprite2D[] AliensArray = new Sprite2D[NUMALIENS];
    private Sprite2D PlayerShip;
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
        ImageIcon alienIcon = new ImageIcon(workingDirectory + "/src/invader.png");
        ImageIcon playerIcon = new ImageIcon(workingDirectory + "/src/player.png");
        Image alienImage = alienIcon.getImage();
        Image playerImage = playerIcon.getImage();

        // Creating Game Objects
        for (int i = 0; i < NUMALIENS; i++) AliensArray[i] = new Sprite2D(alienImage);
        PlayerShip = new Sprite2D(playerImage);
        PlayerShip.setPosition(250, 500);

        isGraphicsInstantiated = true;

        Thread t = new Thread(this);
        t.start();
    }

    // Thread's entry point
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < NUMALIENS; i++) AliensArray[i].moveEnemy();
            PlayerShip.movePlayer();
            this.repaint();
        }
    }

    // Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            PlayerShip.setXSpeed(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            PlayerShip.setXSpeed(-1);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            PlayerShip.setXSpeed(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            PlayerShip.setXSpeed(0);
        }
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            PlayerShip.setXSpeed(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            PlayerShip.setXSpeed(-1);
        }
    }

    // Applications paint method
    public void paint (Graphics g) {
        if (isGraphicsInstantiated) {
            g = strategy.getDrawGraphics();
            g.setColor(Color.WHITE);
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