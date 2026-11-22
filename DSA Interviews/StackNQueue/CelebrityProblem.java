package StackNQueue;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {

        int[][] M = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        int n = M.length;
        Stack<Integer> stack = new Stack<>();

        // Push all people into the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Eliminate people until only one candidate remains
        while (stack.size() > 1) {

            int a = stack.pop();       // Set the top element as A
            int b = stack.pop();       // Set the element below it as B

            if (M[a][b] == 1) {        //  If A knows B, A cannot be the celeb, so push B.
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();     // Set the Element that remains (index value here) on the stack as the potential candidate.

        // Verify the remaining candidate
        int rowSum = 0;
        int colSum = 0;

        for (int i = 0; i < n; i++) {
            rowSum += M[candidate][i];
            colSum += M[i][candidate];
        }

        if (rowSum == 0 && colSum == n - 1) {
            System.out.println(candidate);      // This row arr[0] is the Celebrity
        } else {
            System.out.println(-1);
        }
    }
}

/*
 Also try this :

    {0, 1, 0, 1},
    {0, 0, 1, 0},
    {1, 0, 0, 1},
    {0, 0, 0, 0}

 One more interview edge case: If n == 0, your code would throw an exception at stack.pop().
 You can handle that with an initial empty-matrix check if the problem allows an empty matrix.

 */