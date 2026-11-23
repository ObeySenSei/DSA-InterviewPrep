package StackNQueue;
import java.util.Stack;

public class LargestRectangleHistogram1 {
    public static void main(String[] args) {
        int[] sample1 = {2, 1, 5, 6, 2, 3};
        int[] sample2 = {6, 2, 5, 4, 5, 1, 6};

        System.out.println("Max Area (sample 1): " + largestRectangleArea(sample1)); // 10
        System.out.println("Max Area (sample 2): " + largestRectangleArea(sample2)); // 12
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight;
            if (i == n) {
                currHeight = 0;                      ///  int currHeight = (i == n) ? 0 : heights[i];
            } else {
                currHeight = heights[i];
            }

            while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                int height = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = nse - pse - 1;
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                stack.push(i);
            }
        }
        return (int) maxArea;
    }
}

/**
 currHeight is set to 0 at i == n for one simple reason: histogram heights are always non-negative (>= 0),
 so 0 is guaranteed to be smaller than or equal to every bar still sitting on the stack.

 At the end of the array (i == n), bars like 1, 2, and 3 (from [2, 1, 5, 6, 2, 3]) are still sitting on the stack
 because no shorter bar ever came after them.
 If you set currHeight = 0, then:
 3 >= 0 (true) pops index 5, computes area with nse = 6
 2 >= 0 (true) pops index 4, computes area with nse = 6
 1 >= 0 (true) pops index 1, computes area with nse = 6)

 If you set currHeight to a larger number like 5, bars shorter than 5 (3, 2, 1) would fail the >= check
 and stay trapped on the stack without ever having their area calculated.
 Even if a bar on the stack had height 0, 0 >= 0 is still true, so it still pops cleanly.
 */