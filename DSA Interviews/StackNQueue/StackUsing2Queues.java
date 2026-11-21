package StackNQueue;
import java.util.Queue;
import java.util.LinkedList;
public class StackUsing2Queues {

    public static void main(String[] args) {               ///  Stack using 2 Queues (Costly Push)

        MyStack stack = new MyStack();

        stack.push(1);       // Push elements
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());         // Display top element

        System.out.println("Pop: " + stack.pop());         // Pop elements
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Is Empty: " + stack.empty());  // Check whether stack is empty
    }
}

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {

        while (!q1.isEmpty()) {             ///  While q1 is not empty ,   only then this loop executes or else this while block is skipped
            q2.offer(q1.poll());         ///  Cut current elements from q1 and offer (paste it inside q2)
        }

        q1.offer(x);                     /// Insert new element into q1

        while (!q2.isEmpty()) {            ///  While q1 is not empty , cut current elements from q2 and offer (paste it inside q1).
            q1.offer(q2.poll());
        }
    }

    public int pop() {                     ///  Displays the popped element
        return q1.poll();
    }

    public int top() {                    ///  Shows the element at the top
        return q1.peek();
    }

    public boolean empty() {             ///  Checks if the Queue is empty
        return q1.isEmpty();
    }
}
