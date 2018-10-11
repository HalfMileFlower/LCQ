public class TwoSum {
    
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
        
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int c : map.keySet()) {
            if (map.containsKey(value - c)) {
                if ((value - c == c && map.get(c) >= 2) || value - c != c) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Notes: handling for elements added more than once: record frequency
// In "find", Don't return false until the loop goes over!
// TC: add: O(1), find: O(n)
