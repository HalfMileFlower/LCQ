class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int write = 0;
        int read = 0;
        
        for (read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                swap(nums, write, read);
                write++;
            }
        }
        
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}