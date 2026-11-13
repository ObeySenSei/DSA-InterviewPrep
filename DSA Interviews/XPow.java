// https://leetcode.com/problems/powx-n/
public class XPow {
    public static double myPow(double x, int n) {
        // Handle negative powers by turning n into a long
        // to prevent integer overflow when dealing with Integer.MIN_VALUE
        long binForm = n;
        if (binForm < 0) {
            x = 1 / x;
            binForm = -binForm;
        }

        double ans = 1;
        double currentProduct = x;

        while (binForm > 0) {
            // If the current exponent bit is odd, multiply it into our answer
            if (binForm % 2 == 1) {
                ans = ans * currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct = currentProduct * currentProduct;
            binForm = binForm / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10)); // Output: 1024.0
        System.out.println(myPow(2.1, 3));  // Output: 9.261
        System.out.println(myPow(2.0, -2)); // Output: 0.25
    }
}