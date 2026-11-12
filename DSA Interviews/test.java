import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 2};
        int result = findMajority(arr);
        System.out.println(result);
    }
    private static int findMajority(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        if(n==0){
            return arr[0];
        }

        int count = 1;

        for(int i=1; i<n; i++){
            if(arr[i] == arr[i-1]){
                count++;
            } else {
                count = 1;
            }
            if (count > n/2){
                return arr[i];
            }
        }
        return -1;
    }
}

