class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int maxLeft = 0;
        int maxRight = 0;
        
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            
            if (maxLeft < maxRight) {
                result += maxLeft - height[left];
                left++;
            } else {
                result += maxRight - height[right];
                right--;
            }
        }
        
        return result;
    }
}

// Notes: two pointers
// maxLeft & maxRight
// each time a pointer is smaller, we can only confirm the max water on the moving side(left / right)
// add this number of water and move pointer, update maxLeft / maxRight
// TC: O(n)  SC: O(1)
