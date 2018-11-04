/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Iterative Solution
 class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyTail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummyTail;
            dummyTail = head;
            head = next;
        }
        return dummyTail;
    }
}

// TC: O(n)  SC: O(1)

// Recursive Solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    
    private ListNode reverse(ListNode head, ListNode current) {
        if (head == null) {
            return current;
        }
        
        ListNode next = head.next;
        head.next = current;
        current = head;
        return reverse(next, current);
    }
}

// TC: O(n)  SC: O(n) - stack
