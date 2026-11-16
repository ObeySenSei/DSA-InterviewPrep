import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> result = threeSum(arr);
        System.out.println(result);

    }
    public static Set<List<Integer>> threeSum(int[] arr){
        Set<List<Integer>> list = new HashSet<>();

        for(int i=0;i< arr.length; i++){
            Set<Integer> hashset = new HashSet<>();   /// Stores previously visited elements to check whether the required third number exists and completes the triplet.

            for(int j=i+1; j<arr.length; j++){
                int third = - (arr[i] + arr[j]);

                if(hashset.contains(third)){
                    //Create another list to store the triplets
                    List<Integer> triplets = Arrays.asList(arr[i],arr[j],third);   ///  Arrays.asList() creates a List containing the three supplied elements in exactly the order they are passed. (Sequentially)

                    Collections.sort(triplets);         /// We sort the list to avoid duplicates
                    list.add(triplets);                    ///  And after sorting we remove the Elements. list.add(triplets) inserts the sorted triplet into the HashSet.If an identical triplet already exists, the HashSet simply rejects the duplicate.
                }

                hashset.add(arr[j]);    /// the HashSet will contain all the elements from [0, 1, 2, -1, -4] for the first iteration i. These values will be used to compare if the third number exists.
            }                          /// the HashSet stores these elements one by one during the inner loop.
        }
        return list;
    }
}
/*

hashset.add(arr[j]);
That's why we check first and add afterward.
 */