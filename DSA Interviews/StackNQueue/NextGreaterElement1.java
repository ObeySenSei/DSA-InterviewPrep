package StackNQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/// Using Stack and HashMap

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};    int n = nums2.length;

        int[] result = new int[nums1.length];       /// Creates an array of the same size as nums1. Remember the size needs to be the same.

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                hashmap.put(nums2[i], -1);            // Say insert value 2 and its NGE -1. hashmap.put (2, -1)
            } else {
                hashmap.put(nums2[i], stack.peek());  // Say insert value 3 and its NGE 4. hashmap.put (3, 4)
            }

            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            result[i] = hashmap.get(nums1[i]);      ///  Ok, so use the Result keyword (name of the array to place values inside it)
        }                                           ///  map.get(key) retrieves the value with the associated key in our Hashmap
                                                    ///  and places its value in our resultant array.
        System.out.println(Arrays.toString(result));
    }
}



/**

  result[i] = hashmap.get(nums1[i]);

  nums1[i] → the key  meaning
  nums1[0] has value 4.
  map.get(4) retrieves the NGE of 4 inside our hashmap which is -1.

 */
