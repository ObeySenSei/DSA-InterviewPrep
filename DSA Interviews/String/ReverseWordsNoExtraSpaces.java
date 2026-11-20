package String;

public class ReverseWordsNoExtraSpaces {
    public static void main(String[] args) {
        String s = "JAVA IS  FUN";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        /// We can use sb.reverse(); but  reverse sb with the contents of s first.    StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {       //  Entire reversed string: NUF SI AVAJ
            sb.append(s.charAt(i));
        }


        /// Create another SB to extract individual words and remove spaces  Contains the Final answer	FUN IS JAVA
        StringBuilder ans = new StringBuilder();
        int start = 0;

        while (start < sb.length()) {

            while (start < sb.length() && sb.charAt(start) == ' ') {    /// Executes only when it detects consecutive spaces and well as when start is at an index which contains ''.
                start++;                                                // skip if we encounter a space or continuous spaces.
            }

            StringBuilder word = new StringBuilder();               // Current extracted word : NUF → SI → AVAJ

            // Extract characters until the next space
            while (start < sb.length() && sb.charAt(start) != ' ') {      // Extract characters until it encounters a space.
                word.append(sb.charAt(start));                             // we append that character into SB word
                start++;
            }

            // Step 3: Reverse individual word
            if (word.length() > 0) {         // We cannot reverse a word if the SB Word is Empty.  or use (!word.isEmpty()).
                word.reverse();

                if (ans.length() > 0) {      // We cannot afford to put a ' ' at the start. Only add space after the end of each word.
                    ans.append(" ");
                }
                ans.append(word);            // add that reversed word JAVA into our SB ans.
            }
        }
        return ans.toString();
    }
}