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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLevel(root, result);
        return result;
    }
    
    private int findLevel(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        
        int level = Math.max(findLevel(root.left, result), findLevel(root.right, result)) + 1;
        if (level + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
        return level;
    }
}

// Notes: find level, level of a node is its index in result list
// TC: O(n) SC: O(h) - stack
