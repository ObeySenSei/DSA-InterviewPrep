import java.util.Arrays;

public class SortColours {                          ///  Counting Approach
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        int[] result = sortArr(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sortArr(int[] arr){
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i=0; i<arr.length; i++){        // Phase 1: Count occurrences
            if (arr[i] == 0){
                countZero++;
            } else if (arr[i] == 1){
                countOne++;
            } else {
                countTwo++;
            }
        }

        int index = 0;                            // Phase 2: Overwrite the array
        for (int i=0; i<countZero; i++){          // Lets says count 0 is 2; then i will print at indices 0 and 1.
            arr[index] = 0;
            index++;
        }
        for (int i=0; i<countOne; i++){
            arr[index] = 1;
            index++;
        }
        for (int i=0; i<countTwo; i++){
            arr[index] = 2;                       // or we can write arr[index++] = 2;
            index++;
        }
        return arr;
    }
}
