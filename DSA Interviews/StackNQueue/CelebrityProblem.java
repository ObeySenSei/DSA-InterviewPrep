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

            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        // Verify the remaining candidate
        int rowSum = 0;
        int colSum = 0;

        for (int i = 0; i < n; i++) {
            rowSum += M[candidate][i];
            colSum += M[i][candidate];
        }

        if (rowSum == 0 && colSum == n - 1) {
            System.out.println(candidate);
        } else {
            System.out.println(-1);
        }
    }
}