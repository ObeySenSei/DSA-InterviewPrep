package StackNQueue;
import java.util.Stack;

public class QueueUsing2Stacks {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        // Insert elements
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // Display front element
        System.out.println("Front: " + queue.peek());

        // Remove elements
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());

        // Check whether queue is empty
        System.out.println("Is Empty: " + queue.empty());
    }
}

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {

        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Insert new element into s1
        s1.push(x);

        // Move all elements back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
/*
 Stack insert operations involve the keyword           : PUSH
 Stack delete and paste operations involve the keyword : POP

 */

