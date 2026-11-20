package String;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'b', 'c', 'c', 'c'};    // Characters are denoted by single inverted comma.  [a,b,2,c,3]
        int result = stringCompression(s);
        System.out.println(result);
        System.out.println(Arrays.toString(Arrays.copyOf(s, result)));
    }

    private static int stringCompression(char[] s) {

        int i = 0;
        int compressedIndex = 0;

        while (i < s.length) {
            char currentChar = s[i];       // {a,b,b,c,c,c}
            int currentCount = 0;

            while (i < s.length && s[i] == currentChar) {     // Count consecutive occurrences...THE VALUE OF i CONTINUES as 'a' until the condition becomes false.
                currentCount++;            // Next iteration within this very loop  s[1] == currentChar → 'b' == 'a' → FALSE. Inner loop terminates.
                i++;                       // Now the outer loop starts again: char currentChar = s[i]; Since i = 1:, then b is compared with b.
            }

            /// Write the character and its occurrence after the above while loop becomes false i.e it ends.
            s[compressedIndex] = currentChar;
            compressedIndex++;               /// We increment the position from s[0] to s[1] which is where we will put our next Character.

            if (currentCount > 1) {                                                   // And if my currentCount is greater than 1,
                for (char digit : String.valueOf(currentCount).toCharArray()) {     // After converting  1  to '1'
                    s[compressedIndex] = digit;                                       // Then i need to add the value of Count to my modified Character array ch[].
                    compressedIndex++;                                                // Then we increment the cI position for the next element to be stored.
                }
            }
        }
        return compressedIndex;
    }
}
/**
 Here, currentChar stores the character at the beginning of the current group.
 If i = 0, currentChar = 'a'.
 We keep comparing every character against 'a' until we encounter 'b'.



 currentCount is declared outside the loop because it resets on every iteration.

 Remember, currentCount is an int, whereas s is a char[].
 String.valueOf(currentCount) turns the int count into a String (e.g., 12 -> "12").

 .toCharArray() splits that string into a temporary char[] of individual digit characters (e.g., {'1', '2'}).
 for (char digit : ...) is Java's enhanced for-each loop: on each pass, digit holds the next char from that digit array.


 Arrays.copyOf(ch, result)
 Creates a new array containing only the first result elements of ch. char[] ch = {'a', 'b', 'b', 'c', 'c', 'c'};
 Because result = 5.
 Converts the array into a readable String representation. new char[]{'a', 'b', '2', 'c', '3'})


 Original array after in-place compression
 ['a', 'b', '2', 'c', '3', 'c']
            |
 Arrays.copyOf(ch, result)
 ['a', 'b', '2', 'c', '3']
           |
 Arrays.toString(...)
 "[a, b, 2, c, 3]"
          |
 System.out.println(...)


 One important distinction: Arrays.copyOf() creates a new array for printing.
 It does NOT mean your compression algorithm is creating a new array. Your actual compression still modifies ch in-place.
 The result tells us how many elements of the original array are valid after compression.


 */





