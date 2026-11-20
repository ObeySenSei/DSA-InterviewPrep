package String;

public class StringCompression {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'b', 'c', 'c', 'c'};    // Characters are denoted by single inverted comma.  [a,b,2,c,3]
        int result = stringCompression(s);
        System.out.println(result);
    }

    private static int stringCompression(char[] s) {

        int i = 0;
        int compressedIndex = 0;

        while (i < s.length) {
            char currentChar = s[i];
            int currentCount = 0;

            while (i < s.length && s[i] == currentChar) {     // Count consecutive occurrences
                currentCount++;
                i++;
            }

            /// Write the character
            s[compressedIndex] = currentChar;
            compressedIndex++;

            if (currentCount > 1) {           // Write frequency if greater than 1
                for (char digit : String.valueOf(currentCount).toCharArray()) {
                    s[compressedIndex] = digit;
                    compressedIndex++;
                }
            }
        }

        return compressedIndex;
    }
}
/**

 currentCount is declared outside the loop because it resets on every iteration.

 Remember, currentCount is an int, whereas s is a char[].
 We cannot directly assign the integer 12 to a character array element as '1' and '2'.

 So: String.valueOf(currentCount) say 12 , converts the integer into the String "12".
 .toCharArray() -  Converts "12" into {'1', '2'}

 */





