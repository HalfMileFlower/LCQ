class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // find min
        int left = 0;
        int right = nums.length - 1;
        int target = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        return nums[right];
    }
}

// Notes: find first element smaller than the last element in rotated array.
