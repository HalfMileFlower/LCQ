/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] longest = new int[1];
        maxDepth(root, longest);
        return longest[0];
    }
    
    private int maxDepth(TreeNode root, int[] longest) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left, longest);
        int rightDepth = maxDepth(root.right, longest);
        
        longest[0] = Math.max(longest[0], leftDepth + rightDepth);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// Notes: max(left + right, max(left, right))