public class ContainerWithMostWaterTwoPointer {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = 0;

        int left = 0;                       // Starts at the first index
        int right = height.length - 1;      // Starts at the last index

        while (left < right) {
            int width = right - left;      //  (similar to j-i)

            int minHeight = Math.min(height[left], height[right]);   //  Find the shorter height between both boundaries that will hold the water
            int currentArea = width * minHeight;

            if (currentArea > maxArea) {
                maxArea = currentArea;                                // maxArea = Math.max(maxArea, currentArea);
            }

            // Move the pointer at the shorter boundary
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;                 //  RIGHT -- !!
            }
        }
        System.out.println("Maximum amount of water than can be held:  " + maxArea);
    }
}

/*

Why do we move the pointer at the shorter line?   height[left] = 8;   height[right] = 7;
Current area: Area = 7x7 = 49


Now imagine moving the left pointer (height 8): Width decreases from 7 to 6.
The right boundary is still 7.
The new limiting height cannot exceed 7. Therefore, the new area cannot exceed the previous area of 49.

New positions:
left = 2 → height = 6
right = 8 → height = 7

New area:
(8-2)(6,7)
6 x 6 = 36

which is less than the previous value of 49. So moving the taller pointer cannot give us a better result.
*/


