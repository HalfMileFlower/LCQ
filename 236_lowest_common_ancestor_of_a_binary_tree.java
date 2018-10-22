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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

// Notes: https://www.youtube.com/watch?v=13m9ZCB8gjw
// check if current node is p / q
// if yes -> assign p / q to current
// if no -> assign null to current
// if left and right are all not null, we get lca
// TC: O(n) SC: O(1) (O(h) on stack)

