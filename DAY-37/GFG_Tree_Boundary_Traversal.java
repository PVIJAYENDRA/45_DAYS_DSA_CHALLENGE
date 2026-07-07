/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    void addLeftBoundary(Node root) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    void addLeaves(Node root) {
        if (root == null) return;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    void addRightBoundary(Node root) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        if (node == null) return res;
        if (!isLeaf(node)) res.add(node.data);
        else {
            res.add(node.data);
            return res;
        }
        addLeftBoundary(node);
        addLeaves(node);
        addRightBoundary(node);

        return res;
    }
} 