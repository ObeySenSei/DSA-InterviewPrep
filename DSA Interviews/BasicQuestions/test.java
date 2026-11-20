package BasicQuestions;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'b', 'c', 'c', 'c'};    // Characters are denoted by single inverted comma.  [a,b,2,c,3]
        int result = stringCompression(ch);
        System.out.println(result);
        System.out.println(Arrays.toString(Arrays.copyOf(ch,result)));
    }
    public static int stringCompression(char [] ch){

        int i = 0;
        int cI = 0;

        while (i<ch.length) {
            int currentCount = 0;
            char currentChar = ch[i]; // let us set the first character as 'a'

            while (i < ch.length && ch[i] == currentChar) {
                currentCount++;
                i++;
            }
            // The moment this loops finishes executing, it places the values along with their count, if its greater than 1.
            ch[cI] = currentChar;
            cI++;

            if (currentCount > 1) {
                for (char digit : String.valueOf(currentCount).toCharArray()) {
                    ch[cI] = digit;
                    cI++;
                }
            }
        }
        return cI;
    }
}
