class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                result++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        
        
        return result;
    }
    
}

// Notes: notPrime[i] => set true for all i * j
// TC: O(n) SC: O(n)
// To get all primes, we can loop through the notPrime or add the prime directly to a list
