// Floyd's Tortoise and Hare Algorithm (Cycle-Find)

public class FindDuplicateSlowFast {
    public static void main(String[] args) {
        int arr[] = {3, 1, 3, 4, 2};           // [0,1,2,3,4] visualize the indices like this.  Linked List [0,3,4,2,3].
        int result = findDuplicate(arr);
        System.out.println("Duplicate Element: " + result);
    }

    public static int findDuplicate(int[] arr){
        int slow = arr[0];                  // Initialize slow to point to the value at the first index
        int fast = arr[0];

        do {
            slow = arr[slow];               // slow = 3 i.e value at index arr[0]. +1 step
            fast = arr[arr[fast]];          // arr[arr[0]] -> arr[3] -> 4.         +2 step
        } while (slow != fast);             // And once they both point to the same element , our loop will stop.

        //  The exact spot where they crash into each other a second time is our duplicate number !

        fast = arr[0];                 // Then we initiate our fast pointer back to arr[0].
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];         // This time we increment fast by +1 steps
        }

        return slow;                  // The next time a cycle is detected it will point to the starting position of our Cycle which will
                                     // contain our duplicate element.
    }
}