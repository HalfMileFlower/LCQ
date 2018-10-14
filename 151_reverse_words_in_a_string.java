// Not in-place
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            if (words[i].length() != 0) {
                result.append(words[i]);
                result.append(" ");
            }
        }
        return result.append(words[0]).toString();
    }

}

// Notes: trim, split, concat with StringBuilder if a word is not ""
// TC: O(n) SC: O(n)

