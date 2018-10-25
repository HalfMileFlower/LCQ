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
    public List<Integer> inorderTraversal(TreeNode root) {
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
        list.add(root.val);
        traversal(root.right, list);
    }
}

// Notes: left root right
// TC: O(n) SC: O(h)

// Iterative Solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}

// Notes: use stack
// curr != null, push all left to stack, 
// curr = stack.pop(), add curr to result, curr = curr.right
// TC: O(n) SC: O(h)
