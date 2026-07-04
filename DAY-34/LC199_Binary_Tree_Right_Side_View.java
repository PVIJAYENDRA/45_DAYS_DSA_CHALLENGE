class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int level= 0;
        rightview(root , res  , level);
        return res;

        
    }
    public void rightview(TreeNode root , List<Integer> res,int level){
        if(root == null)  return;
        if(res.size() == level){
            res.add(root.val);
        }

        rightview(root.right,res,level+1);
        rightview(root.left,res,level+1);
    }
}