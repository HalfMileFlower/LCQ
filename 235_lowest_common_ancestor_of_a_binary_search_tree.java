/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}

// Notes: if p, q < left || right < p, q, update root
// TC: O(h) SC: O(1) h is the height of the tree
// (in case of overflow, I'd do (root.val - (long)p.val) * (root.val - (long)q.val))

// Recursive Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

// Notes: if p, q at left of root, lca(left, p, q)
// if p, q at right of root, lca(right, p, q)
// else return root
// TC: O(h) SC: O(1) h is the height of the tree