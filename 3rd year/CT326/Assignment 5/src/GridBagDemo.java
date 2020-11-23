/*
 * @author Conor Mc Govern (18343763)
 * This class was in one of the examples given to us on blackboard, I have developed and adapted it to suit this assignment.
 */

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GridBagDemo extends JFrame implements ActionListener, KeyListener, MouseListener, ChangeListener {
  private final String docRoot = "/home/conor/Documents/College/3rd year/CT326/Assignment 5/";
  private final Container container;
  private final GridBagLayout layout;
  private final GridBagConstraints constraints;
  private final JPanel picturePanel;
  private final JButton animalBackgroundColorButton, flowerBackgroundColorButton, foodBackgroundColorButton;
  private final JSlider slider;
  private final String[][] filename = {{docRoot + "animal1.jpg", docRoot + "animal2.jpg", docRoot + "animal3.jpg"}, {docRoot + "flower1.jpg", docRoot + "flower2.jpg", docRoot + "flower3.jpg"}, {docRoot + "food1.jpg", docRoot + "food2.jpg", docRoot + "food3.jpg"}};
  private final Icon[][] icons = {{new ImageIcon(filename[0][0]), new ImageIcon(filename[0][1]), new ImageIcon(filename[0][2])}, {new ImageIcon(filename[1][0]), new ImageIcon(filename[1][1]), new ImageIcon(filename[1][2])}, {new ImageIcon(filename[2][0]), new ImageIcon(filename[2][1]), new ImageIcon(filename[2][2])}};
  private final JLabel picture;
  private int currentRootArray = 0; // current index in the root array (Animal, Flowers or Food)
  private int currentSubArray = 0; // current index in the sub array (picture1, picture2 or picture3)

  // set up GUI
  public GridBagDemo()
  {
    super( "Slide Shows" );

    container = getContentPane();
    layout = new GridBagLayout();
    container.setLayout( layout );

    // instantiate gridbag constraints
    constraints = new GridBagConstraints();

    addKeyListener(this);
    setFocusable(true);

    // Create all the components
    String[] names = { "Animals", "Flowers", "Food" };
    JComboBox<String> comboBox = new JComboBox<>( names );

    picture = new JLabel(icons[0][0]);
    picture.addKeyListener(this);
    picturePanel = new JPanel();
    picturePanel.setBackground( Color.CYAN );
    picturePanel.add(picture);
    picturePanel.addMouseListener(this);

    animalBackgroundColorButton = new JButton( "Animal background color" );
    flowerBackgroundColorButton = new JButton( "Flower background color" );
    foodBackgroundColorButton = new JButton( "Food background color" );

    // Set component constraints and add them

    // Set up JSlider to control diameter value
    slider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, 50 );
    slider.setMajorTickSpacing( 10 );
    slider.setPaintTicks( true );
    slider.addChangeListener(this);
    constraints.fill = GridBagConstraints.HORIZONTAL;
    slider.addKeyListener(this);
    addComponent( slider, 5, 1, 9, 1 );

    // comboBox
    // weightx and weighty are both 0: the default
    // fill is HORIZONTAL
    comboBox.addItemListener(e -> {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        currentRootArray = comboBox.getSelectedIndex();
        picture.setIcon(icons[currentRootArray][0]);
        slider.setValue(50);
      }
    });
    comboBox.addKeyListener(this);
    addComponent( comboBox, 0, 5, 1, 1 );

    // picture panel with picture added
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weightx = constraints.weighty = 1;
    addComponent( picturePanel, 1, 0, 9, 4 );
    constraints.weightx = constraints.weighty = 0;

    // animalBackgroundColorButton
    // weightx and weighty are both 0: the default
    constraints.fill = GridBagConstraints.HORIZONTAL;
    animalBackgroundColorButton.addActionListener(this);
    animalBackgroundColorButton.addKeyListener(this);
    addComponent( animalBackgroundColorButton, 6, 0, 3, 1 );

    // flowerBackgroundColorButton
    // weightx and weighty are both 0: the default
    constraints.fill = GridBagConstraints.HORIZONTAL;
    flowerBackgroundColorButton.addActionListener(this);
    flowerBackgroundColorButton.addKeyListener(this);
    addComponent( flowerBackgroundColorButton, 6, 3, 3, 1 );

    // foodBackgroundColorButton
    // weightx and weighty are both 0: the default
    constraints.fill = GridBagConstraints.HORIZONTAL;
    foodBackgroundColorButton.addActionListener(this);
    foodBackgroundColorButton.addKeyListener(this);
    addComponent( foodBackgroundColorButton, 6, 6, 3, 1 );

    setSize( 520, 520 );
    setVisible( true );
  }

  /**
   * This method sets the relevant constraints on the GridBayConstraints object and then adds the
   * component to the container with the accompanying constraints
   * @param component  Takes in a javax.swing component
   * @param row The row number on the grid that the top left of the component will snap to
   * @param column  The column number on the grid that the top left of the component will snap to
   * @param width The number of columns that the component will be allocated to occupy
   * @param height  The number of rows that the component will be allocated to occupy
   */
  private void addComponent( Component component,
                             int row, int column, int width, int height )
  {
    // set gridx and gridy
    constraints.gridx = column;
    constraints.gridy = row;

    // set gridwidth and gridheight
    constraints.gridwidth = width;
    constraints.gridheight = height;

    // set constraints and add component
    layout.setConstraints( component, constraints );
    container.add( component );
  }

  /**
   *  Entry point for the program
   *  @param args Array of strings
   */
  public static void main(String[] args)
  {
    GridBagDemo application = new GridBagDemo();

    application.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE );
  }

  @Override
  /*
   *  This function is called when the slider is scrolled.
   *  @param event  ChangeEvent - The parameter event is never used as we can access the public JSlider object.
   */
  public void stateChanged( ChangeEvent event )
  {
    // scales the image according to the slider

    int width = (int) (icons[currentRootArray][currentSubArray].getIconWidth() * (slider.getValue()/50.0));
    int height = (int) (icons[currentRootArray][currentSubArray].getIconHeight() * (slider.getValue()/50.0));
    picture.setIcon(new ImageIcon(new ImageIcon(icons[currentRootArray][currentSubArray].toString()).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
  }

  @Override
  /*
   *  This function is called when any of the buttons are clicked
   *  @param event  Action
   */
  public void actionPerformed(ActionEvent event) {
    // setting the background colour depending on the button clicked

    if (event.getSource() == animalBackgroundColorButton)
    {
      picturePanel.setBackground( Color.orange );
    }

    if (event.getSource() == flowerBackgroundColorButton)
    {
      picturePanel.setBackground( Color.red );
    }

    if (event.getSource() == foodBackgroundColorButton)
    {
      picturePanel.setBackground( Color.magenta );
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  /*
   *  This function is called when the slider is scrolled.
   *  Interestingly enough - the parameter event is never used as we can access the public JSlider object. We are required to add it here though as
   *  we need to implement the method the same as it is on the JSlider
   *  @param event  ChangeEvent
   */
  public void keyPressed(KeyEvent ke) {
    if (ke.getKeyChar() == 'n') {
      currentSubArray = (currentSubArray + 1) % 3;
      picture.setIcon(icons[currentRootArray][currentSubArray]);
      slider.setValue(50);
    }

    if (ke.getKeyChar() == 'p') {
      currentSubArray = ((currentSubArray - 1) + icons[currentRootArray].length) % 3;
      picture.setIcon(icons[currentRootArray][currentSubArray]);
      slider.setValue(50);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  /*
   *  This function is called whenever any mouse button is clicked
   *  @param event  MouseEvent
   */
  public void mouseClicked(MouseEvent event) {
    // loads the next/previous picture under the category (e.g. Animal)
    // if it gets to the last/first picture, it wraps the array

    if (event.getButton() == MouseEvent.BUTTON1) {
      currentSubArray = (currentSubArray + 1) % 3;
      picture.setIcon(icons[currentRootArray][currentSubArray]);
      slider.setValue(50);
    }

    if (event.getButton() == MouseEvent.BUTTON3) {
      currentSubArray = ((currentSubArray - 1) + icons[currentRootArray].length) % 3;
      picture.setIcon(icons[currentRootArray][currentSubArray]);
      slider.setValue(50);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

}  // end class GridBagDemo
