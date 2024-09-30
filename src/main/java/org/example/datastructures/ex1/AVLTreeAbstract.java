package org.example.datastructures.ex1;

public abstract class AVLTreeAbstract {
    protected Node root;

    public AVLTreeAbstract(Node root) {
        this.root = root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    void updateHeight(Node n) {
        n.height = 1 + Math.max(calculateHeight(n.left), calculateHeight(n.right));
    }

    int calculateHeight(Node n) {
        return n == null ? -1 : n.height;
    }

    int getBalanceStatus(Node n) {
        return (n == null) ? 0 : calculateHeight(n.right) - calculateHeight(n.left);
    }
    Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
}
