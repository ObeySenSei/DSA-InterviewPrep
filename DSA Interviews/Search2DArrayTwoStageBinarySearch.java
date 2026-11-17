//  The two-stage binary search  (O(log m + log n)).
public class Search2DArrayTwoStageBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {{1,  3,  5,   7},
                      { 10, 11, 16, 20},
                      { 23, 30, 34, 60}};
        int target = 34;
        boolean result = searchMatrixFullySorted(arr,target);
        System.out.println(result);
    }
    public static boolean searchMatrixFullySorted(int[][]arr, int target){
        if(arr==null || arr.length==0 || arr[0].length == 0 ) return false;

        // Binary Search on Rows
        int row = arr.length;            // length of the Row = 3
        int col = arr[0].length;         // length of the column = 4

        int startR = 0;
        int endR = row - 1;
        int lastCol = col - 1;

        while (startR <= endR) {

            int midRow = startR + (endR - startR) / 2;
            if (target >= arr[midRow][0] && target <= arr[midRow][lastCol]) {

                // Target lies within this row: Binary Search on Columns    (Middle Row)
                return binarySearchRow(arr,midRow,target);

            } else if (target > arr[midRow][lastCol]) {                // Target lies in the Row Below
                startR = midRow + 1;
            } else {                                                   // Target lies in the Row Above
                endR = midRow - 1;
            }
        }
        return false;
    }
    public static boolean binarySearchRow(int[][] arr, int row, int target) {

        int start = 0;
        int end = arr[row].length - 1;                      //  Use arr[row].length - 1 inside binarySearchRow() because it directly refers to the row we 're searching instead of arr[0].length - 1.

        while (start <= end) {
            int mid = start + (end - start) / 2;        //  mid must be recalculated inside the loop. Whenever start or end changes, mid must be recalculated.

            if (arr[row][mid] == target) {
                return true;
            }
            else if (arr[row][mid] < target)
                start = mid + 1;

            else
                end = mid - 1;
        }
        return false;
    }
}
/**

 Why?
 - row represents the total number of rows (3).
 - midRow represents the index of the candidate row (0, 1, or 2).

 arr[row].length - 1 is more general because it also works with jagged arrays (rows of different lengths),
 whereas arr[0].length - 1 assumes equal column counts.

 */