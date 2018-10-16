/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Recursive Solution
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        return addLayer(nestedList, depth);
    }
    
    private int addLayer(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int result = 0;
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                result += element.getInteger() * depth;
            } else {
                result += addLayer(element.getList(), depth + 1);
            }
        }
        return result;
    }
}

// Notes: make a addLayer helper function to add according to depth
// element.getList
// TC: O(n) n is the numbers in the list, including all layers, SC: O(1)

// Iterative solution
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int depth = 0;
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                    result += current.getInteger() * depth;
                } else {
                    for (NestedInteger element : current.getList()) {
                        queue.offer(element);
                    }
                }
            }
        }
        
        return result;
    }
}

// Notes: use a queue to store the nestedIntegers
// if the current polled nestedInteger is not a integer, offer all its elements to the end of queue
// TC: O(n) SC: O(n) n is the number of integers
