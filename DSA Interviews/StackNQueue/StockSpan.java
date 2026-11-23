package StackNQueue;
import java.util.*;

public class StockSpan {

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = new int[prices.length];            // Create a resultant array to display final output
        Stack<Integer> stack = new Stack<>();           // Create a stack to store indices.


        for (int i = 0; i < prices.length; i++) {       //Our streak will continue even if the elements are of same value <=

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {    /// Prev element <= my current Element say 60 < 70.
                stack.pop();                                                   /// Remove the index value of 60 from stack
            }

            if (stack.isEmpty()) {              // Calculate span for current i (streak)
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();     // Say 6-0 = 6;
            }

            stack.push(i);                 // Push the current index in every iteration of i.
        }

        System.out.println(Arrays.toString(span));
    }
}

/**

 while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
 We need the actual value atop the stack not the index to compare our current value in Prices.
 Our streak will continue even if the elements are of same value.

 stack.pop();               We pop that index value from our stack if the value of that index is less.

 if(stack.isEmpty()){       When my stack is empty or no Previous Greater Element exists,
 */