package BasicQuestions;

public class ReverseWord {
    public static void main(String[] args) {
        String s = "Hello";
        reverse(s);
    }
    public static void reverse(String s){

        String ans = "";                     // creates a new String object
        for(int i=s.length() - 1; i>=0; i--){
           ans = ans + s.charAt(i);
        }
        System.out.println(ans);
    }
}


/**

 StringBuilder → mutable, more efficient for repeated appending.
 String + char → creates new String objects during concatenation.


 Repeated String concatenation can take O(n²) time because new strings are repeatedly created and copied.
 StringBuilder is generally O(n) for this operation.

 */