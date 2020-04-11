import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MyApplication extends JFrame implements Runnable {

    private static final Dimension WindowSize = new Dimension(600,600);
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    int numOfGameObjects = 30;


    public MyApplication() {
        // Create and setup the window
        this.setTitle("Animated Tiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window, centered on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        // Creating Game Objects
        for (int i = 0; i < numOfGameObjects; i++) gameObjects.add(new GameObject(WindowSize.width, WindowSize.height));

        Thread t = new Thread(this);
        t.start();
    }

    public static void main (String[] args) {
        MyApplication w = new MyApplication();
    }

    public void paint (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);
        for (int i = 0; i < numOfGameObjects; i++) gameObjects.get(i).paint(g);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < numOfGameObjects; i++) gameObjects.get(i).move();
            this.repaint();
        }
    }
}
