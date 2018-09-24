class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int res = -1;
        if (nums[left] >= target) {
            res = left;
        } else {
            if (nums[right] >= target) {
                res = right;
            } else {
                res = right + 1;
            }
        }
        return res;
    }
}