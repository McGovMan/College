import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.lang.Math;

public class GameOfLife extends JFrame implements Runnable, MouseListener {
    // Member data
    //private static String workingDirectory;
    private static final Dimension WindowSize = new Dimension(800,800);
    private int NUMDOTS = 40;
    private Boolean[][][] gameState = new Boolean[NUMDOTS][NUMDOTS][2];
    private BufferStrategy strategy;
    private Boolean isGraphicsInstantiated = false, isGamePlaying = false;

    public GameOfLife() {
        // Create and setup the window
        this.setTitle("Conway's Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window, centered on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        createBufferStrategy(2);
        strategy = getBufferStrategy();

        addMouseListener(this);

        for (int i = 0; i < NUMDOTS; i++) {
            for (int z = 0; z < NUMDOTS; z++) {
                gameState[i][z][0] = false;
            }
        }

        isGraphicsInstantiated = true;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException r) {
                r.printStackTrace();
            }
            if (isGamePlaying) {
                for (int i = 0; i < NUMDOTS; i++) {
                    for (int z = 0; z < NUMDOTS; z++) {
                        gameState[i][z][1] = false;
                    }
                }
                for (int x = 0; x < 40; x++) {
                    for (int y = 0; y < 40; y++) {
                        // count the live neighbours of cell [x][y][0]
                        int count = 0;
                        for (int xx = -1; xx <= 1; xx++) {
                            for (int yy = -1; yy <= 1; yy++) {
                                if (xx != 0 || yy != 0) {
                                    // check cell [x+xx][y+yy][0]
                                    // but.. what if x+xx==-1, etc. ?
                                    int xxx = Math.floorMod(x + xx, 39), yyy = Math.floorMod(y + yy, 39);
                                    if (gameState[xxx][yyy][0]) count ++;
                                }
                            }
                        }
                        if (count < 2 && gameState[x][y][0]) gameState[x][y][1] = false;
                        else if ((count == 2 || count == 3) && gameState[x][y][0]) gameState[x][y][1] = true;
                        else if (count > 3 && gameState[x][y][0]) gameState[x][y][1] = false;
                        else if (!gameState[x][y][0] && count == 3) gameState[x][y][1] = true;
                    }
                }
                for (int i = 0; i < NUMDOTS; i++) {
                    for (int z = 0; z < NUMDOTS; z++) {
                        gameState[i][z][0] = gameState[i][z][1];
                    }
                }
            }
            this.repaint();
        }
    }

    public void paint (Graphics g) {
        if (isGraphicsInstantiated) {
            g = strategy.getDrawGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WindowSize.width, WindowSize.height);
            g.setColor(Color.WHITE);
            for (int i = 0; i < NUMDOTS; i++) {
                for (int y = 0; y < NUMDOTS; y++) {
                    if (gameState[i][y][0]) {
                        g.fillRect(y * 20, i * 20, 20, 20);
                    }
                }
            }

            g.setColor(Color.GREEN);
            g.fillRect(10, 30, 100, 40);
            g.setColor(Color.BLACK);
            Font font = new Font("Serif", Font.PLAIN, 24);
            g.setFont(font);
            g.drawString("Start", 25, 55);
            g.setColor(Color.GREEN);
            g.fillRect(150, 30, 100, 40);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("Random", 150, 55);
            strategy.show();
        }
    }

    // Applications entry point
    public static void main (String[] args) {
        GameOfLife gol = new GameOfLife();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int x = (int) Math.floor((mouseEvent.getPoint().getX())), y = (int) Math.floor((mouseEvent.getPoint().getY()));
        if (x < 250 && x > 150 && y < 70 && y > 30) {
            // Random
            for (int i = 0; i < NUMDOTS; i++) {
                for (int z = 0; z < NUMDOTS; z++) {
                    gameState[i][z][0] = !(Math.random() < .5);
                }
            }
        } else if (x < 110 && x > 10 && y < 70 && y > 30) {
            // Start
            isGamePlaying = true;
        }
        gameState[y/20][x/20][0] = !gameState[y/20][x/20][0];
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}