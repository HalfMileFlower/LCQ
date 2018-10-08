class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int res = target;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1; 
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target - sum == 0) {
                    return target;
                } else {
                    if (Math.abs(target - sum) < diff) {
                        diff = Math.abs(target - sum);
                        res = sum;  
                    }
                    
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
