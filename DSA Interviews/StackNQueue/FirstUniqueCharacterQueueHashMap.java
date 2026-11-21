package StackNQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacterQueueHashMap {
    public static void main(String[] args) {
        String str = "level";

        Queue<Integer> q = new LinkedList<>();    // Use a class that implements the Queue interface, such as LinkedList or ArrayDeque.
        HashMap<Character,Integer> hashmap = new HashMap<>();         // character stores  'l' and integer stores its total frequency '2'

        for (int i=0; i<str.length(); i++) {

            char ch = str.charAt(i);                                           /// Selects the first character

            if (hashmap.containsKey(ch)) {
                hashmap.put(ch, hashmap.get(ch) + 1);                          /// There's a one line below
            } else {
                hashmap.put(ch, 1);
            }

            q.offer(i);                        /// Also Store the current index (not ch) inside Queue. Stores index 0 initially.

            while (!q.isEmpty() && hashmap.get(str.charAt(q.peek())) > 1) {     // q.peek - q.front    q.poll()  q.pop()   get the character at the front of the queue and pop it if its value is > 1;
                q.poll();                        /// Remove characters that are no longer unique
            }
        }

        if (q.isEmpty()) {
            System.out.println(-1);           // no valid character was found
        } else {
            System.out.println(q.peek());     // return the index of the element at the front of the queue after all the remove operations
        }
    }
}
/*
One liner to fetch and increase values.
hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1);   Increase the frequency of the character

hashmap.get(str.charAt(q.peek())) > 1
 Basically,  hashmap.get(str.charAt(0)) -> the character is 'l' in str[0]; so hashmap looks for that character in its list of keys.
 q.peek() → returns 0 (front index).
 str.charAt(0) → 'l'.
 hashmap.get('l') → 2.



final while loop check {
Front is 0 ('l', frequency 2, greater than 1) -> q.poll() removes 0.
New front is 1 ('e', frequency 2, greater than 1) -> q.poll() removes 1.
New front is 2 ('v', frequency 1, not greater than 1) -> loop stops.
q becomes [2, 3, 4]

Loop ends when i = 5.
q is [2, 3, 4] (not empty).

q.peek() returns 2 (character 'v').

 */
