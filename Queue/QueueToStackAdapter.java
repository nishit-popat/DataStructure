import java.util.ArrayDeque;
import java.util.Queue;

/*
    1. You are required to complete the code of our QueueToStackAdapter class. 
    2. As data members you've two queues available - mainQ and helperQ. 
    mainQ is to contain data and helperQ is to assist in operations.
    3. Here is the list of functions that you are supposed to complete
     3.1. push -> Should accept new data in LIFO manner.
     3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
      Stack underflow" and return -1.
     3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
     underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
    4. Input and Output is managed for you.

Note -> push and size should work in constant time. pop and top should work in linear time.
*/
public class QueueToStackAdapter {

    public static class QueueToStack {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStack() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);

        }

        int pop() {
            if (size() == 0) {
                return -1;
            }
            while (mainQ.size() > 1) {
                int temp = mainQ.remove();
                helperQ.add(temp);
            }
            int x = mainQ.remove();
            mainQ = helperQ;
            return x;
        }

        int top() {
            if (size() == 0) {
                return -1;
            }
            while (mainQ.size() > 1) {
                int temp = mainQ.remove();
                helperQ.add(temp);
            }
            int x = mainQ.peek();
            helperQ.add(x);
            mainQ = helperQ;
            return x;
        }
    }

    public static void main(String[] args) {

        QueueToStack qu = new QueueToStack();
        qu.push(10);
        qu.push(20);
        qu.push(30);

        System.out.println(qu.pop());
    }

}
