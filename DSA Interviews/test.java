import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 2, 3, 3, 3};
        int result = findTarget(arr);
        System.out.println(result);
    }

    public static int findTarget (int[] nums){
        int ans = 0;
        int count = 0;

        for (int i=0; i < nums.length; i++){
            if (count == 0){
                ans = nums[i];
            }
            if(ans == nums[i]){        // If the ans is equal to our current ans;
                count++;
            } else {
                count--;
            }
        }
        int n = nums.length;
        int verify = 0;
        for(int i : nums){
            if(ans == i){
                verify++;
            }
        }
        if (verify > n/2){
            return ans;
        }
        return -1;
    }
}

