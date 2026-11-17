import java.util.Arrays;

public class ProductArrayExceptionDVANGA  {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result)); // Output: [24, 12, 8, 6]
    }
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        if (n == 0) {
            return result;
        }

        // PASS 1: Left Products (Using i - 1 logic)
        // res[i] will contain the product of all elements to the left of i
        result[0] = 1; // Base case: nothing is to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];       ///  Previous left Product * Previous Element. Old value in result * new value in arr.
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct; // Multiply old value by updated product ?
            rightProduct *= nums[i];        // Store the value of product
        }

        return result;
    }
}