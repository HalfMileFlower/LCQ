class Solution {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = charA.length - 1;
        int j = charB.length - 1;
        while (i >= 0 || j >= 0) {
            carry /= 2;
            if (i >= 0) {
                carry += charA[i] - '0';
                i--;
            }
            
            if (j >= 0) {
                carry += charB[j] - '0';
                j--;
            }
            res.insert(0, (char)((carry > 1 ? carry - 2 : carry) + '0'));
        }
        if (carry > 1) {
            res.insert(0, '1');
        }
        return res.toString();
    }
}