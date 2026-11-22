package StackNQueue;
import java.util.Stack;

public class MinStackUsingOneStack {

    Stack<Integer> stack = new Stack<>();
    int minVal;

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(val);           // Push the item if stack is empty
            minVal = val;                   // Make it the minVal
        }
        else if (val < minVal) {
            stack.push(2 * val - minVal);
            minVal = val;
        }
        else {                              // 3rd case (else) handles a normal push when the new value is NOT smaller than the current minimum.
            stack.push(val);           // Just store that larger element in the stack without encoding.
        }
    }

    public void pop() {

        int top = stack.pop();            // Element is removed using stack.pop, but then we need to update minVal.
        if (top < minVal) {
            minVal = 2 * minVal - top;    // minVal basically gets updated here after the removal of the previous minVal. i.e  2 -> 3
        }
    }

    public int top() {
        if (stack.peek() < minVal) {      //  See your copy , after inserting all the elements when 1 < 2, then we return 2. 2 is the original number, 1 is the encoded value.
            return minVal;
        }
        return stack.peek();              // Else return some other original element at the top of the stack.
    }

    public int getMin() {
        return minVal;
    }

    public static void main(String[] args) {

        MinStackUsingOneStack ms = new MinStackUsingOneStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top: " + ms.top());
        System.out.println("Minimum: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Minimum: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Minimum: " + ms.getMin());
    }
}
/**
  Push -> Pop -> Top -> getMin
 */