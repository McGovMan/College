import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.lang.Math;

public class GameOfLife extends JFrame implements Runnable, MouseListener {
    // Member data
    private static String workingDirectory;
    private static final Dimension WindowSize = new Dimension(800,800);
    private int NUMDOTS = 40;
    private Boolean[][] arr = new Boolean[NUMDOTS][NUMDOTS];
    private BufferStrategy strategy;
    private Boolean isGraphicsInstantiated = false;

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
            Arrays.fill(arr[i], false);
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
                    if (arr[i][y]) {
                        g.fillRect(y*20, i*20, 20, 20);
                    }
                }
            }
            strategy.show();
        }
    }

    // Applications entry point
    public static void main (String[] args) {
        workingDirectory = System.getProperty("user.dir");
        GameOfLife gol = new GameOfLife();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        int x = (int) Math.floor((mouseEvent.getPoint().getX())/20), y = (int) Math.floor((mouseEvent.getPoint().getY())/20);
        arr[y][x] = !arr[y][x];
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}