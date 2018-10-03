class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int leftBound = findLeftBound(nums, target);
        if (nums[leftBound] != target) {
            return new int[] {-1, -1};
        }
        
        int rightBound = findLeftBound(nums, target + 1);
        if (nums[rightBound] != target) {
            rightBound--;
        }
        return new int[] {leftBound, rightBound};
    }
    
    private int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] == target) {
            return left;
        }
        return right;
    }
}

// Notes: remember both leftBound and rightBound need to be checked if equal to target