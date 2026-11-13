import java.util.*;

public class test {
    public static void main(String[] args) {
        int[][] grid = {
                {9, 1, 7},
                {8, 9, 2},
                {3, 4, 6},
        };
        int[] result = findValues(grid);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findValues(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        Set <Integer> set = new HashSet<>();

        int n = grid.length;
        int a = -1;
        int b = -1;

        for(int i=0; i<n; i++){
            for(int  j=0; j<n; j++){
                if(set.contains(grid[i][j])) {
                    a = grid[i][j];
                    list.add(a);
                } else {
                    set.add(grid[i][j]);  // Else we add that number to our list (If the number does not match our previous element or the set is empty.
                }
            }
        }

        int totalElements = n * n;
        for (int i=1; i<=totalElements; i++) {
            if (!set.contains(i)) {
                b = i;
                break;
            }
        }
        return new int[] {a,b};
    }
}
