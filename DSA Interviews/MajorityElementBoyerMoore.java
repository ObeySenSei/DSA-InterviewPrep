
public class MajorityElementBoyerMoore {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 1, 1};        //  {3, 1, 2, 2, 3, 3, 3};
        int result = findMajorityElement(arr);
        System.out.println("Majority Element: " + result);
    }

    public static int findMajorityElement(int[] arr) {
        int ans = 0;                      // This will contain the number that appears the most in the end
        int count = 0;

        for (int i=0 ; i<arr.length; i++){
            if(count == 0){               // If the value of count becomes 0, set the next number or our initial number as the ANS.
                ans = arr[i];
            }
            if (ans == arr[i]){           // If 1==1 or say 3==3, then increment, count = 1;   Automatic !!
                count++;
            } else {
                count--;
            }
        }

// Phase 2: Verify if the ans actually appears > n / 2 times (Only required if the array is not guaranteed to have a majority element)

        int verifyCount = 0;
        for (int i : arr) {
            if (i == ans) {
                verifyCount++;
            }
        }
        if (verifyCount > arr.length / 2) {
            return ans;
        }
        
        return -1;
    }
}

/**
 Majority element must appear strictly more than n/2 times.

 n/2 = 6/2 = 3

 But 3 appears exactly 3 times, not more than 3.
 Therefore, 3 is NOT a majority element.

 Remember this distinction
 - Majority element: More than 50%.
 - Most frequent element: Appears more times than any other element.
 */