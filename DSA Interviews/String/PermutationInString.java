package String;
import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';            ///  a - a -> 97-97 = 0      b - a -> 98 - 97 = 1       z - a -> 122 - 97 = 25
            s1Count[index] = s1Count[index] + 1;       ///  assigns a value 1  at that index  s1Count[0] = s1Count[0] + 1   =  0 + 1 = 1.
        }

        // Build the first window in s2
        for (int i = 0; i < s1.length(); i++) {        /// s2 window size should be the same as the permutation s1,  i < s1.length()
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(s1Count, s2Count)) {        // If the first window matches s1, immediately return true.
            return true;
        }

        /// Actual Comparison: Slide the window              If it doesn't match, execution continues to the sliding-window for loop.
        for (int i = s1.length(); i < s2.length(); i++) {     ///  Why start at 2? Because we have ALREADY counted the first window "ei". Now we start looking at the next character, which is 'd'.

            // Add the new character
            s2Count[s2.charAt(i) - 'a']++;                 // s2.charAt(2) gives 'd' - 'a' = 3. ++ increments the frequency of s2Count[3] to 1.

            // Remove the character leaving the window         Our window is now temporarily "eid".
            s2Count[s2.charAt(i - s1.length()) - 'a']--;       // At i=2, 2-2 gives us 0.  So, s2Count[s2.charAt(0) - 'a'] ->  s2Count['e' - 'a']  -> s2Count[4]  Accesses index 4 of the frequency array.

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

}

/*

The most important thing to understand: We don't create a new window or recount all its characters.
We simply add the incoming character and remove the outgoing character from the frequency array.

 */