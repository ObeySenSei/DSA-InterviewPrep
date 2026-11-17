import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};    // Output should be  [24, 12, 8, 6]
        int[] result = productArrayExceptSelf(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] productArrayExceptSelf (int[] arr){
        int n = arr.length;
        int[] result = new int[n];     // Create a new array

        for (int i=0; i<n; i++){
            int product = 1;           // This resets for every iteration of i, after we have filled the first index.

            for(int j=0; j<n; j++){
                if(i != j){           /// The most important base case for this Program !!
                product = product * arr[j];
                }
            }
            result[i] = product;  // Store the answer of Product on that particular index in our new Array. Product stores the actual value not the index. Thats why its not arr[product].
        }
        return result;
    }
}
