import java.util.*;

// Structure of a tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Main {
    // Function for traversing tree using
    // preorder postorder and inorder method
    static void traverse(Node root, List<Integer> pre, List<Integer> post, List<Integer> in) {

        if (root == null) {
            return;
        }

        // Pushes the root data into the pre-order vector
        pre.add(root.data);

        // Recursively call for the left node
        traverse(root.left, pre, post, in);

        // Pushes node data into the in-order vector
        in.add(root.data);

        // Recursively call for the right node
        traverse(root.right, pre, post, in);

        // Pushes the node data into the post-order vector
        post.add(root.data);
    }

    // Driver code
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.left.right = new Node(12);
        root.left.right.left = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(11);

        // Declaring the vector function to store
        // in, post, pre-order values
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();

        // Calling the function
        traverse(root, pre, post, in);

        // Print the values of pre-order, post-order,
        // and in-order
        System.out.print("Pre Order  : ");
        for (int i : pre) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("Post Order : ");
        for (int i : post) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("In Order   : ");
        for (int i : in) {
            System.out.print(i + " ");
        }
    }
}

