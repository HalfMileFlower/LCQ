/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger element = nestedList.get(i);
                stack.push(element);
        }
    }

    @Override
    public Integer next() {
        NestedInteger top = stack.pop();
        return top.getInteger();
        
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger topElement = stack.peek();
            if (topElement.isInteger()) {
                return true;
            }
            stack.pop();
            List<NestedInteger> topList = topElement.getList();
            for (int i = topList.size() - 1; i >= 0; i--) {
                stack.push(topList.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Notes:
// Key of this question: using a stack to store NestedIntegers from end to beginning
// next(): just return the top integer
// hasNdext(): if top is integer, return it; else remove the top and convert it to a list of NIs, from end to beginning push all NIs into stack, return true when top is an integer
// while the stack is empty, hasNext() returns false
// TC: (assume the input list is an arraylist and the get() is O(1)) O(1) for next(), O(d) for the hasNext(), where d is the "depth" of the nestedInteger
// SC: O(n) n is the number of integers in the input list
