// Sort Solution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        
        Arrays.sort(freq);
        int i = 25;
        while (i >= 0 && freq[i] == freq[i - 1]) {
            i--;
        }
        
        int possibleResult = (freq[25] - 1) * (n + 1) + 26 - i;
        
        return Math.max(tasks.length, possibleResult);
    }
}

// Notes: find most frequent task
// use them as frame, add other less frequent in the gap
// so the number is (most freqent task's frequency) * (n + 1) + (number of most frequent tasks)
// TC: O(n)  SC: O(26)

// Non-sort Solution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxCount = 0;
        int maxFreq = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
            if (freq[c - 'A'] > maxFreq) {
                maxFreq = freq[c - 'A'];
                maxCount = 1;
            } else if (freq[c - 'A'] == maxFreq) {
                maxCount++;
            }
        }
        
        int possibleResult = (maxFreq - 1) * (n + 1) + maxCount;
        
        return Math.max(tasks.length, possibleResult);
    }
}

// Notes: loop through the tasks to find maxCount(number of most frequent tasks) and maxFreq
// Calculation way is the same as before
// TC: O(n)  SC: O(26)
