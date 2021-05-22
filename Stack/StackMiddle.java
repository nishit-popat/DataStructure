/* Design a stack with operations on middle element
 How to implement a stack which will support following operations in O(1) time complexity?
 1) push() which adds an element to the top of stack.
 2) pop() which removes an element from top of stack.
 3) findMiddle() which will return middle element of the stack.
 4) deleteMiddle() which will delete the middle element.
 Push and pop are standard stack operations. 

here we have to implement above operations in O(1)
we cannot use array because in delete opration we have to shift all the elements which will take O(n) time
so we we have to use linked list
if we use singly linked list we cannot go backward
so we will use doubly linked list to implement stack

here i have implemented first three methods
deletion can be done according to the count on basis of even or odd

if stack is
5
4
3
2
1
mid = 3

if stack is 
4
3
2
1
mid = 3

*/
//doubly linkedlist node
class Node {
    Node prev;
    Node next;
    int val;

    Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

public class StackMiddle {

    Node head; //head to the stack
    Node mid;  //mid pointer
    int count = 0;

    void push(int val) {

        Node new_node = new Node(val);

        if (head == null) {
            head = new_node;  
            mid = new_node;
            count++;
        } else {
            head.prev = new_node;  //here previous means the node which is top of current node 
            new_node.next = head;  //here next means the node which is below current node
            count++;
            if (count % 2 == 0) {
                mid = mid.prev;
            }
            head = head.prev;

        }

    }

    int pop() {

        if (count == 0) {
            System.out.println("Stack is Empty");
            return -1;
        }

        else {
            int data = head.val;
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
            count--;

            if (count % 2 == 0) {
                mid = mid.next;
            }

            return data;

        }

    }

    int getMiddle() {
        return mid.val;
    }

    void deleteMiddle() {
        if (count == 0) {
            System.out.println("Stack is empty");
        } else if (count == 1) {
            head.prev = null;
            head.next = null;
            mid = null;
            count--;
        } else if (count == 2) {
            head = head.next;
            head.prev = null;
            mid = mid.next;
            count--;
        } else if (count % 2 != 0) {
            mid.next.prev = mid.prev;
            mid.prev.next = mid.next;
            mid = mid.prev;
            count--;
        } else {
            mid.next.prev = mid.prev;
            mid.prev.next = mid.next;
            mid = mid.next;
            count--;
        }
    }

    void printStack() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <- ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackMiddle s = new StackMiddle();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printStack();

        s.deleteMiddle();
        s.printStack();

        s.deleteMiddle();
        s.printStack();

        s.deleteMiddle();
        s.printStack();

        System.out.println(s.getMiddle());

        s.deleteMiddle();
        s.printStack();
        // System.out.println("Popped element: " + s.pop());
        // System.out.println("Popped element: " + s.pop());
        // System.out.println("Mid: " + s.getMiddle());
    }

}