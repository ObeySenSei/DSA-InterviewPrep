package StackNQueue;
import java.util.Stack;
                                     /// Design a Minimum Stack using 2 Stacks
public class MinStack {

    Stack<Integer>stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int value){
        stack.push(value);                                 /// Push the current element to stack

        if(minStack.isEmpty() || value <= minStack.peek()){    /// Insert elements when either minStack is empty or value of the element is less than the current top element in minStack.
            minStack.push(value);
        }
    }
    public void pop (){
        int recent = stack.pop();        // Using a variable to compare the recently removed element from Stack.

        if(recent == minStack.peek()){
            minStack.pop();              // Only then, remove the same element from both Stack and minStack.  Say 3 is present in Stack but in minStack only 1 is preset, and since only one element is present, no need to perform pop() operation in minStack.
        }
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);
        ms.push(4);

        System.out.println("Top: " + ms.top());
        System.out.println("Minimum: " + ms.getMin());

        ms.pop();

        System.out.println("Top after pop: " + ms.top());
        System.out.println("Minimum after pop: " + ms.getMin());

        ms.pop();

        System.out.println("Top after pop: " + ms.top());
        System.out.println("Minimum after pop: " + ms.getMin());
    }
}
