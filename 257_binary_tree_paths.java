/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Divide and Conquer Solotion
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        if (root.left == null && root.right == null) {
            result.add("" + root.val);
        }
        
        for (String leftPath : leftPaths) {
            result.add(root.val + "->" + leftPath);
        }
        
        for (String rightPath : rightPaths) {
            result.add(root.val + "->" + rightPath);
        }
        
        return result;
    }
}

// Notes: path = (root + leftPath) + (root + rightPath)
// if leaf, result.add("" + root.val)
// TC: 