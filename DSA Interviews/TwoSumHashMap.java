import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumHashMap {
    public static void main(String[] args) {
        int[] nums = {3, 9, 11, 12, 15};
        int target = 12;
        int[] result = findTarget(nums,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findTarget(int[] nums, int target){
        Map <Integer,Integer> newMap = new HashMap<>();            // HashMap initialization

        for (int i=0; i<nums.length; i++) {
            int second = target - nums[i];      // We can also use int candidate;  nums[i] is basically 'first' ->  second = target - first;

            if (newMap.containsKey(second)) {         // If our Hashmap contains the second value,
                return new int[]{newMap.get(second), i};  // Fetch the "INDEX" value of the "Candidate" from the map using .get  newMap.get(second) → The index of the previously encountered element (second) stored in the HashMap
            } else {                                      // and  i  is basically the index of the current element we are at (first).  // This is simply the index of the loop iteration you are currently sitting on right now (your current number).
                newMap.put(nums[i], i);                   // Else we put unmatching numbers and their indices inside our hashmap.
            }
        }
        return new int[] {-1,-1};                         // or Return new int[] {}; if no pair is found.
    }
}

/*

    Here we use an Unordered Map, to store the values as well as their indices which do not match our Target.
    As soon as we find a Number that returns a value == Target. We return that number and its index value.

numMap.containsKey(complement) - Checks if a specific key already exists in the map.
Return value: Returns true if the key is found, and false otherwise.

In our code: We use this to ask: "Have we already seen the number needed to reach our target?"
(e.g, if target is 9 and current number is 2, it checks if 7 is already saved in our map).


numMap.get(complement) - Looks up a key in the map and returns its associated value.
Return value: Returns the value linked to that key (or null if the key isn't found).
In our code: Since we stored our map as [number, index], passing the complement as the key gives us back its index in the array so we can return it alongside the current index.


numMap.put(nums[i], i)
What it does: Inserts a new key-value pair into the map.
In our code: If the complement wasn't found, we save the current number and its index into the map for future iterations to check against.


// Return the actual numbers instead of their indices
    return new int[]{second, nums[i]};

 */