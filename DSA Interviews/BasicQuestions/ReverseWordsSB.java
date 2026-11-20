package BasicQuestions;

public class ReverseWordsSB {
    public static void main(String[] args) {
        String s = "JAVA IS  FUN";
        reverseWords(s);
    }

    public static void reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        // Step 1: Reverse the entire string
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        // Step 2: Reverse individual words
        int start = 0;                        // Start value is incremented after every encounter of a " ".

        for (int i = 0; i <= sb.length(); i++) {

            if (i == sb.length() || sb.charAt(i) == ' ') {

                int left = start;
                int right = i - 1;

                while (left < right) {

                    char temp = sb.charAt(left);
                    sb.setCharAt(left, sb.charAt(right));
                    sb.setCharAt(right, temp);

                    left++;
                    right--;
                }
                start = i + 1;
            }
        }
        System.out.println(sb);
    }
}

/**


 You need another for loop with an if condition inside it. Why?
 for loop: Traverses the entire StringBuilder.
 if: Checks whether the current character is a space.
 When you encounter a space, you've reached a word boundary.

 */

