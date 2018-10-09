class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}

// Notes: partition like quick sort into three parts
// start == end return 
// left <= right (from quick sort), if left < right, then stack overflow, an example is [3, 2, 1, 5, 6, 4] -> 2   =>  [6, 5] -> 2 repeating
// start + k - 1 <= right, determine which side, remember here "start + k - 1"
// if lies in the right part, exclude the first (left - start) elements
