import java.util.Arrays;         ///  Three Pointer Method

public class SortColoursDutchFlag {
    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        int low = 0;
        int mid = 0;                        // Mid will start from the first index. arr[0]
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {           // Swap low and mid

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else {

                // Swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
