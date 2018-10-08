class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (mapMock(s.charAt(i)) >= mapMock(s.charAt(i + 1))) {
                res += mapMock(s.charAt(i));
            } else {
                res -= mapMock(s.charAt(i));
            }
        }
        res += mapMock(s.charAt(s.length() - 1));
        return res;
    }
    
    private int mapMock(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }
}

// Notes: can use a function to mock hashmap
// Remember to add the last character
// TC: O(n) SC: O(1)
