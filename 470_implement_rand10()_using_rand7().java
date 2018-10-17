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

/*
 * Details: see https://www.mathcamp.org/2015/academics/michelle/AlgorithmsHomework3Solutions.pdf
 * 1. Describe an implementation of Random(a,b) that only makes calls to Random(0,1). What is the expected
 * running time of your procedure as a function of a and b?
 * Without loss of generality we may assume that a = 0. Otherwise we can generate a random number between 0
 * and b − a, then add a to it.
 * Algorithm 1 RANDOM(a,b)
 * 1: n = ⌊lg(b)⌋ + 1
 * 2: Initialize an array A of length n
 * 3: while true do
 * 4:   for i = 1 to n do
 * 5:       A[i] = RANDOM(0, 1)
 * 6:   end for
 * 7:   if A holds the binary representation of a number less than or equal to b then
 * 8:       return number represented by A
 * 9:   end if
 * 10: end while
 * 
 * Each iteration of the while loop takes O(n) time to run. The probability that the while loop stops on a given
 * iteration is (b+1)/2^n. Thus the expected running time is the expected number of iterations of the while-loop times
 * n. -> O(lg(b)) 
 * In the original setup of the problem, the runtime of the algorithm becomes O(lg(b − a)).
 */
