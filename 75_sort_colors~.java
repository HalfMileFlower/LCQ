class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int pointer0 = 0;
        int pointer2 = nums.length - 1;
        int index = 0;
        
        while (index <= pointer2) {
            if (nums[index] == 0) {
                swap(nums, index, pointer0);
                index++;
                pointer0++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, pointer2);
                pointer2--;
            }
        }
        
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

// Notes: use index to traverse the array, one pointer for 0s, the other for 2s.