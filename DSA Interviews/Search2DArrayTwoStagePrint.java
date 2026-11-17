
public class Search2DArrayTwoStagePrint {
    public static void main(String[] args) {

        int[][] arr = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int[] result = searchMatrixFullySorted(arr, 34);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] searchMatrixFullySorted(int[][] arr, int target) {

        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return new int[]{-1, -1};

        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = row - 1;
        int lastC = col - 1;

        // Binary Search on Rows

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= arr[mid][0] && target <= arr[mid][lastC]) {
                // Binary Search within the identified row
                return PrintRow(arr, mid, target);

            } else if (target > arr[mid][lastC]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    // Binary Search within a specific row
    public static int[] PrintRow(int[][] arr, int row, int target) {

        int start = 0;
        int end = arr[row].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[row][mid]) {
                return new int[]{row, mid};
            }
            else if (target > arr[row][mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
