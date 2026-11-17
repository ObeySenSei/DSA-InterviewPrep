import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int n = 3;
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int[] result = mergeArray(nums1,n,nums2,m);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeArray(int[] nums1, int n, int[]nums2, int m){
        // Initialize your 3 pointers
        int i = n - 1;
        int j = m - 1;
        int k = (m + n) - 1;

        while (i>=0 && j>=0){

            if (nums1[i] > nums2[j] ){    // If the last element in Nums1 is greater than the last element in Nums2
                nums1[k] = nums1[i];      // The last index of Nums1 is filled with the larger element.
                i--;

            } else {                      // This loop executes if nums1[i] <= nums2[j]. Basically, the Element from nums2 is copied
                nums1[k] = nums2[j];
                j--;
            }
            k--;                          // irrespective of whichever operation is performed, k is decremented.
        }

        while(j>=0){
            nums1[k] = nums2[j];         // If i is exhausted, that is if it reaches -1, copy the remaining elements from j into Nums1.
            k--;
            j--;
        }
        return nums1;
    }
}
