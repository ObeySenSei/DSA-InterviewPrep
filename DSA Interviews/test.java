
public class test {
    public static void main(String[] args) {
        int arr[] = {3, 1, 3, 4, 2};            // [0,1,2,3,4] visualize the indices like this.  Linked List [0,3,4,2,3].
        int result = findDuplicate(arr);
        System.out.println("Duplicate Element: " + result);
    }

    private static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];

        } while (slow != fast);

        fast = arr[0];
        while(slow != fast){
            slow =arr[fast];
            fast = arr[fast];
        }

        return slow;
    }
}
