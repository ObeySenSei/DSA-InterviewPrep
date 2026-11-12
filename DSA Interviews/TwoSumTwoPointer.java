import java.util.Arrays;

public class TwoSumTwoPointer {

    // Method to find the pair values using the two-pointer approach
    public static int[] findPairTwoPointer(int[] nums, int target) {
        // Step 1: Sort the array so we can use two pointers effectively
        // (Note: Sorting modifies the original array. If you need to preserve original order, copy it first.)
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return new int[] { nums[left], nums[right] };
            } else if (currentSum < target) {
                left++;   // We need a larger sum, move the left pointer forward
            } else {
                right--;  // We need a smaller sum, move the right pointer backward
            }
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {11, 2, 15, 7}; // Unsorted array
        int target1 = 9;
        int[] result1 = findPairTwoPointer(nums1, target1);
        System.out.println("Values for target 9: " + Arrays.toString(result1));
        // Expected Output: [2, 7]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = findPairTwoPointer(nums2, target2);
        System.out.println("Values for target 6: " + Arrays.toString(result2));
        // Expected Output: [2, 4]
    }
}