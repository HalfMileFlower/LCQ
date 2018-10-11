class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0){
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

// Notes: keep a sum and max. 
// if sum < 0, then we don't need to add it with the upcoming number.
// if sum > 0, we can add it with the upcoming number.
// calculate max each time a new number comes.
// TC: O(n)  SC: O(1)
