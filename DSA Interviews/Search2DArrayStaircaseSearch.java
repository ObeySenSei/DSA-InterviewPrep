import java.util.Arrays;

public class Search2DArrayStaircaseSearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 8;
        int [] result = staircaseSearch(arr,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] staircaseSearch(int[][] arr, int target) {
        if(arr==null || arr.length == 0 || arr[0].length == 0) return new int[] {-1,-1};

        int row = 0;
        int col = arr[0].length - 1;               // Fixes out start element as the last element of the first Row !!

        while(col >=0 && row < arr.length){

            if(arr[row][col] == target){
                return new int[] {row, col};        // or say return true; if the Q asks to check only if its present.
            }
            else if (target > arr[row][col]){
                row++;
            } else {                                // Basically if target < arr[row][col]    (less than our current element)
                col--;
            }
        }
        return new int[] {-1,-1};
    }
}

