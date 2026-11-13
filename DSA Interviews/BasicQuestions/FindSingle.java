package BasicQuestions;   // Should solve the Question in a single run (Linear Search) O(N)

public class FindSingle {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = findElement(arr);
        System.out.println("Duplicate in the first Array: " + ans);

        int[] arr2 = {2, 2, 1};
        int ans2 = findElement(arr2);
        System.out.println("Duplicate in the second Array: " + ans2);

    }

    public static int findElement (int[] arr){

        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            ans = ans ^ arr[i];            // Initially it will be ans = 0 ^ 4;  then 4 ^ 1 and so on.
        }
        return ans;
    }

}
