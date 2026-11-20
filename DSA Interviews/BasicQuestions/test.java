package BasicQuestions;

public class test {
    public static void main(String[] args) {
        String s = "JAVA IS  FUN";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        StringBuilder ans = new StringBuilder();  // to store our ans
        int start = 0;

        while(start < sb.length()) {
            while (start < sb.length() && sb.charAt(start) == ' ') {
                start++;   // skip if we encounter a space or continuous spaces.
            }
            StringBuilder word = new StringBuilder();
            while (start < sb.length() && sb.charAt(start) != ' ') {
                word.append(sb.charAt(start));
                start++;
            }

            if (word.length() > 0) {   // we want to avoid reversing if word is empty
                word.reverse();
            if (ans.length() > 0) {
                ans.append(" ");     // Add a space after the end of each word.
                }
            ans.append(word);
            }
        }
        return ans.toString();
    }
}
