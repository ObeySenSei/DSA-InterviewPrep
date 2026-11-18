//Separate Array Approach

public class TrappingRainwater {
    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 3, 2, 5};
        int ans = findCapacity(arr);
        System.out.println(ans);
    }
    public static int findCapacity(int[] arr){
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Set the index of the first element of the LMax Array to compare values with the Original array.
        leftMax[0] = arr[0];          ///  leftMax[0] will be set to 4.
        rightMax[n-1] = arr[n-1];     ///  we start our loop from reverse to calculate rMax. So we insert an element in our rMax array = 5, so that we can compare with the original array.

        for(int i=1; i<n; i++){      /// i is set to 1 because we have an element already filled inside our lMax array i.e 4.
        leftMax[i] = Math.max (leftMax[i-1], arr[i]);         /// Most critical. Visualize why.        Compares max(4,2)
        }

        for(int i=n-2;i>=0;i--){        /// j is set to n-2 because we have an element already placed at the last index of rMAX i.e 5. We don't want to compare 5 with 5.
        rightMax[i] =  Math.max(rightMax[i+1], arr[i]);        /// This will select the last element of rMax with the last second element of original ARR. Thats why its n-2
        }

        int totalCapacity = 0;        // Question says result is non-negative.
        for(int i=0; i<n; i++){
            totalCapacity = totalCapacity + Math.min(leftMax[i], rightMax[i])    -   arr[i];
        }

        return totalCapacity;
    }
}
