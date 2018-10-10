class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int kSumMax = 0;
        int start = 0;
        int end = k - 1;
        
        for (int i = 0; i <= k - 1; i++) {
            kSumMax += nums[i];
        }
        
        int slideSum = kSumMax;
        while (end < nums.length - 1) {
            slideSum = slideSum - nums[start] + nums[end + 1];
            kSumMax = Math.max(kSumMax, slideSum);
            start++;
            end++;
        }
        return ((double)kSumMax) / k;
    }
}

// Notes: pay attention to the range of nums[i] and the length of nums. if the sum is very big, we should use "long" to store sum.
// TC: O(n) SC: O(1)