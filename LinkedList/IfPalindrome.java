import java.util.LinkedList;

public class IfPalindrome{

    public static class Node{
        int data;
        Node next;
     
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("hi");
        LinkedList<Node> l = new LinkedList<>();

        Node head = new Node(5);

        l.add(head);
        l.add(new Node(10));
        l.add(new Node(20));
        l.add(new Node(30));
        l.add(new Node(40));

        isPalindrome(head);
        
    }

    public static void isPalindrome(Node head){
        
        // first find size of the linked list
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
        }

        int halfSize = size/2;

        Node secondStart = head; // this will point to the starting point of second half
        Node prev = secondStart;
        // now reverse the second half of the linked list
        if(size%2 == 0){
            for(int i=0;i<(halfSize-1);i++){
                secondStart = secondStart.next; 
                prev = secondStart;
            }
        }
        else{
            for(int i=0;i<halfSize;i++){
                secondStart = secondStart.next;
                prev = secondStart;
            }
        }

        // now halfSize is pointing to starting point of second half and temp node is pointing to the end of second half
        // prev is pointing to secondStart

        while(secondStart != null){
            
            Node t = secondStart.next;
            secondStart.next = prev;
            
            prev = secondStart;
            secondStart = t;
        }
        
        // just printing linked list
        Node s = head;
        while(s != null){
            System.out.println(s.data + "   " + s.next.toString());
            s = s.next;
        }
        

    
    }
}