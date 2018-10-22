class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 2) {
            return result;
        }
        
        findCombinations(2, n, new ArrayList<>(), result);
        return result;
    }
    
    private void findCombinations(int start, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        for (int i = start; i * i <= target; i++) {
            if (target % i == 0) {
                list.add(i);
                list.add(target / i);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                findCombinations(i, target / i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}

// Notes: backtracking
// each time find a divisible number i, add i and n / i to list
// add list and find the combinations of n / i (remember to remove the last number of list)
// remove the last number in list and find the next i
// TC: O(sqrt(n)* log(sqrt(n)) SC: O(logn)
/*
 * Time complexity: O(NlogN). The explains are in the following(##### actually sqrt(n) if using i * i <= n ####):
 *
 *  formula 1: time = (the number of nodes in the recursive tree) * (the time each node takes up)
 *  formula 2: the number of nodes in the recursive tree  = 
 *                (the most number of branches among each node) ^ (the height of the tree)
 *  For the number of branches, it has at most N (from 2 to n) and in terms of the height of the tree, it should be logN since when the given number n is only decomposed by 2 will lead to the solution which has the longest length (pls take 32 as example in the description page). Thus, the number of nodes = (N)^(logN). And since each node only takes up O(1) time, therefore, the total time should be O(N^(logN))
 *
 *  Space complexity: O(logN)
 *  Things will cost EXTRA space:
 *  1. the number of call stacks invoked = the height of the recursive tree = logN
 *  2. the item used to store the current solution which takes up logN at most (again, when the input n is only decomposed by 2)
 */
