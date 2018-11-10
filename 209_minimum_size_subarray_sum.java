class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while (end < nums.length) {
            if (sum < s) {
                sum += nums[end];
                end++;
            } 
            
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// Notes: two pointers, start & end
// sum < s, sum += nums[end], end++
// while sum >= s, min = min(min, end - start), sum -= nums[start], start++
// remember to check if sum has been larger than s (if min is still Integer.MAX_VALUE)
// TC: O(n)  SC: O(1)
