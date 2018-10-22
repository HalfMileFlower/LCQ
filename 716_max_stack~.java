class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    public ListNode (int val) {
        this.val = val;
    }
}

class DoubleLinkedList {
    ListNode head, tail;
    
    public DoubleLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public ListNode add(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        return newNode;
    }
    
    public int pop() {
        return unlink(tail.prev).val;
    }
    
    public int peek() {
        return tail.prev.val;
    }
    
    public ListNode unlink(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

class MaxStack {
    TreeMap<Integer, List<ListNode>> map;
    DoubleLinkedList dll;
    
    /** initialize your data structure here. */
    public MaxStack() {
        map = new TreeMap<>();
        dll = new DoubleLinkedList();
    }
    
    public void push(int x) {
        ListNode node = dll.add(x);
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<ListNode>());
        } 
        map.get(x).add(node);
    }
    
    public int pop() {
        int val = dll.pop();
        List<ListNode> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(val);
            //O(logn)
        }
        return val;
        
    }
    
    public int top() {
        return dll.peek();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        List<ListNode> list = map.get(max);
        ListNode node = list.remove(list.size() - 1);
        dll.unlink(node);
        if (list.isEmpty()) {
            map.remove(max);
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

 // Notes: TreeMap + DoubleLinkedList
 // TreeMap -> lastKey()  O(logn)
 // TC: peek O(1) others O(logn) SC: O(n)
 