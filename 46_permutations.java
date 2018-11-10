class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        boolean[] visited = new boolean[nums.length];
        findPermutations(visited, nums, result, new ArrayList<Integer>());
        return result;
    }
    
    private void findPermutations(boolean[] visited, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                findPermutations(visited, nums, result, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

// Notes: backtracking, use a boolean[] visted to record if visited
// TC: O(n!)  SC: O(n)
