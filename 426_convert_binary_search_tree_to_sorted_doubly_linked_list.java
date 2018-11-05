/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // stack iterative inorder traversal
        Node head = new Node(0, null, null);
        Node pointer = head;
        
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            head.right = curr;
            curr.left = head;
            head = head.right;
            curr = curr.right;
        }
        // head.left = tail
        pointer.right.left = head;
        // tail.right = head;
        head.right = pointer.right;
        return pointer.right;
    } 
}

// Notes: use a stack to do inorder traversal, add the first element to the reslut
// connect head and tail
// remember to check root == null first
// TC: O(n)  SC: O(h) - h is the height of BST
