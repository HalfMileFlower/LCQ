/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// PriorityQueue Solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        
        PriorityQueue<ListNode> listHeads = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
           public int compare(ListNode l1, ListNode l2) {
               return l1.val - l2.val;
           }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                listHeads.offer(lists[i]);
            }
        }
        
        while (listHeads.size() != 0) {
            ListNode current = listHeads.poll();
            pointer.next = current;
            pointer = pointer.next;
            if (current.next == null) {
                continue;
            }
            listHeads.offer(current.next);
        }
        
        return dummy.next;
    }
}

// Notes: PriorityQueue to poll() the smallest head of all list
// pay attention to null ListNodes !!!
// TC: O(nlogk) - n: number of all listNodes, k: length of lists
// SC: O(k)
