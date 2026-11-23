package StackNQueue;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        /// Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {        // Stack operation is performed first    Basically we are comparing the previous element with our current element by the use of index reference inside our stack. pse[stack.peek()] >= pse[i]/
                  ///  is 2 > = 1 ?  So remove from stack.
                stack.pop();
            }

            if (stack.isEmpty()) {             // Only then the PSE array is filled.
                pse[i] = -1;                  /// If no valid boundary is found, assign -1
            } else {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }
        stack.clear();

        /// Next Smaller Element        (Monotonic Increasing Stack, Right to Left)   since NSE - PSE
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {     // Is 3 >= 2. Yes, So Pop.
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n;               /// If no valid boundary is found, assign n (length of array)
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }

        /// Calculate maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);    // or use   maxArea = Math.max(maxArea, area);  if (area > maxArea) ->  maxArea = area;
        }
        System.out.println(maxArea);
    }
}

/*

Separate-Pass Approach (Like the Previous Dry Run)
When you write two separate loops (findPSE and findNSE) before computing areas:

The first loop runs from i = 0 to n - 1 and fills the entire PSE array for every element first.
The second loop runs from i = n - 1 down to 0 and fills the entire NSE array for every element next.
A third loop then combines PSE[i] and NSE[i] for each index i to find MaxArea.


Ternary Operation for both the if Loops:

pse[i] = stack.isEmpty() ? -1 : stack.peek();
nse[i] = stack.isEmpty() ? n : stack.peek();

 */