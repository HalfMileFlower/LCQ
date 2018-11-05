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

// Merge-like-tree Solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer = new ListNode(0);
        ListNode dummy = pointer;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        
        if (l1 != null) {
            pointer.next = l1;
        }
        
        if (l2 != null) {
            pointer.next = l2;
        }
        
        return dummy.next;
    }
}

// Notes: merge two lists and merge the result list with another similar list
//        O
//      /   \
//     O     O
//    / \   / \
//   O   O O   O
// mergeHelper to implement the above tree like merging process
// if start == end, return lists[start]
// TC: O(nlogk)  SC: O(1)
