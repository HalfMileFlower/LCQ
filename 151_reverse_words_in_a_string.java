// StringBuilder Solution
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

// Reverse Char Array Solution
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        reverse(chars, 0, chars.length - 1);
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[end] = chars[i];
                end++;
            } else if (i > 0 && chars[i - 1] != ' '){
                reverse(chars, start, end - 1);
                chars[end] = ' ';
                end++;
                start = end;
            }
        }
        
        reverse(chars, start, end - 1);
        end = end > 0 && chars[end - 1] == ' ' ? end - 1 : end;
        return new String(chars, 0, end);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}

// Notes: reverse the whole array first, make two pointers start = end = 0
// if char[i] is not ' ', assign it to end, move end++, end is actually the end of the result string
// if char[i] is ' ', when i > 0, char[i - 1] is not ' ', we find a word, so reverse (start, end - 1)
// At the same time, we need to add a ' ' after the word, and end++, move start to the position same as end
// finally, pay attention that char[end - 1] can be ' ', move the end one former if so.
// new String (chars, 0, end / end - 1)
// TC: O(n)  SC: O(n)
