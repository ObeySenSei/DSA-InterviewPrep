import java.util.*;

public class ThreeSumHashing {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static Set<List<Integer>> threeSum(int[] arr){
        Set<List<Integer>> result = new HashSet<>();           //  Create a HashSet to store unique triplets. Each triplet is stored as a List of three integers.

        for(int i=0; i<arr.length; i++){
            Set<Integer> hashset = new HashSet<>();        // Its job is to temporarily store numbers encountered during the inner loop..Each time the j loop finishes, the hashset RESETS itself to empty.

            for(int j=i+1; j<arr.length; j++){
                int thirdNum = - (arr[i] + arr[j]);       // Calculate the required third element so that nums[i] + nums[j] + third = 0

                if (hashset.contains(thirdNum)){
                    List<Integer> triplet = Arrays.asList(arr[i],arr[j],thirdNum);   // Store the three elements in a List.

                    Collections.sort(triplet);     // We sort the triplet into a consistent order so that equivalent triplets have the same arrangement.
                    result.add(triplet);               // HashSet automatically prevents duplicate triplets
                }
                hashset.add(arr[j]);                  // It adds one element at a time, to check whether the required third number  exists. And this hashsets resets after j loops ends. That is in when i become 1 - arr[1].arr[2] etc.
            }
        }
        return result;
    }
}
