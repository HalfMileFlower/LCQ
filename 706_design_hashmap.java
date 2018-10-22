class MyHashMap {
    Bucket[] buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Bucket[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getHashCode(key);
        if (buckets[index] == null) {
            buckets[index] = new Bucket();
        }
        ListNode prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);
        if (buckets[index] == null) {
            return -1;
        }
        ListNode prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHashCode(key);
        if (buckets[index] == null) {
            return;
        }
        ListNode prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
    
    public int getHashCode(int i) {
        return Integer.hashCode(i) % buckets.length;
    }
    
    public ListNode findPrev(Bucket bucket, int key) {
        ListNode node = bucket.head;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    ListNode head;
    
    public Bucket() {
        head = new ListNode(-1, -1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Notes: define class ListNode(key, value) and next;
// define class Bucket with new head(-1, -1) (not in the range of key / value)
// getHashCode(i) to get hash code of i & findPrev(bucket, key) to find the node before node(key, value)
// put: get hash code -> if bucket[index] null -> create new bucket; findPrev(), if prev.next null, prev.next = new; otherwise update prev.next.value
// get: get hash code -> if bucket[index] null, return -1; findPrev(), if prev.next null, return -1; else return prev.next.value
// remove: get hash code -> if bucket[index] null, return; findPrev(), if prev.next null, return; else prev.next = prev.next.next(remove the prev.next)
// TC: all O(N) n is the size of the LinkedList of each bucket  SC:O(n) n put elements
