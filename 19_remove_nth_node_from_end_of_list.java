/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode dummy = head;
        ListNode fast = head;
        ListNode slow = head;
        int fastSteps = 0;
        
        while (fastSteps < n) {
            fast = fast.next;
            fastSteps++;
        }
        
        if (fast == null) {
            return dummy.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy;
    }
}

// Notes: pay attention to the condition when n == the length of list and n == 0
// TC: O(n)  SC: O(1)
