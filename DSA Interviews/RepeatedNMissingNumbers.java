import java.util.*;

public class RepeatedNMissingNumbers {

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
        int a = -1, b = -1; //                  a = repeated, b = missing  or use    int repeated  /  int missing.

        // Step 1: Find the repeated value using the Set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (set.contains(grid[i][j])) {      //  Have we already seen this exact number earlier in the grid ? grid[i][j]: is the current number our nested loops are sitting on right now at
                    a = grid[i][j];                 // Found the repeated value

                } else {                      //  Else if we have laid eyes on this number for the first time,
                    set.add(grid[i][j]);     //  adds it to the set (set.add(...)) so we can remember it for later cells.
                }
            }
        }

        // Step 2: Find the missing value by checking numbers from 1 to n^2
        int totalElements = n * n;
        for (int num = 1; num <= totalElements; num++) {      // Read the constraints in the question, i starts from 1 to n^2 that is 3x3 = 9.
            if (!set.contains(num)) {         // If the set doesn't contain this number, it's our missing value
                b = num;
                break;                        // No need to check further once that missing number is found.
            }
        }
        return new int[] { a, b };
    }
}
/**

 set.contains(): This checks our HashSet (which acts like a memory log or a guest list of every number you've walked past so far).

 set.add(grid[i][j]);
 This just stores the raw number (e.g., 9, 1, 7, etc.) inside the HashSet.


 set.contains(num) - "Does our set have this number inside it?" (Returns true if it's there, false if it's not).
 So, if (!set.contains(num))  - "If the set does NOT contain this number", store our current number(num) as our missing number i.e b = 5;
 and then return that number alongside 'a';


 if (set.contains(i))  <--- Missing the !
 b = i;
 What happens: Without the !, you are asking: "If the set contains this number, make it b."
 That would find a number that is there, not the number that is missing.


 */