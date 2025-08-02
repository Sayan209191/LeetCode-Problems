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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode root, int sum, int target) {
        if(root == null) return false;

        if(root.left == null && root.right == null && target-(sum+root.val) == 0) {
            return true;
        }

        return helper(root.left, sum+root.val, target) || helper(root.right, sum+root.val, target);
    }
}