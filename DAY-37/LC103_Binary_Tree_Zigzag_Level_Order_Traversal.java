class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Using LinkedList to allow fast insertions at both ends
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    row.addLast(node.val);  // Normal append
                } else {
                    row.addFirst(node.val); // Prepends to handle reverse order
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(row);
            leftToRight = !leftToRight; // Flip direction
        }
        return result;
    }
}
