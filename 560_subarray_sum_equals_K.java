class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToFreq = new HashMap<>();
        sumToFreq.put(0, 1);
        int result = 0, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToFreq.containsKey(sum - k)) {
                result += sumToFreq.get(sum - k);
            }
            
            if (sumToFreq.containsKey(sum)) {
                sumToFreq.put(sum, sumToFreq.get(sum) + 1);
            } else {
                sumToFreq.put(sum, 1);
            }
        }
        
        return result;
    }
}

// Notes: sum[i, j] = sum[0, j] - sum[0, i - 1];
// use a map to store all sums and their frequencies
// check how many (sum - k) have we found, and add them to result
// remember to put (0, 1) at the beginning
// TC: O(n)  SC: O(n)
