package StackNQueue;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{[(])}";                       // or use  "{[({})]}";   to get True.
        boolean result = isValid(s);
        System.out.println(result);
    }

    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' ||  str.charAt(i) == '{' || str.charAt(i) == '[') {       /// We insert only the Opening brackets into our stack
                st.push(str.charAt(i));

            } else {
                if (st.size() == 0) {        ///  Prevents closing brackets from appearing without corresponding opening brackets.
                    return false;           ///  For a string to be valid, it needs to start with an opening Parenthesis
                }

                if     ((st.peek() == '(' && str.charAt(i) == ')') ||
                        (st.peek() == '{' && str.charAt(i) == '}') ||
                        (st.peek() == '[' && str.charAt(i) == ']')) {

                    st.pop();

                } else {             ///  If the current closing bracket does not match the opening bracket at the top of the stack,
                    return false;    ///  immediately return false.         (mismatched bracket /also known as incorrect closing order)
                }
            }
        }
        return st.isEmpty();    ///  or st.size()==0;   Both check whether the stack contains zero elements.
    }
}
