import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,1,1};
        int result = findElement(arr);
        System.out.println(result);
    }
    public static int findElement(int[] arr){

        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=0; j<arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if(count > arr.length/2){             //  If 4 is greater than 3    i.e (7/2), then
                return arr[i];                     //  return that value that appeard 4 times.

            }
        }
        return -1;
    }
}


