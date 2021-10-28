import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/* CT2109 NUI Galway:
 * Class to handle file io in project
 * @author Conor Mc Govern
 */

public class FileIO extends JPanel {
    Scanner s = new Scanner(System.in);

    public static String getInput(String question) {
        String in = JOptionPane.showInputDialog(null, question);
        if (in == null) System.exit(0);
        else if (in.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter a valid input");
            return getInput(question);
        } else {
            return in;
        }
        return in;
    }

    public static void storeTree(BinaryTree<String> tree) {
        String question = "Please enter the name of the time you would like to store to under path: " + System.getProperty("user.dir");
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(getInput(question));
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(tree);

            out.close();
            file.close();
        }

        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter a filename");
            System.out.println("IOException is caught");
            storeTree(tree);
        }
    }

    public static BinaryTree<String> loadTree() {
        BinaryTree<String> tree = null;
        String question = "Please enter the name of the time you would like to load to under path: " + System.getProperty("user.dir");
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(getInput(question));
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            tree = (BinaryTree<String>) in.readObject();

            in.close();
            file.close();

            return tree;
        }

        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter a filename");
            System.out.println("IOException is caught");
            return loadTree();

        }

        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter a filename");
            System.out.println("ClassNotFoundException is caught");
            return loadTree();
        }
    }
}
