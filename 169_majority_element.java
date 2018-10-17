class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != major) {
                freq--;
                if (freq == 0) {
                    major = nums[i];
                    freq++;
                }
            } else {
                freq++;
            }
        }
        return major;
    }
}

// Notes: assume the first num is majority, freq = 1. 
// if we meet a number other than majority, freq--; else freq++;
// when freq == 0, we need to update the majority with the current num and freq = 1(freq++);
// TC: O(n) SC: O(1);
