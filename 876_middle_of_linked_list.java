/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}

// Notes: quick != null && quick.next != null.  
// Also, pay attention to the definition of middle, which one is required to be return (first or second middle)
// TC: O(n) SC: O(1)