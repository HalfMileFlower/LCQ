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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Map<Integer, ArrayList<Integer>> levels = new HashMap<>();
        Map<TreeNode, Integer> valToLevel = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = 0;
        int max = 0;
        ArrayList<Integer> level0 = new ArrayList<>();
        level0.add(root.val);
        levels.put(0, level0);
        valToLevel.put(root, 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                int currentLevel = valToLevel.get(current);
                if (current.left != null) {
                    queue.offer(current.left);
                    int leftLevel = currentLevel - 1;
                    min = Math.min(min, leftLevel);
                    valToLevel.put(current.left, leftLevel);
                    if (!levels.containsKey(leftLevel)) {
                        levels.put(leftLevel, new ArrayList<>());
                    }
                    levels.get(leftLevel).add(current.left.val);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    int rightLevel = currentLevel + 1;
                    max = Math.max(max, rightLevel);
                    valToLevel.put(current.right, rightLevel);
                    if (!levels.containsKey(rightLevel)) {
                        levels.put(rightLevel, new ArrayList<>());
                    }
                    levels.get(rightLevel).add(current.right.val);
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            result.add(levels.get(i));
        }
        
        return result;
    }
}

// Notes: root level = 0; root.left level = root level - 1, root.right level = root level + 1
// use HashMap to store level to list, and another HashMap for level of each node
// do level order traversal and assign levels to each node, use min and max to update level range
// add lists from min to max 
// TC: O(n)  SC: O(n)
