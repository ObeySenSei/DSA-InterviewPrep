package StackNQueue;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {      ///  <= to include duplicate elements
            minStack.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();

        if (removed == minStack.peek()) {  // If the current value i just removed from stack is == to current top element in my minStack, then pop.
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
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
