class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int answer = 0;
        for (int longest = 2; longest < nums.length; longest++) {
            int first = 0;
            int second = longest - 1;
            while (first < second) {
                if (nums[first] + nums[second] > nums[longest]) {
                    answer += second - first;
                    second--;
                } else {
                    first++;
                }
            }
        }
        return answer;
    }
}

// Notes: traverse longest (longest edge), if first + second > longest, answer += second - first, second--
// else: first++
// TC: O(n^2) SC: O(1)
