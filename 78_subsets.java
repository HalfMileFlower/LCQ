class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        
        result.add(new ArrayList<>());
        findSubSets(0, nums, result, new ArrayList<>());
        return result;
    }
    
    private void findSubSets(int start, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            findSubSets(i + 1, nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}

// Notes: backtracking, pay attention to the empty set []
// TC: O(n*2^n)   SC: O(n*2^n) 
