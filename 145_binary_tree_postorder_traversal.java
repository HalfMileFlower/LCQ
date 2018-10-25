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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        traversal(root, list);
        return list;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }
}

// Notes: left, right, root
// TC: O(n)  SC: O(h)
