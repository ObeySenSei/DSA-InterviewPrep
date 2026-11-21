import java.util.Arrays;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;

        int[] result = new int[n];
        Stack<Integer> mystack = new Stack<>();

        for (int i=n-1; i>=0; i--){
            while (!mystack.isEmpty() && mystack.peek() <= arr[i]){
                mystack.pop();
            }
            if(mystack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = mystack.peek();       //
            }
            mystack.push(arr[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}