class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        
        // to avoid duplication
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j - 1] == nums[j] && j < k) {
                        j++;
                    }
                    while (nums[k] == nums[k + 1] && k > j) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                    while (nums[j - 1] == nums[j] && j < k) {
                        j++;
                    }
                } else {
                    k--;
                    while (nums[k] == nums[k + 1] && k > j) {
                        k--;
                    }
                }
            }
            
        }
        return res;
    }
}

// Notes: remember to eliminate the duplication of i, and that of j and/or k in every condition statement !