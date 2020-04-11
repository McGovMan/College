

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    // Member data
    private static String workingDirectory;
    private static final Dimension WindowSize = new Dimension(800,600);
    private static final int NUMALIENS = 30;
    private static int NUMISALIVE = NUMALIENS, wave = 10, currentWave = 1;
    private Alien[] AliensArray = new Alien[NUMALIENS];
    private ArrayList<PlayerBullet> bulletList = new ArrayList();
    private Spaceship PlayerShip;
    private BufferStrategy strategy;
    private Image bulletImage, alienImage1, alienImage2, playerImage;
    private Boolean isGraphicsInstantiated = false, isGamePaused = false, isGameEnded = false;
    private int numBullets = 0, score = 0, totalScore = 0;

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
        ImageIcon alienIcon1 = new ImageIcon(workingDirectory + "/alien1.png");
        ImageIcon alienIcon2 = new ImageIcon(workingDirectory + "/alien2.png");
        ImageIcon playerIcon = new ImageIcon(workingDirectory + "/player.png");
        ImageIcon bulletIcon = new ImageIcon(workingDirectory + "/bullet.png");
        alienImage1 = alienIcon1.getImage();
        alienImage2 = alienIcon2.getImage();
        playerImage = playerIcon.getImage();
        bulletImage = bulletIcon.getImage();

        PlayerShip = new Spaceship(playerImage, WindowSize.width);
        createObjects();
        isGraphicsInstantiated = true;

        Thread t = new Thread(this);
        t.start();
    }

    public void createObjects() {
        // Creating Game Objects & Setting their position
        // Adding move into creating for loop as object is initialized, would be pointless to have second loop and increase time needed to paint.
        int xx = 50, yy = 100;

        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i] = new Alien(alienImage1, alienImage2, WindowSize.width);
            AliensArray[i].setPosition(xx, yy);
            AliensArray[i].setWinWidth(WindowSize.width);
            if (xx > 300) {
                xx = 50;
                yy += 40;
            } else {
                xx += 75;
            }
        }

        PlayerShip.setPosition(250, 500);
        PlayerShip.setWinWidth(WindowSize.width);
    }

    // Thread's entry point
    public void run() {
        int i, y, z, e;
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException r) {
                r.printStackTrace();
            }
            if (!isGamePaused) {
                for (i = 0; i < NUMALIENS; i++) {
                    if (!AliensArray[i].move()) {
                        y = i;
                        for (int u = 0; u < NUMALIENS; u++) {
                            if (u <= y) {
                                AliensArray[u].reverseDirection();
                                AliensArray[u].move();
                                AliensArray[u].move();
                            } else {
                                AliensArray[u].reverseDirection();
                                AliensArray[u].move();
                            }
                        }
                    }
                    for (z = 0; z < bulletList.size(); z++) {
                        double x1 = AliensArray[i].getXPos(), y1 = AliensArray[i].getYPos(), h1 = alienImage1.getHeight(null), w1 = alienImage1.getWidth(null), x2 = bulletList.get(z).getXPos(), y2 = bulletList.get(z).getYPos(), h2 = bulletImage.getHeight(null), w2 = bulletImage.getHeight(null);
                        if (((x1 < x2 && x1 + w1 > x2) || (x2 < x1 && x2 + w2 > x1)) && ((y1 < y2 && y1 + h1 > y2) || (y2 < y1 && y2 + h2 > y1)) && bulletList.get(z).isAlive && AliensArray[i].isAlive) {
                            AliensArray[i].setIsAlive(false);
                            bulletList.get(z).setIsAlive(false);
                            score += 10;
                            NUMISALIVE--;
                            System.out.printf("%s\n", NUMISALIVE);
                        }
                    }
                }
                for (z = 0; z < bulletList.size(); z++) {
                    if (!(bulletList.get(z).getYPos() <= 0)) bulletList.get(z).move();
                    else bulletList.remove(z);
                }
                for (e = 0; e < NUMALIENS; e++) {
                    double x1 = AliensArray[e].getXPos(), y1 = AliensArray[e].getYPos(), h1 = alienImage1.getHeight(null), w1 = alienImage1.getWidth(null), x3 = PlayerShip.getXPos(), y3 = PlayerShip.getYPos(), h3 = playerImage.getHeight(null), w3 = playerImage.getWidth(null);
                    if (((x1 < x3 && x1 + w1 > x3) || (x3 < x1 && x3 + w3 > x1)) && ((y1 < y3 && y1 + h1 > y3) || (y3 < y1 && y3 + h3 > y1)) && AliensArray[e].isAlive) {
                        System.exit(0);
                    }
                }

                PlayerShip.move();
            }
            if (NUMISALIVE <= 0) startNextWave();
            else if (currentWave == wave) isGameEnded = true;
            this.repaint();

        }
    }

    public void startNextWave() {
        currentWave += 1;
        int xx = 50, yy = 100;
        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i].setPosition(xx, yy);
            AliensArray[i].setWinWidth(WindowSize.width);
            AliensArray[i].setIsAlive(true);
            AliensArray[i].setXSpeed(AliensArray[i].xSpeed * 1.2);
            if (xx > 300) {
                xx = 50;
                yy += 40;
            } else {
                xx += 75;
            }
        }
        totalScore += score;
        NUMISALIVE = NUMALIENS;
        score = 0;
    }

    public void makeBullet() {
        PlayerBullet b = new PlayerBullet(bulletImage, WindowSize.width);
        b.setPosition(PlayerShip.getXPos()+27, PlayerShip.getYPos());
        b.setYSpeed(-4);
        bulletList.add(b);
    }

    // Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
        if (!isGamePaused) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                PlayerShip.setXSpeed(-4);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                PlayerShip.setXSpeed(4);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                makeBullet();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                isGamePaused = true;
            }
        } else if (isGameEnded && e.getKeyCode() != KeyEvent.VK_ESCAPE) System.exit(0);
        else isGamePaused = false;
    }

    public void keyReleased(KeyEvent e) {
        if (!isGamePaused) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                PlayerShip.setXSpeed(0);
            }
        }
    }

    public void keyTyped(KeyEvent e) { }

    // Applications paint method
    public void paint (Graphics g) {
        if (isGraphicsInstantiated) {
            if (!isGamePaused) {
                g = strategy.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, WindowSize.width, WindowSize.height);
                for (int i = 0; i < NUMALIENS; i++) AliensArray[i].paint(g);
                PlayerShip.paint(g);
                for (PlayerBullet b : bulletList) {
                    b.paint(g);
                }
                g.setColor(Color.WHITE);
                Font font = new Font("Serif", Font.PLAIN, 25);
                g.setFont(font);
                g.drawString("Score " + score + "  Best " + totalScore, 290, 70);
                strategy.show();
            } else if (isGamePaused) {
                g = strategy.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, WindowSize.width, WindowSize.height);
                g.setColor(Color.WHITE);
                Font font = new Font("Serif", Font.PLAIN, 40);
                g.setFont(font);
                g.drawString("GAME PAUSED", 225, 150);
                Font font1 = new Font("Serif", Font.PLAIN, 24);
                g.setFont(font1);
                g.drawString("Press any key to play", 260, 300);
                g.drawString("[Arrow keys to move, space to fire]", 180, 400);
                strategy.show();
            } else {
                g = strategy.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, WindowSize.width, WindowSize.height);
                g.setColor(Color.WHITE);
                Font font = new Font("Serif", Font.PLAIN, 40);
                g.setFont(font);
                g.drawString("GAME OVER", 260, 150);
                Font font1 = new Font("Serif", Font.PLAIN, 24);
                g.setFont(font1);
                g.drawString("Press any key to close", 260, 300);
                isGameEnded = true;
                strategy.show();
            }
        }
    }

    // Applications entry point
    public static void main (String[] args) {
        workingDirectory = System.getProperty("user.dir");
        InvadersApplication w = new InvadersApplication();
    }
}

