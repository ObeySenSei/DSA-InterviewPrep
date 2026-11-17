import java.util.Arrays;
public class MergeSortedArray{
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        int[] result = mergeArray(nums1,m,nums2,n);     ///  We are assigning the returned array reference to result. NOT creating a new array. Both variables point to the same array in memory.
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergeArray(int[] nums1, int m, int[] nums2, int n) {

        // Initialize your 3 pointers
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Compare elements from the end
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {                     // This loop executes if nums1[i] <= nums2[j]. Basically, the Element from nums2 is copied
                nums1[k] = nums2[j];
                j--;
            }

            k--;                         // irrespective of whichever operation is performed, we have to decrement k.
        }

        while (j >= 0) {                 // If nums is exhausted that is  i = -1, Copy remaining elements of nums2  into nums1.
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        return nums1;          // return the modified nums1 array.
    }
}

/**

 If nums2 has remaining elements, we copy them into the remaining positions of nums1 to complete the merge, in that exact order
 Because we know the remaining elements have already been sorted in a Non-decreasing order.


 To test other cases:
 nums1 = [4, 5, 6, 0, 0, 0]
 nums2 = [1, 2, 3]

 If both elements are equal, the else block executes and takes the element from nums2.
 This is perfectly valid because both arrays are sorted and equal elements can appear in either order.


 */