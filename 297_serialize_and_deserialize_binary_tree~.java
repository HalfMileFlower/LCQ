/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            if (current == null) {
                continue;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
        
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Notes: serialize: number -> "number", null -> "#", use a StringBuilder to append each node
// deserialize: split by ",", use an arraylist to store the nodes already visited and an index to mark current parent node, also an isLeftChild boolean to check if left or right child
// TC: serialize: O(n) deserialize: O(n) (split() takes O(N), N is the length of the string)  SC: serialize: O(n)  deserialize: O(n)
