import java.util.Arrays;

public class test{
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] result = newArr(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] newArr (int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid<=high){
            if (nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];       // 2 becomes 0;
                nums[mid] = temp;            // 0 becomes 2;
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];   // temp stores 0
                nums[mid] = nums[high];   // arr[0] becomes 0
                nums[high] = temp;

                high --;
            }
        }

        return nums;
    }
}