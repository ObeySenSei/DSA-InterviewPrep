import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                for(int k=i+2; k< arr.length; k++){

                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);   // Create a new list and store the triplets
                        Collections.sort(triplet);              // sort the arrays in ascending for comparison of Duplicates

                        if (!list.contains(triplet)){               // Only proceed if this triplet is NOT already present in the result.
                            list.add(triplet);
                        }
                    }
                }
            }
        }
        return list;
    }
}
/*
Why use a List?
Because our final result is a collection of triplets.

List<List<Integer>> result = new ArrayList<>();  result stores multiple Lists, with each List containing three integers.


Consider these two triplets:
[-1, 0, 1]
[0, 1, -1]
They contain exactly the same elements, just in different orders.
After sorting, both become:
[-1, 0, 1]  [-1, 0, 1]

if (!result.contains(triplet))   means   Only proceed if this triplet is NOT already present in the result.

 */