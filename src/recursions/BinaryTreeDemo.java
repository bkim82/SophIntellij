package recursions;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BCABinaryTree<String> tree = new BCABinaryTree<>();

        tree.insert("H");
        tree.insert("C");
        tree.insert("A");
        tree.insert("E");
        tree.insert("S");
        tree.insert("R");
        tree.insert("N");
        tree.insert("Z");

        System.out.println("Min: " + tree.getMinimum());
        System.out.println("Max: " + tree.getMaximum());

        System.out.println("Pre-order");
        tree.preOrder();

        System.out.println("in-order");
        tree.inOrder();

        System.out.println("post-order");
        tree.postOrder();


    }
}
