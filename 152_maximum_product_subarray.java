class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            } 
            
            currentMax = Math.max(nums[i] * currentMax, nums[i]);
            currentMin = Math.min(nums[i] * currentMin, nums[i]);
            
            max = Math.max(max, currentMax);
        }
        return max;
    }
}

// Notes: use currentMax & currentMin to record current product
// if nums[i] < 0, smallest * nums[i] => biggest, so swap currentMax and currentMin
// recalculate currentMax & currentMin with Math.max(), Math.min()
// use max to keep the result max
// TC: O(n) SC: O(1)
