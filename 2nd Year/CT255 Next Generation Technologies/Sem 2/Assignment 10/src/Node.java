
public class Node {
    int x, y, g, h, f;
    Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setF() {
        f = g + h;
    }

    public int getX() { return x; }

    public int getY() {
        return y;
    }

    public Node getParent() {
        return parent;
    }

    public int getG() {
        return g;
    }

    public int getF() {
        return f;
    }

}
