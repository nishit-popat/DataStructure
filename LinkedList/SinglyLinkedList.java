public class SinglyLinkedList {

    public static class Node{
        int data;
        Node next;
     
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static class LinkedList{

        Node head = null;
        Node tail = null;
        int size;

        void addLast(int val){
            Node newNode = new Node(val);
            newNode.data = val;

            if(size == 0){            
                newNode.next = null;
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        void addFirst(int val){
            Node newNode = new Node(val);
            newNode.data = val;

            if(size == 0){            
                newNode.next = null;
                head = tail = newNode;
            }
            else{
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        

        void display(){
            //int temp = size;
            Node t = head;
            while(t != null){
                System.out.print(t.data + " ");
                t = t.next;
            }
            System.out.println();
        }

        void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }
            else if(head == tail){
                head = tail = null;
                size--;
            }
            else{
                head = head.next;
                size--;
            }    
        }

        void removeLast(){
            if(size == 0){
                System.out.println("List is empty");
            }
            else if(head == tail){
                head = tail = null;
                size--;
            }
            else{
                Node temp = head;
                while(temp.next.next != null){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
            
        }
        int getFirst(){
            if(size == 0){
                return -1;
            }
            return head.data;
        }

        int getLast(){
            if(size == 0){
                return -1;
            }
            return tail.data;
        }

        int getAt(int index){
            if(size == 0){
                return -1;
            }
            Node temp = head;
            while(index>0){
                temp = temp.next;
            }
            return temp.data;
        }

        void addAt(int idx, int val){
            if(idx < 0 || idx > size){
                System.out.println("Invalid arguments");
            }
            else if(idx == 0){
                addFirst(val);
            }
            else if(idx == size){
                addLast(val);
            }
            else{
                Node temp = head;
                for(int i=0;i<idx-1;i++){
                    temp = temp.next;
                }
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        private Node getNodeAt(int index){
            if(size == 0){
                return null;
            }
            Node temp = head;
            while(index>0){
                temp = temp.next;
                index--;
            }
            return temp;
        }


        void reverseIteratively(){
            int left = 0;
            int right = size-1;

            while(left < right){
                Node leftNode = getNodeAt(left);
                Node rightNode = getNodeAt(right);

                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;

                left++;
                right--;
            }
        }   

    }

    public static void main(String[] args) {
        //System.out.println("hi");
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.display();

        list.reverseIteratively();
        list.display();
    }
}
