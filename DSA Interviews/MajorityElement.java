public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1};
        int result = findMajorityElement(nums);
        System.out.println("Majority Element: " + result);
    }

    public static int findMajorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {          // Outer loop: Pick each element one by one
            int count = 0;

            for (int j = 0; j < n; j++) {      // Inner loop: Count occurrences of nums[i] across the whole array
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {              // Check if the frequency exceeds n / 2
                return nums[i];
            }
        }
        return -1;                  // Return -1 if no majority element exists
    }
}

/*
Complexity AnalysisTime Complexity: O(n^2) because for every element (n), the inner loop scans the entire array (n) again.

Space Complexity: O(1) because no extra data structures are used. Only a few integer variables (n, count, i, j).


if (nums[j] == nums[i])
    count++;
nums[i] is the candidate element picked by the outer loop.
nums[j] is the element being inspected as the inner loop scans through the entire array.


if (count > n / 2) {              Check if the frequency exceeds n / 2
    return nums[i];              ✅ Correct: 'i' points to the valid candidate element
}


We only need to check the frequency after counting all occurrences.
That is why we wait for the j loop to finish and then execute our   if (count > n / 2)   statement   inside the i (outer loop).
 */