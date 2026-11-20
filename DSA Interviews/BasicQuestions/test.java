package BasicQuestions;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2){

        if(s1.length() > s2.length()) return false;  /// Length of a permutation cannot be greater than its String

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i=0; i<s1.length(); i++){      // Now we need to create an array and assign values of 1 to every element.
            int index = s1.charAt(i) - 'a';    // s1.charAt(i) holds 'a' initial from String s1.   a-a -> 97-97=0.
            s1Count[index] = s1Count[index] + 1;    // We get 0 ans from above, now s1Count[0] = 0 + 1, has the value 1 in its index 0;
        }
        /// Now we need to create an array and assign the value of 1 to every element which was present in String s2 = "eidbaooo";
        for(int i=0; i<s1.length(); i++){
            int index = s2.charAt(i) - 'a';        // s2.charAt(i) holds 'e' initially.   e-a -> 101-97=4.
            s1Count[index] = s1Count[index] + 1;   // We get ans 4 from above, now s1Count[4] = 0 + 1, has the value 1 in its 4th index;
        }

        if(Arrays.equals(s1Count,s2Count)){
            return true;
        }

        for(int i=s1.length(); i<s2.length(); i++) {  //    i<s2.length()

            s2Count[s2.charAt(i) - 'a']++;      // This adds the next element. Say s2.charAt(2) - 'a' ->  'd' - 'a'   ->  100-97 = 3.
                                                // 3 gives us that 'd' we needed from a-z.  ++ adds 1 to the value at index 3.
            /// Now remove the prev character e
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }
}
