import java.util.Arrays;
public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] result = productExceptSelf(arr);
        System.out.println(Arrays.toString(result)); // Output: [24, 12, 8, 6]
    }
    public static int[] productExceptSelf (int[] arr){

        int n = arr.length;
        int result[] = new int[n];

        if(n==0){
            return new int[] {-1,-1};
        }

        arr[0] = 1;
        for (int i=1; i<n; i++){
            result[i] = result[i-1] * arr[i-1];     // result[0] = r[0] -> 1  * arr[0] 1*1
        }

        int product = 1;
        for(int j = n-1; j>=0; j--){
            result[j] = result[j] * product;
            product = product * arr[j];
        }
        return arr;
    }

}