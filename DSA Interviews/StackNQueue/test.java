package StackNQueue;

import java.util.*;

public class test {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        int n = arr.length;
        Stack <Integer> stack = new Stack<>();

        for(int i=0;i <n; i++){
            stack.push(i);
        }
        while(stack.size() > 1 ){
            int a = stack.pop();
            int b = stack.pop();

            if(arr[a][b] == 1){
                stack.push(b);
            }else{
                stack.push(a);
            }
        }
        int candidate = stack.pop();
        int rowSum = 0;
        int colSum = 0;
        for (int i=0; i<n; i++){
            rowSum = rowSum + arr[candidate][i];
            colSum = colSum + arr[i] [candidate];
        }

       if (rowSum == 0 && candidate == n-1){
           System.out.println(candidate);
       } else {
           System.out.println(-1);
       }
    }
}





