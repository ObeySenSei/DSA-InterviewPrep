package BasicQuestions;

public class ReverseWordSB {
    public static void main(String[] args) {
        String s = "Hello";
        reverse(s);
    }
    public static void reverse(String s){

        StringBuilder sb = new StringBuilder();
        for(int i= s.length()-1; i >= 0; i--){                 //   s.length()-1  -> gives us last index 3.
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}

/**

 sb.append(s.charAt(i));

 StringBuilder is generally O(n) for this operation.

 */
