class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                    continue;
                }
                result.add("Fizz");
                continue;
            } else if (i % 5 == 0){
                result.add("Buzz");
                continue;
            } else {
                result.add("" + i);
            }
        }
        return result;
    }
}

// Notes: pay attention to the numbers that are multiples of 3 as well as 5
// TC: O(n)  SC: O(n)
