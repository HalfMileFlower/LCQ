/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive Solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= max || root.val <= min) {
            return false;
        }
        
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}

// Notes: a node's value is bounded, root.left.val smaller than root.val
// also, root.right.val larger than root
// TC: O(n) SC: O(n) - n for stack