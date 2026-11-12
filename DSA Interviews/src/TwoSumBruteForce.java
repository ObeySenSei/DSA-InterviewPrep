import java.util.Arrays;

public class TwoSumBruteForce {
    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Indices for target 9: " + Arrays.toString(result1));


        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices for target 6: " + Arrays.toString(result2));

    }

    // Method to find the indices using brute force
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {              // Outer loop picks the first number

            for (int j = i + 1; j < nums.length; j++) {      // Inner loop picks the second number
                if (nums[i] + nums[j] == target) {           // Check if the pair adds up to the target
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}