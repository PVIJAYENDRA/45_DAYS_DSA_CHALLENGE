import java.util.*;

// Helper class to store a Node and its Horizontal Distance (hd)
class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>(); // Use Pair queue instead of Node queue
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            Node temp = curr.node;
            int hd = curr.hd;
            
            // Overwrites previous entries to keep the lowermost node
            map.put(hd, temp.data);
            
            if(temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            if(temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
