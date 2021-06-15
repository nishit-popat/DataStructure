/*
Given an integer K and a queue of integers, 
we need to reverse the order of the first K elements of the queue, 
leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.

Example 1:
Input:
5 3
1 2 3 4 5
Output: 
3 2 1 4 5
Explanation: 
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.

Example 2:
Input:
4 4
4 3 2 1
Output: 
1 2 3 4
Explanation: 
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKelementsofQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        int k = 3;
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        Queue<Integer> ansq = modifyQueue(q, k);
        System.out.println(ansq.toString());

    }

    private static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            int x = q.remove();
            st.push(x);
        }

        //System.out.println(st.toString());

        ArrayList<Integer> arr = new ArrayList<>();
        while (q.size() > 0) {
            int x = q.remove();
            arr.add(x);
        }

        //System.out.println(q.toString());

        while (!st.isEmpty()) {
            int x = st.peek();
            q.add(x);
            st.pop();
        }
        //System.out.println(q.toString());

        for (int i = 0; i < arr.size(); i++) {
            q.add(arr.get(i));
        }

        return q;
    }
}