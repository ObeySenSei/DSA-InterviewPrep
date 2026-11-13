import java.util.*;

public class RepeatedNMissingNumbers2 {
    public static void main(String[] args) {

        int[][] grid = {
                {9, 1, 7},
                {8, 9, 2},
                {3, 4, 6},
        };

        int[] result = findMissingAndRepeatedValues(grid);
        System.out.println("Repeated and Missing Values: " + Arrays.toString(result));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {

        Set<Integer> set = new HashSet<>();

        int n = grid.length;
        int a = -1, b = -1;                 // a = repeated, b = missing

        int actualSum = 0;

        // Step 1: Find the repeated number and calculate actual sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                actualSum = actualSum + grid[i][j];     // 0 + 9 = 9;  then again 9 + 1 = 10;  so on.

                if (set.contains(grid[i][j])) {
                    a = grid[i][j];       // Repeated number
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        // Step 2: Calculate expected sum (1 to n²)

        int totalElements = n * n;
        int expSum = totalElements * (totalElements + 1) / 2;        //  Sum = n(n+1) / 2

        // Step 3: Calculate missing number
        b = expSum + a - actualSum;

        return new int[]{a, b};
    }
}
