import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        int [] arr = {3,4,5,6};
        int target = 7;
        int length = arr.length;
        int[] result = findTarget(arr,target,length);
        System.out.println(Arrays.toString(result));

        int [] arr1 = {7,8,9,10};
        int target1 = 15;
        int[] result1 = findTarget(arr1,target1,length);
        System.out.println(Arrays.toString(result1));


    }
    public static int[] findTarget (int[] arr, int target, int length){

        for (int i = 0; i<length; i++){
            for(int j = i+1; j<length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
}
