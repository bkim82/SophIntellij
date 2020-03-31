package recursions;

public class BCABinaryTree<E extends Comparable<E>> {
    BCATreeNode<E> root = null;

    public BCABinaryTree() {}

    public boolean insert(E e) {
        BCATreeNode<E> newNode = new BCATreeNode<>(e);

        if (root == null) {
            root = newNode;
            return true;
        }
        BCATreeNode<E> current = root;
        BCATreeNode<E> parent = root;

        while (current != null) {
            int compare = e.compareTo(current.element);

            if (compare == 0) {
                return false;
            }
            else if (compare < 0) {
                parent = current;
                current = current.left;
            }
            else {
                parent = current;
                current = current.right;
            }
        }

        if (e.compareTo(parent.element) < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }

        return true;

    }

    public E getMinimum() {
        BCATreeNode<E> c = root;
        BCATreeNode<E> p = root;

        while (c != null) {
            p = c;
            c = c.left;
        }

        return p.element;
    }

    public E getMaximum() {
        BCATreeNode<E> c = root;

        while (true) {
            if (c.right == null) {
                return c.element;
            }
            c = c.right;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BCATreeNode<E> c) {
        System.out.println(c.element);
        if (c.left != null) {
            preOrder(c.left);
        }
        if (c.right != null) {
            preOrder(c.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BCATreeNode<E> c) {

        if (c.left != null) {
            inOrder(c.left);
        }
        System.out.println(c.element);
        if (c.right != null) {
            inOrder(c.right);
        }

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BCATreeNode<E> c) {

        if (c.left != null) {
            postOrder(c.left);
        }
        if (c.right != null) {
            postOrder(c.right);
        }
        System.out.println(c.element);
    }

    public void printTree() {
        printTree(root, ": ", "");

    }
    public void printTree(BCATreeNode<E> node, String side, String indent) {
        System.out.println(indent + side + node.element);
        if (node.left!= null) {
            printTree(node.left, "L: ", indent + "  ");
        }
        if (node.right!= null) {
            printTree(node.right, "R: ", indent + "  ");
        }
    }

}