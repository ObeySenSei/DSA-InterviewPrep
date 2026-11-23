package StackNQueue;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer>stack = new Stack<>();
        int maxA = 0;

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();         // height[0] value: 2 > 1 = true; so we Pop because we only need the boundary of the smaller element.
            }

            if(stack.isEmpty()){
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();         // 2 > 1 = true; so we Pop because we only need the boundary of the smaller element.
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for(int i=0; i<n; i++){
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            if(area>maxA){
                maxA = area;
            }
        }
        System.out.println(maxA);

    }
}
