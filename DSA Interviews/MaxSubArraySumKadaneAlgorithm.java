public class MaxSubArraySumKadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + result);  // Output: 6
    }

    public static int maxSubArray(int[] arr) {
        if(arr == null || arr.length == 0){                     // Edge Case 7: Empty array
            System.out.println("Invalid input !");
            return 0;
        }

        int maxSum = arr[0];
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];       // 0 + -2 = -2

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {                   // If our currentSum is less than 0 i.e. -1 we reset its value to 0.
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
/*
  currentSum < 0 condition is set at the end to handle an array of negative integers like [-1, -2, -3].
  Do a dry-run, you will understand.

  For the array {-2, 1, -3, 4, -1, 2, 1, -5, 4}:
  Maximum Sum: 6
  Subarray Elements: [4, -1, 2, 1]


Time Complexity: O(n)
  The algorithm traverses the array exactly once using a single for loop.
  Each iteration performs constant-time operations: addition, comparison and assignment.
  For an array of n elements, the algorithm performs O(n) operations.

Space Complexity: O(1)
  Uses only two additional variables:
  - maxSum
  - currentSum
  No additional arrays, collections or data structures are created.


 */




