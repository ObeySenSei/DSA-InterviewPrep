package StackNQueue;
import java.util.*;

public class StockSpan {

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            // Remove smaller or equal elements
            while (!stack.isEmpty() &&
                    prices[stack.peek()] <= prices[i]) {

                stack.pop();
            }

            // Calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Push current index
            stack.push(i);
        }

        System.out.println(Arrays.toString(span));
    }
}