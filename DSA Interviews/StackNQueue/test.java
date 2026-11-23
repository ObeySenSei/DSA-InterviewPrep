package StackNQueue;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] streak = new int[prices.length];

        Stack<Integer>stack = new Stack<>();

        for(int i=0; i< prices.length; i++) {

                stack.pop();          // We pop that index value from our stack if the value of that index is less.
            }
            if(stack.isEmpty()){        // When my stack is empty or no Previous Greater Element exists,
                streak[i] = i + 1;
            } else {
                streak[i] = i - stack.peek();     // Say 6-0 = 6;
            }
            stack.push(i);                   /// Gotta push that element onto the stack regardless.
        }
        System.out.println(Arrays.toString(streak));


    }
}
