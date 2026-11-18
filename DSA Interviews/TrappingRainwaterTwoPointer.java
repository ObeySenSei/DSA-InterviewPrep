public class TrappingRainwaterTwoPointer {
    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 3, 2, 5};
        int ans = findCapacity(arr);
        System.out.println(ans);
    }

    public static int findCapacity(int[] arr) {
        int totalCapacity = 0;
        int n = arr.length;

        int left = 0;               // Starting positions
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {       // left <= right because we need 2 values to compare.  left <= right will give 1 value, that is the same value

            if (arr[left] < arr[right]) {

                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    totalCapacity = totalCapacity + leftMax - arr[left];
                }
                left++;
            }

            else {

                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    totalCapacity = totalCapacity + rightMax - arr[right];
                }
                right--;
            }
        }
        return totalCapacity;
    }
}