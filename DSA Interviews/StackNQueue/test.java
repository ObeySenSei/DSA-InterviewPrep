package StackNQueue;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String str = "level";

        Queue<Integer> q = new LinkedList<>();
        Map<Character,Integer> hashmap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(hashmap.containsKey(ch)){
                hashmap.put(ch,hashmap.get(ch) + 1);   // increment the already found character for the key
            } else {
                hashmap.put(ch,1);
            }
            q.offer(i);     // Insert the index no. into the queue

            while(!q.isEmpty() && hashmap.get(str.charAt(q.peek())) > 1){
                q.poll();
            }
        }
        if(q.isEmpty()){
            System.out.println(-1);  // no valid character was found
        } else {
            System.out.println(q.peek());   // return the index of the element at the front of the queue after all the remove operations
        }

    }
}
