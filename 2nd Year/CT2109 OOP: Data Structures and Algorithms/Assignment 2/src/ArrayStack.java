import javax.swing.JOptionPane;

public class ArrayStack implements Stack
{
    protected int capacity; 			// The actual capacity of the stack array
    protected static final int CAPACITY = 1000;	// default array capacity
    protected Object S[];			// array used to implement the stack
    protected int top = -1;			// index for the top of the stack

    public ArrayStack() {
        // default constructor: creates stack with default capacity
        this(CAPACITY);
    }

    public ArrayStack(int cap) {
        // this constructor allows you to specify capacity of stack
        capacity = (cap > 0) ? cap : CAPACITY;
        S = new Object[capacity];
    }

    public void push(Object element) {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "ERROR: Stack is full.");
            return;
        }
        top++;
        S[top] = element;
    }

    public Object pop() {
        Object element;
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: Stack is empty.");
            return  null;
        }
        element = S[top];
        S[top] = null;
        top--;
        return element;
    }

    public Object top() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: Stack is empty.");
            return null;
        }
        return S[top];
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean isFull() {
        return (top == capacity-1);
    }

    public int size() {
        return (top + 1);
    }
}