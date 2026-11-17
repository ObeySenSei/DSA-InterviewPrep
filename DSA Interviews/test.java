import java.util.Arrays;

public class test{
    public static void main(String[] args) {
        int[]arr = {1, 3, 5, 4, 2};
        int[] result = findNextPermutation(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findNextPermutation(int[]arr){

        int n = arr.length;
        int pivot = -1;

        /// STEP 1: Find the pivot (back to front / right to left) .  n-2 to handle the out of bound exception for arr[i + 1]

        for(int i= n - 2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }
        /// STEP 2: Find the successor and swap

        if (pivot != -1){                    // if only we have found a pivot, this loop will execute
            int j = n-1;                     // j starts at the last index

            while (arr[j] <= arr[pivot]) {   // We use a while loop to scan backwards until we find an element greater than pivot. Because the suffix is sorted in descending order, the very first time arr[j] <= arr[pivot] becomes false, j is sitting on the smallest possible element that is still larger than the pivot.
                j--;
            }
            int temp = arr[pivot];
            arr[pivot] = arr[j];
            arr[j] = temp;
        }
        /// Then reverse order starting from the original index of Pivot

        int left = pivot + 1;
        int right = n - 1;

        while (left < right){          // Dryrun why (left < right) and not (left <= right). when our pointer is at left = right, the element will already be in its current position.
            int temp = arr[left];
            arr[left] = arr[right];    // swaps with the value at the last index for the first run
            arr[right] = temp;

            left++;
            right--;
        }
        return arr;
    }
}
/**

 [1, 3, 5, 4, 2]
 [1, 4, 5, 3, 2]       The program runs in this order.
 [1, 4, 2, 5, 3]

 while (j > pivot) { // or some loop condition
 if (arr[j] <= arr[pivot]) {
 j--;
 } else {
 int temp = arr[pivot];
 arr[pivot] = arr[j];
 arr[j] = temp;
 break; // You MUST break here, otherwise the loop keeps running after the swap!
 }


 */
