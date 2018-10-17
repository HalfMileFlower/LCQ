/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int first1 = rand7();
            int second1 = rand7();
            int product1 = first1 + (second1 - 1) * 7 ;
            if (product1 <= 40) {
                return 1 + product1 % 10;
            } else {
                int first2 = product1 - 40;
                int second2 = rand7();
                int product2 = first2 + (second2 - 1) * 7;
                if (product2 <= 60) {
                    return 1 + product2 % 10;
                } else {
                    int first3 = product2 - 60;
                    int second3 = rand7();
                    int product3 = first3 + (second3 - 1) * 7;
                    if (product3 <= 20) {
                        return 1 + product3 % 10;
                    }
                }
            }
        }
    }
}

// Notes: see this link: https://articles.leetcode.com/rejection-sampling/
// the above method can reduce expect value of rand7() call from 2.45 to 2.2123
