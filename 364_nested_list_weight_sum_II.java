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
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int layer = 0;
        int result = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger element : nestedList) {
                if (element.isInteger()) {
                    layer += element.getInteger();
                } else {
                    for (NestedInteger nextLayerElement : element.getList()) {
                        nextLevel.add(nextLayerElement);
                    }
                }
            }
            result += layer;
            nestedList = nextLevel;
        }
        
            
        return result;
    }
    
}

// Notes: basic idea:
// [1, [4, [6]]]
// 1
// 1 + 4
// 1 + 4 + 6
// result = layer1 + layer2 + layer3

// while nestedList is not empty
// use a nextLevel list to store the elements of next layer
// add the single integers to the layer
// add layer to result
// update nestedList with nextLevel list
// TC: O(n) SC: O(n)
