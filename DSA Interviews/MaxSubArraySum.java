public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {3, -4, 5, 4, -1, 7, -8};
        int result = findMaxSum(arr);
        System.out.println("The Maximum Sum among elements in the array: " + result);
    }

    public static int findMaxSum(int[] arr) {

        int maxSum = arr[0];               // Always initialize your maximum tracking variables to the first element of the array (arr[0]) or Integer.MIN_VALUE;

        for (int start = 0; start < arr.length; start++) {
            int currentSum = 0;

            for (int end = start; end < arr.length; end++) {
                currentSum = currentSum + arr[end];              //  Add the next element to the running subarray sum

                if(currentSum > maxSum ){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}

/* First  iteration, the END loop runs through all these elements {3, -4, 5, 4, -1, 7, -8}; then in the
   Second iteration, the END loop runs through  {-4, 5, 4, -1, 7, -8}  and so on.

   [5, 4, -1, 7] gives the MAX Value, when we reach [5, 4, -1, 7, -8] the value lessens to = +7;
   So it's not counted in our MaxSum variable. That is MaxSum remains +15.

*/