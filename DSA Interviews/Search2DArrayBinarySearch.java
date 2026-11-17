//  The two-stage binary search  (O(log m + log n)).
public class Search2DArrayBinarySearch {
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
        int row = arr.length;
        int col = arr[0].length;

        int startR = 0;
        int endR = row - 1;
        int lastCol = col - 1;

        while (startR <= endR) {

            int midRow = startR + (endR - startR) / 2;
            if (target >= arr[midRow][0] && target <= arr[midRow][lastCol]) {

                // Target lies within this row: Binary Search on Columns    (Middle Row)

                int startC = 0;
                int endC = lastCol;

                while (startC <= endC) {

                    int midCol = startC + (endC - startC) / 2;

                    if (arr[midRow][midCol] == target)          // The element in the middle row and middle column.
                        return true;

                    else if (arr[midRow][midCol] < target)
                        startC = midCol + 1;

                    else
                        endC = midCol - 1;
                }

                return false;

            } else if (target > arr[midRow][lastCol]) {
                startR = midRow + 1;
            } else {
                endR = midRow - 1;
            }
        }
        return false;
    }
}
