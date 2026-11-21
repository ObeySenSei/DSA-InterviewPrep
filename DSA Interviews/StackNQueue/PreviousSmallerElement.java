package StackNQueue;
import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 8, 6};
        int n = arr.length;

        int[] result = new int[n];                /// Create a new arr to store results = [0, 0, 0, 0, 0]
        Stack<Integer> stack = new Stack<>();     /// Create a stack to store elements from arr[] and perform push / pop operations.

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {   // The only change we make.  >=
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

/**

 For Previous Smaller Element (PSE), you should traverse the array from LEFT to RIGHT.
 Why? Because you're looking for the nearest smaller element that appears before the current element.

 Algorithm
 1. Create an empty Stack.
 2. Traverse the array from i = 0 to n-1.
 3. While the stack isn't empty AND stack.peek() >= arr[i], pop.
 4. If the stack is empty, answer is -1.
 5. Otherwise, stack.peek() is your Previous Smaller Element.
 6. Push arr[i] into the stack.

 */