// https://leetcode.com/problems/find-the-duplicate-number/description/
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        int result = findDuplicate(arr);
        System.out.println("The duplicate element: " + result);

    }
    public static int findDuplicate(int[] arr){

        Set <Integer> set = new HashSet<>();
        int a = -1;                             // -1 acts as a sentinel value (a flag meaning "not found yet").

        for (int i=0; i<arr.length; i++){       //  Since it's a 1D array, we only need one loop
                if(set.contains(arr[i])){
                    a = arr[i];                 // found the Duplicate
                    break;                      // no need to search further
                } else {
                    set.add (arr[i]);
                }
            }
        return a;
    }
}

/*

If we write int a;, Java's compiler looks at your code and thinks: "What if the loop never finds a duplicate?
What value will a have when we try to return it?"
Because of this, Java throws a compilation error: variable a might not have been initialized.
We must give it a starting value so the computer knows what it holds before it enters the loop.


Why -1 instead of 0 ?
The number -1 acts as a sentinel value (a flag meaning "not found yet").
Look at the constraints of the problem: Every number in the array is guaranteed to be between 1 and n
(positive integers like 1, 3, 4, 2).
Because 0 or negative numbers will never appear as actual data inside your array, -1 is a completely safe.
If we used 0, and 0 happened to be a valid number in some other problem, it would create confusion.
Using -1 makes it obvious that it's just an empty placeholder waiting to be replaced by the real duplicate.


 */
