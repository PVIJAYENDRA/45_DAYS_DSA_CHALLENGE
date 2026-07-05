/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/


class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, new ArrayList<>(), paths);
        }
        return paths;
    }

    public void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (node == null) return;
        
        // Add current node's data to the path
        path.add(node.data);
        
        // If leaf node, add a copy of the current path to the results
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            // Recursively traverse left and right subtrees
            dfs(node.left, path, paths);
            dfs(node.right, path, paths);
        }
        
        // Backtrack: remove the current node before returning to the parent
        path.remove(path.size() - 1);
    }
}
