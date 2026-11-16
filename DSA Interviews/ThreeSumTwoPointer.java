import java.util.*;
public class ThreeSumTwoPointer {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] arr){

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);    // sort the array immediately

        for(int i=0; i<arr.length; i++) {    // can also be arr.length-2 , since there needs to be atleast 3 elements at the end to form the Triplet.

            if(i>0 && arr[i]==arr[i-1]){      /// Skip duplicate first elements
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];        /// you can also use  direct if (arr[i] + arr[left] + arr[right] < 0)
                if (sum < 0) {
                    left++;                 // We need a bigger value
                } else if (sum > 0){
                    right--;              // We need a smaller value  (Remember in a sorted array, the largest numbers are stored at the end.
                } else {
                    list.add(Arrays.asList(arr[i],arr[left],arr[right]));   // basically if (sum == 0)
                    left++;
                    right--;

                    while (left<right && arr[left]==arr[left-1]){       ///  Skip duplicate second elements
                        left++;
                    }
                    while (left<right && arr[right]==arr[right+1]){     ///  Skip duplicate third elements (This decrement happens only if the new right element is a duplicate of the previous right element.[]-2, 0, 2, 2])
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
