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

        int[] s1Count = new int[26];                /// s1Count is an integer array, not a character array.
        int[] s2Count = new int[26];

        for(int i=0; i<s1.length(); i++){           ///    We need to create an array and assign values of 1 to every element.
            int index = s1.charAt(i) - 'a';         ///    s1.charAt(i) holds 'a' initial from String s1.   a-a -> 97-97=0.
            s1Count[index] = s1Count[index] + 1;    ///    We get 0 ans from above, now s1Count[0] = 0 + 1, has the value 1 in its index 0;
        }
        /// Now we need to create an array and assign the value of 1 to every element which was present in String s2 = "eidbaooo";
        for(int i=0; i<s1.length(); i++){
            int index = s2.charAt(i) - 'a';        // s2.charAt(i) holds 'e' initially.   e-a -> 101-97=4.
            s2Count[index] = s2Count[index] + 1;   // We get ans 4 from above, now s1Count[4] = 0 + 1, has the value 1 in its 4th index;
        }

        // Check the first window
        if (Arrays.equals(s1Count, s2Count)) {        // If the first window matches s1, immediately return true.
            return true;
        }

        /**    Actual Comparison: Slide the window.
               Here we first add elements and the remove the old element.   */


        for (int i = s1.length(); i < s2.length(); i++) {    ///  We Start at i=2 Because we have ALREADY counted the first window "ei". Now we start looking at the next character, which is 'd'.

                                                             /// Here we add the new character and assign the value 1 using ++.
            s2Count[s2.charAt(i) - 'a']++;                   /// s2.charAt(2) gives 'd' - 'a' = 3. ++ increments the frequency of s2Count[3] to 1.

                                                             /// Then we remove the character leaving the window.  Our window is now temporarily "eid", but after removing 'e', it becomes "id".
            s2Count[s2.charAt(i - s1.length()) - 'a']--;     /// At i=2, 2-2 gives us 0.  So, s2Count[s2.charAt(0) - 'a'] ->  s2Count['e' - 'a']  -> s2Count[4]
                                                             /// Accesses index 4 of the frequency array and removes the assigned value of 1 to 0 at that index.

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


The entire algorithm follows this sequence:
1. Count the characters in s1.
2. Count the first window of s2.
3. Compare both frequency arrays.
4. Add the incoming character.
5. Remove the outgoing character.
6. Compare again.
7. Return true if a match exists; otherwise return false after all windows are checked.


Remove the outgoing character.
Why i - s1.length()?
Because i points to the incoming character, and s1.length() tells us the window size.
At i = 2: [2-2=0]. Index 0 contains 'e', which is the character leaving our window.



 I'm using a fixed-size sliding window equal to the length of s1.
 At every iteration, I add the incoming character to the frequency array and remove the outgoing character.
 This keeps the frequency array updated for the current window without recounting all its characters.
 I then compare it with the frequency array of s1. If they match, a permutation exists.


s2Count is an integer array, not a character array.
We have successfully identified the outgoing character: 'e'.
But we cannot use 'e' directly as an array index. We need to convert it into its corresponding frequency-array index.
That's why we subtract 'a': 'e' - 'a' = 101 - 97 = 4
Now we can access: s2Count[4]--; This decrements the frequency of 'e'.

The frequency of 'e' changes from 1 to 0.
We're not deleting the character from the original s2 string.
We're simply updating its frequency in the integer array to reflect that it has left the current window.

Think of it as two separate steps:
1. s2.charAt(i - s1.length()) → identifies the outgoing character ('e').
2. - 'a' → converts that character into its array index (4).
We need - 'a' because our frequency array uses indices 0–25 to represent a–z.


 */