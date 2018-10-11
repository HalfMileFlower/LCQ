class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pointer1 = -1;
        int pointer2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int index = 0; index < words.length; index++) {
            if (words[index].equals(word1)) {
                pointer1 = index;
            }
            if (words[index].equals(word2)) {
                pointer2 = index;
            }
            if (pointer1 != -1 && pointer2 != -1) {
                min = Math.min(min, Math.abs(pointer1 - pointer2));
            }
        }
        return min;
    }
}

// Notes: initialize two pointers with -1, move when finding word1 / word2, distance compare with the min
// TC: O(n) SC: O(1)
