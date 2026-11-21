package StackNQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.top();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.empty();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

class test1{

    public void push(int x){
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }

    }
    public int pop(){
        return q1.poll();
    }
    public int top(){
        return q1.peek();
    }
    public boolean empty(){
        return q1.isEmpty();
    }


}


    }
}
