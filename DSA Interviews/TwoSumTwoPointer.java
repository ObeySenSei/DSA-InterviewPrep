import java.util.Arrays;

public class TwoSumTwoPointer {
    public static void main(String[] args) {

        int[] nums1 = {11, 2, 15, 7}; // Unsorted array
        int target1 = 9;
        int[] result1 = findPairTwoPointer(nums1, target1);
        System.out.println("Values for target 9: " + Arrays.toString(result1));
    }

    public static int[] findPairTwoPointer(int[] nums, int target) {

                                  /// Step 1: Sort the array so we can use two pointers effectively
        Arrays.sort(nums);    /// Note: Sorting modifies the original array. If you need to preserve original order, copy it first.

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return new int[] {nums[left], nums[right]};
            } else if (currentSum < target) {
                left++;
            } else {       // Basically (currentSum > target)
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}


