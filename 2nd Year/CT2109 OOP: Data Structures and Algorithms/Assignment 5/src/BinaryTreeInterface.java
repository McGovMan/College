/**
 * An interface for the ADT binary tree.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T>
{
    /** Task: Sets an existing binary tree to a new one-node binary tree.
     *  @param rootData   an object that is the data in the new treeÕs root
     */
    public void setTree(T rootData);

    /** Task: Sets an existing binary tree to a new binary tree.
     *  @param rootData   an object that is the data in the new treeÕs root
     *  @param leftTree   the left subtree of the new tree
     *  @param rightTree  the right subtree of the new tree */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree);
} // end BinaryTreeInterface
