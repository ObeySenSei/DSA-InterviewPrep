// https://leetcode.com/problems/powx-n/
public class XPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10)); // Output: 1024.0
        System.out.println(myPow(2.1, 3));  // Output: 9.261
        System.out.println(myPow(2.0, -2)); // Output: 0.25
    }

    public static double myPow(double x, int n) {

        if (n == 0) return 1.0;                        //  Any number raised to Power 0 is always 1;
        if (x == 0) return 0.0;                        //  0 raised to any positive Power is always 0;
        if (x == 1) return 1.0;                        //  1 raised to any Power is always 1;
        if (x == -1 && n % 2 == 0) return 1.0;         // -1 raised to an even power is always Even.
        if (x == -1 && n % 2 != 0) return -1.0;        // -1 raised to an even odd power is always Odd.

        long binForm = n;               // Value initialization. Better to set it to a 64 bit integer than 0 or a 32 bit;

        if (binForm < 0) {               // Converts a Negative Power into Positive
            x = 1 / x;
            binForm = -binForm;
        }

        double ans = 1;                             /// For the first iteration, ans gets updated to 2.
        double currentProduct = x;                  /// Not mandatory, we can just use x.

        while (binForm > 0) {
            // If the current exponent bit is odd, multiply it into our answer
            if (binForm % 2 == 1) {
                ans = ans * currentProduct;         ///  ans = 1 * 2;   If it's even, we skip this part
            }
            // Square the base and halve the exponent
            currentProduct = currentProduct * currentProduct;           ///  2 * 2 = 4
            binForm = binForm / 2;                                      /// 5 / 2 = 2.
        }

        return ans;
    }
}

/**

 By copying $n$ into a long variable (long binForm = n;), you upgrade the container from a small box (32-bit)
 to a massive warehouse (64-bit).A long can easily hold numbers way past 2 billion.
 So, when you flip -2,147,483,648 into a positive number, the long container has plenty of room to store
 +2,147,483,648  safely without any overflow crashes.


 double ans = 1;
 This is our final answer holder. We start it at 1 because 1 is the neutral starting point for multiplication (just like 0 is for addition).
 As the loop runs, we will multiply values into ans.


 double currentProduct = x;
 This keeps track of our growing base powers (x, x^2, x^4, x^8 etc.)
 It starts at x (which is x^1) and gets squared on every single turn.


 if (binForm % 2 == 1) {
 ans = ans * currentProduct;
 }
 What it means: This checks if the current exponent is odd (or if its binary representation has a 1 in the current position).


 base = base * base; automatically scales up your multiplier from 2 to 4 - 16 - 256 behind the scenes.
 Whenever power has an odd bit, it "collects" that scaled base into ans.
 */