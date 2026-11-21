import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {              /// Using Stack (NGE)
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;

        int[] result = new int[n];                /// Create a new arr to store results = [0, 0, 0, 0, 0]
        Stack<Integer> stack = new Stack<>();    /// Create a stack to store elements from arr[] and perform push / pop operations.

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {   /// Remove elements smaller than or equal to current element  ... stack > 0
                stack.pop();
            }

            if (stack.isEmpty()) {                /// Find the next greater element
                result[i] = -1;
            } else {
                result[i] = stack.peek();         /// Set the current element at the top of the Stack as the value in result [i]
            }

            // Push current element into stack
            stack.push(arr[i]);             /// We need to add every element to the Stack and perform pop when necessary !!
        }

        System.out.println(Arrays.toString(result));
    }
}
