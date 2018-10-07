// Iterative Solution
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        
        double temp = x;
        double res = 1.0;
        while (pow > 0) {
            if (pow % 2 == 1) {
                res *= temp;
            }
            temp = temp * temp;
            pow = pow / 2;
        }
        return res;
    }
}

