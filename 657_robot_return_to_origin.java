class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        
        int[] directions = new int[2];
        
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                directions[0] -= 1;
            } else if (moves.charAt(i) == 'R') {
                directions[0] += 1;
            } else if (moves.charAt(i) == 'U') {
                directions[1] -= 1;
            } else {
                directions[1] += 1;
            }
        }
        
        return directions[0] == 0 && directions[1] == 0;
    }
}

// Notes: for loop, L-R U-D
// TC: O(n) n - length of moves  SC: O(1)
