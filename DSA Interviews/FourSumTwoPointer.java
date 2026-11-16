import java.util.*;
public class FourSumTwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(arr,target);
        System.out.println(result);
    }

    public static List<List<Integer>> fourSum(int[] arr, int target){

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {    /// can also be arr.length-3 , since there needs to be atleast 4 elements at the end including i.
            if(i>0 && arr[i]==arr[i-1]) continue;

            for (int j = i + 1; j < arr.length; j++) {   /// Additional j loop.     j < arr.length - 2; because j will always come at the last 2nd index position.
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;     /// Skip duplicate second elements

                // Only the values of these two variables will keep changing inside the loop for the same iterations of i and j.

                int left = j + 1;             /// Only Modification : Because left must start immediately after the second fixed element.
                int right = arr.length - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] +arr[left] + arr[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target){
                        right--;
                    } else {
                        list.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;

                        while (left<right && arr[left]==arr[left-1]){
                            left++;
                        }
                        while (left<right && arr[right]==arr[right+1]){     ///  Skip duplicate third elements (This decrement happens only if the new right element is a duplicate of the previous right element.[]-2, 0, 2, 2])
                            right--;
                        }
                    }
                }
            }
        }
        return list;
    }
}

/**

 Loop	                           Purpose

 i < arr.length - 3	          Fix first element
 j = i + 1	                  Fix second element
 left = j + 1	              Start third element
 right = arr.length - 1       Start fourth element


 Use long for the sum
 long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];


  For each fixed pair (i, j), the left and right pointers
  move inward to find the remaining two elements.



 */