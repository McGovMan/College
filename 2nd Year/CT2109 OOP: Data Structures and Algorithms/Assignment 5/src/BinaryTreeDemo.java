/* CT2109 NUI Galway:
 * Class to demonstrate the use of BinaryTree code.
 * Based on code by Carrano & Savitch.
 * @author Michael Madden. Improved Upon By Conor Mc Govern
 */
import javax.swing.*;

public class BinaryTreeDemo
{
    public static void main(String[] args)
    {
        // Create a tree
        System.out.println("Constructing a test tree ...");
        BinaryTree<String> testTree = new BinaryTree<String>();
        createTree1(testTree);

        // Display some statistics about it
        System.out.println("\nSome statistics about the test tree ...");
        displayStats(testTree);

        // Perform in-order traversal -> Printing tree
        // Testing the tree has been deserilized from file/set from createTree1 correctly
        System.out.println("\nPrinting tree representation ...");
        displayTree(testTree);

        // Asking questions
        question(testTree);

    } // end of main

    public static String[][] flipArray(BinaryTree<String> tree, String[][] lines) {
        String[][] tmp = new String[tree.getHeight()][tree.getHeight() * tree.getHeight()];
        int x = tree.getHeight() - 1;
        for (int i = 0; i <= tree.getHeight() - 1; i++) {
            tmp[i] = lines[x];
            x--;
        }
        return tmp;
    }

    public static void displayTree(BinaryTree<String> tree) {
        // Calling inorderTraverse to get array of all nodes in order of level
        // Reversing the array as the tree is given in reverse order.
        String[][] lines = flipArray(tree, tree.inorderTraverse());

        // Displaying each row of the array which is every line of nodes in the tree
        for (String[] row : lines) {
            for (String line : row) {
                if (line != null) System.out.print(line + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void createTree1(BinaryTree<String> tree)
    {
        // To create a tree, build it up from the bottom:
        // create subtree for each leaf, then create subtrees linking them,
        // until we reach the root.

        // First the leaves
        BinaryTree<String> hTree = new BinaryTree<>("Is it an android phone?");
        BinaryTree<String> iTree = new BinaryTree<>("Is it a desktop?");
        BinaryTree<String> jTree = new BinaryTree<>("Is it a drill?");
        BinaryTree<String> kTree = new BinaryTree<>("Is it a chisel?");
        BinaryTree<String> lTree = new BinaryTree<>("Is it a penguin?");
        BinaryTree<String> mTree = new BinaryTree<>("Is it a camel?");
        BinaryTree<String> nTree = new BinaryTree<>("Is it a goldfish?");
        BinaryTree<String> oTree = new BinaryTree<>("Is it a dog?");

        // Now the subtrees joining leaves:
        BinaryTree<String> dTree = new BinaryTree<>("Is it a bird?", lTree, mTree);
        BinaryTree<String> eTree = new BinaryTree<>("Is it a fish?", nTree, oTree);
        BinaryTree<String> fTree = new BinaryTree<>("Does it have a touch screen?", hTree, iTree);
        BinaryTree<String> gTree = new BinaryTree<>("Is it a tool?", jTree, kTree);

        // Now the subtrees joining leaves:
        BinaryTree<String> bTree = new BinaryTree<>("Is it a mammal?", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("Is it a computer?", fTree, gTree);

        // Now the root
        tree.setTree("Are you thinking of an animal?", bTree, cTree);
    } // end createTree1

    public static void question(BinaryTree<String> tree) {
        // Looping over until loop is broken by System.exit or an option is chosen when a leaf node is reached and the loop is reset.
        BinaryNodeInterface<String> currentNode = tree.getRootNode();
        while (true){
            String ans;
            while(!currentNode.isLeaf()) {
                // Ask the question and update current node
                // based on the answer
                ans = getInput(currentNode.getData());
                // Comparing user input and leading them down different node children depending on their answer
                if (ans.equals("yes")) {
                    currentNode = currentNode.getLeftChild();
                } else if (ans.equals("no")){
                    currentNode = currentNode.getRightChild();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter yes or no.\n");
                }
            }

            // At the leaf: got an answer that is either right or wrong
            // Printing out the question
            ans = getInput(currentNode.getData());
            // Taking input and determining if yes or no
            // Leading them to the next function depending on their input e.g. exiting, saving, loading
            if (ans.equals("yes")) {
                JOptionPane.showMessageDialog(null, "The tree guessed correctly!\n");
                ans = getInput("Would you like to:\n\t1. Play again.\n\t2. Store the tree.\n\t3. Load a stored tree\n\t4. Quit.\n");
                if (ans.equals("1")) currentNode = tree.getRootNode();
                if (ans.equals("2")) {
                    FileIO.storeTree(tree);
                    currentNode = tree.getRootNode();
                }
                if (ans.equals("3")) {
                    tree = FileIO.loadTree();
                    currentNode = tree.getRootNode();
                }
                if (ans.equals("4")) System.exit(0);
            }
            // Adding node of information to tree on instance where tree is wrong
            // This involves setting the new correct answer and question for the tree's current answer to reflect being wrong
            else if (ans.equals("no")){
                ans = getInput("I don't know: what is the correct answer?\n");
                currentNode.setLeftChild(new BinaryNode<>("Is it a " + ans));
                currentNode.setRightChild(new BinaryNode<>(currentNode.getData()));
                ans = getInput("Distinguishing question?\n");
                currentNode.setData(ans);
                currentNode = tree.getRootNode();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter yes or no.\n");
            }
        }
    }

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

    public static void displayStats(BinaryTree<String> tree)
    {
        if (tree.isEmpty())
            System.out.println("The tree is empty");
        else
            System.out.println("The tree is not empty");

        System.out.println("Root of tree is " + tree.getRootData());
        System.out.println("Height of tree is " + tree.getHeight());
        System.out.println("No. of nodes in tree is " + tree.getNumberOfNodes());
    } // end displayStats

}
