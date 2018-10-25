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
    public List<Integer> preorderTraversal(TreeNode root) {
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
        
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
        
    }
}

// Notes: root, left, right
// TC: O(n)  SC: O(h)
