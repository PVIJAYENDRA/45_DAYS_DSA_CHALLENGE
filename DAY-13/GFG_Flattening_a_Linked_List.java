class Solution {
    public Node flatten(Node root) {
        // Base case: if list is empty or reaches the last vertical list
        if (root == null || root.next == null) {
            return root;
        }
        
        // Recur for the list on the right
        Node mergeHead = flatten(root.next);
        
        // Merge the current vertical list with the flattened remaining list
        return merge(root, mergeHead);
    }

    public Node merge(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.bottom = list1;
                temp = list1;
                list1 = list1.bottom;
            } else {
                temp.bottom = list2;
                temp = list2;
                list2 = list2.bottom;
            }
            // Optional: Only keep if the platform strictly validates next == null for all nodes
            temp.next = null; 
        }

        
        if (list1 != null) {
            temp.bottom = list1;
        } else {
            temp.bottom = list2;
        }

        // Ensure the root next pointer of the merged result is null
        if (dummyNode.bottom != null) {
            dummyNode.bottom.next = null;
        }

        return dummyNode.bottom;
    }
}
