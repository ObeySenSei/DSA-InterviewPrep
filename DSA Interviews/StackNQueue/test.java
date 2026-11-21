package StackNQueue;

import java.util.Queue;
import java.util.Stack;

public class test{
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(3);
        queue.push(2);
        queue.push(1);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(queue.empty());

    }
}
class test1{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        while(!s1.empty()){
            s2.push(s1.pop());    // Remove elements from s1 and paste it to s2.
        }
        s1.push(x);               // Else just insert the element if my Stack is empty

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    public int pop1 (int x){
        return s1.pop();
    }
    public int peek1(int x){
        return s1.peek();
    }
    public boolean empty1(){
        return s1.isEmpty();

    }

}