import java.util.Arrays;                       // Optimized

public class MajorityElementSorting {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 1, 1};
        int result = findMajorityElement(arr);
        System.out.println("Majority Element: " + result);
    }

    public static int findMajorityElement(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);         // Step 1: Sort the array in ascending order

        if (n == 1) {                // Edge case for single-element arrays
            return arr[0];
        }

        int count = 1;               // The number that we are currently at has already appeared once.

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {        // If our current element is equal to the element to the left.
                count++;
            } else {
                count = 1;                     // We reset count for the new number/element.
            }

            if (count > n / 2) {                //  If 5 > 4,
                return arr[i];                  //  return the number that appeared 5 times.
            }
        }
        return -1;
    }
}