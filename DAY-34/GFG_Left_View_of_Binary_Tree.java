/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        int level = 0;
        leftOrderView(root, res , level);
        return res;
        
    }
    
    public void leftOrderView(Node root , ArrayList<Integer> res, int level){
        if( root == null) return;
        
        if(res.size() == level){
            res.add(root.data);
        }
        leftOrderView(root.left,res,level+1);
        leftOrderView(root.right,res,level+1);
    }
}