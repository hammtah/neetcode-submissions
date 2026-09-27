/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return  new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.getFirst();
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                queue.removeFirst();
            } 
            res.add(level);
        }

        return res;
    }
}
