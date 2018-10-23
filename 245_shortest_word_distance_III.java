class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int min = Integer.MAX_VALUE;
        
        while (pointer1 != words.length && pointer2 != words.length) {
            if (!words[pointer1].equals(word1)) {
                pointer1++;
                continue;
            }
            if (!words[pointer2].equals(word2)) {
                pointer2++;
                continue;
            }
            
            if (pointer1 == pointer2) {
                pointer2++;
                continue;
            } else {
                min = Math.min(min, Math.abs(pointer1 - pointer2));
                if (min == 1) {
                    return min;
                }
                if (pointer1 < pointer2) {
                    pointer1++;
                } else {
                    pointer2++;
                }  
            }
        }
        
        return min;
    }
}

// Notes: two pointers
// if !word1, !word2, p1++, p2++, continue
// else we find word1 and word2, now:
// if p1 == p2, this means word1.equals(word2), p2++, continue
// if not, we compare the difference between p1 and p2 with min
// then if p1 < p2, p1++, p2++ vice versa
// if min == 1, this is the least possible answer, return 1
// TC: O(n) SC: O(1)
