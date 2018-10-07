/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode headCopy = head;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            value = (l1Value + l2Value + carry) % 10;
            carry = (l1Value + l2Value + carry) / 10;
            head.next = new ListNode(value);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return headCopy.next;
    }
}