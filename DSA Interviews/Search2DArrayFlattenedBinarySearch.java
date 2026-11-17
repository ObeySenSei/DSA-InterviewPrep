import java.util.Arrays;

public class Search2DArrayFlattenedBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {{1,  3,  5,  7},
                      {10, 11, 16, 20},
                      {23, 30, 34, 60}};
        int target = 11;
        int [] result = flattenedBSearch(arr,target);
        System.out.println(Arrays.toString(result));

    }
    public static int[] flattenedBSearch(int[][] arr, int target) {

        int row = arr.length;                    // Gives us 3
        int col = arr[0].length ;                // Gives us 4

        int start = 0;                   // We wanna start from the first index
        int end = (row * col) - 1;       // (3 * 4) - 1 gives us 11. We set 11 as out End index

        while (start <= end){
            int mid = start + (end-start)/2;

            /// Formulas to convert 1D co-ordinates back into 2D co-ordinates. Use this inside the while loop cuz their values keep changing.
            int midR = mid / col;          //  Mid = 11 / 2 = 5. So midR is 5 / 4 = 1
            int midC = mid % col;          //  midC is 5 % 4 = 1

            if(target == arr[midR][midC]){
                return new int[] {midR, midC};

            } else if (target > arr[midR][midC]){
                start = mid + 1;
            } else {
                end = mid - 1;               /// if   target < arr[midR][midC]
            }
        }
        return new int[] {-1,-1};
    }
}
